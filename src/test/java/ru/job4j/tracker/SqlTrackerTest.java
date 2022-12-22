package ru.job4j.tracker;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenReplaceAndFindByNewIdIsReplaced() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        int id = tracker.add(item1).getId();
        item2.setId(id);
        tracker.replace(id, item2);
        assertThat(tracker.findById(id)).isEqualTo(item2);
    }

    @Test
    void whenDeleteThenFindByIdIsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        int id = tracker.add(item).getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    void whenFindAllThenGetAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        int id1 = tracker.add(item1).getId();
        item1.setId(id1);
        int id2 = tracker.add(item2).getId();
        item2.setId(id2);
        List<Item> expected = List.of(item1, item2);
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    void whenFindByNameThenGetItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        int id = tracker.add(item).getId();
        item.setId(id);
        assertThat(tracker.findByName(item.getName())).isEqualTo(List.of(item));
    }

    @Test
    void whenFindByIdThenGetItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        int id = tracker.add(item).getId();
        item.setId(id);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }
}