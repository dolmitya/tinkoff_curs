package edu.hw3;

import edu.hw3.task7.MyComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task7Test {

    @Test
    @DisplayName("Тестирование компоратора")
    void comporator() {
        TreeMap<String, String> tree = new TreeMap<>(new MyComparator());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
