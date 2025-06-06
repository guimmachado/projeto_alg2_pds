
package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Comparator;

public class TimSortTest {

    @Test
    void testTimSortIntegerAscending() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(2);
        lista.add(8);
        lista.add(1);
        lista.add(3);

        TimSort.timSort(lista, Comparator.naturalOrder());

        assertEquals(1, lista.get(0));
        assertEquals(8, lista.get(lista.size() - 1));
        assertTrue(lista.get(0) <= lista.get(1) && lista.get(1) <= lista.get(2));
    }
}
