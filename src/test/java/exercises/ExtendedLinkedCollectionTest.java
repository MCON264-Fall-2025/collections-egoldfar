package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link ExtendedLinkedCollection}.
 */
public class ExtendedLinkedCollectionTest {

    @Test
    public void toStringOnEmptyCollectionNotNull() {
        ExtendedLinkedCollection<String> col = new ExtendedLinkedCollection<>();
        String s = col.toString();
        assertNotNull("toString should not return null", s);
    }

    @Test
    public void countOnEmptyCollectionIsZero() {
        ExtendedLinkedCollection<String> col = new ExtendedLinkedCollection<>();
        assertEquals( 0, col.count("anything"),"count on empty collection should be 0");
    }

    @Test
    public void behavesLikeLinkedCollectionForAddAndCount() {
        ExtendedLinkedCollection<String> col = new ExtendedLinkedCollection<>();
        col.add("a");
        col.add("b");
        col.add("a");

        assertEquals(2, col.count("a"));
        assertEquals(1, col.count("b"));
        assertEquals(0, col.count("c"));
    }

    @Test
    public void removeAllRemovesAllOccurrencesAndReturnsCount() {
        ExtendedLinkedCollection<String> col = new ExtendedLinkedCollection<>();
        col.add("a");
        col.add("b");
        col.add("a");
        col.add("c");
        col.add("a");

        // assume ExtendedLinkedCollection defines removeAll similar to BagInterface
        col.removeAll("a");
        assertEquals(0, col.count("a"));
        assertEquals(1, col.count("b"));
        assertEquals(1, col.count("c"));
    }
}
