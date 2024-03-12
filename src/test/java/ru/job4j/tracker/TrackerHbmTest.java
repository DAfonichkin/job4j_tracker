package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @AfterEach
    public void deleteAllItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            for (Item item : tracker.findAll()) {
                tracker.delete(item.getId());
            }
        }
    }

    @Test
    public void whenAddNewItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            tracker.add(item1);
            int id = item1.getId();
            item2.setId(id);
            tracker.replace(id, item2);
            Item result = tracker.findById(id);
            assertThat(result.getName()).isEqualTo(item2.getName());
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    public void whenAddItemsFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> res = tracker.findAll();
            assertThat(res).containsExactly(item1, item2);
        }
    }

    @Test
    public void whenItemFindByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test");
            Item item2 = new Item("test");
            Item item3 = new Item("test other");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> res = tracker.findByName(item1.getName());
            assertThat(res).containsExactly(item1, item2);
        }
    }
}