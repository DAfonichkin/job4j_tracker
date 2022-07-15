package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> Math.pow(3, x) + 1);
        List<Double> expected = Arrays.asList(244D, 730D, 2188D);
        assertThat(result, is(expected));
    }

}