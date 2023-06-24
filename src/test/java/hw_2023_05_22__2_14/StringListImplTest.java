package hw_2023_05_22__2_14;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StringListImplTest {
    private final StringList stringList = new StringListImpl();

    @AfterEach
    public void afterEach() {
        stringList.clear();
    }

    @Test
    void addTest() {
        String[] elements = {"test1", "test2", "test3", "test4", "test5", "test6" };
        add(elements);

        for (int i = 0; i < elements.length; i++) {
            Assertions.assertThat(stringList.get(i)).isEqualTo(elements[i]);
            Assertions.assertThat(stringList.contains(elements[i])).isTrue();
            Assertions.assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            Assertions.assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
        }

        Assertions.assertThat(stringList.toArray()).hasSize(elements.length);
        Assertions.assertThat(stringList.toArray()).containsExactly(elements);
    }

    @Test
    void addByIndexTest() {
        String[] elements = {"test1", "test2", "test3", "test4", "test5", "test6" };
        add(elements);

        stringList.add(0, "test-0");
        Assertions.assertThat(stringList.size()).isEqualTo(elements.length + 1);
        Assertions.assertThat(stringList.get(0)).isEqualTo("test-0");

        stringList.add(3, "test-3");
        Assertions.assertThat(stringList.size()).isEqualTo(elements.length + 2);
        Assertions.assertThat(stringList.get(3)).isEqualTo("test-3");
        Assertions.assertThat(stringList.lastIndexOf("test-3")).isEqualTo(3);
        Assertions.assertThat(stringList.lastIndexOf("test-0")).isEqualTo(0);

        stringList.add(7, "test-7");
        Assertions.assertThat(stringList.size()).isEqualTo(elements.length + 3);
        Assertions.assertThat(stringList.get(7)).isEqualTo("test-7");
        Assertions.assertThat(stringList.lastIndexOf("test-7")).isEqualTo(7);
        Assertions.assertThat(stringList.lastIndexOf("test-0")).isEqualTo(0);
    }

    private void add(String[] elements) {
        Assertions.assertThat(stringList.isEmpty()).isTrue();
        Stream.of(elements).forEach(stringList::add);
        Assertions.assertThat(stringList.size()).isEqualTo(elements.length);
    }
}
