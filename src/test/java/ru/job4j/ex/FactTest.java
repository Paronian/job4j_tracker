package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                   new Fact().calc(-4);
                });
        assertThat(exception.getMessage()).isEqualTo("n could not be less then 0");
    }

    @Test
    public void whenIsNotException() {
        int number = 4;
        int expected = 24;
        int result = new Fact().calc(number);
        assertThat(result).isEqualTo(expected);
    }
}