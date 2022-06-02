package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when23To32Then2dot23() {
        Point a = new Point(2, 3, 0);
        Point b = new Point(0, 2, 0);
        double expected = 2.23;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when001To005Then4() {
        Point a = new Point(0, 0, 1);
        Point b = new Point(0, 0, 5);
        double expected = 4;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when226To488Then6dot63() {
        Point a = new Point(2, 2, 6);
        Point b = new Point(4, 8, 8);
        double expected = 6.63;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}