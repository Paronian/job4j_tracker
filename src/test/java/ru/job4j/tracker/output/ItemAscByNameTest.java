package ru.job4j.tracker.output;

import org.junit.jupiter.api.Test;
import ru.job4j.hashmap.Label;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class ItemAscByNameTest {
    @Test
    public void whenSortedAscending() {
        List<Item> items = Arrays.asList(
                new Item("Volga"),
                new Item("Zorro"),
                new Item("Bora"),
                new Item("Ara")
        );
        List<Item> expected = Arrays.asList(
                new Item("Ara"),
                new Item("Bora"),
                new Item("Volga"),
                new Item("Zorro")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}