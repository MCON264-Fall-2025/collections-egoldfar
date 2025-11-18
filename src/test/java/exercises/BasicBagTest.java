package exercises;

import edu.touro.mcon264.apps.collections.BagInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link BasicBag} to verify that all methods from
 * {@link BagInterface} and {@link edu.touro.mcon264.apps.collections.CollectionInterface}
 * are implemented and behave consistently with a typical bag/collection
 * contract.
 */
public class BasicBagTest {

    private BasicBag<String> newBag() {
        return new BasicBag<>();
    }

    @Test
    public void implementsBagInterfaceAndCollectionInterface() {
        BasicBag<String> bag = newBag();
        assertTrue(bag instanceof BagInterface,
                "BasicBag should implement BagInterface");
    }

    @Test
    public void newlyCreatedBagIsEmpty() {
        BasicBag<String> bag = newBag();
        assertTrue(bag.isEmpty(), "New bag should be empty");
        assertEquals(0, bag.size(), "Size of new bag should be 0");
        assertFalse(bag.contains("x"), "New bag should not contain any element");
    }

    @Test
    public void addIncreasesSizeAndMakesElementVisible() {
        BasicBag<String> bag = newBag();

        assertTrue(bag.add("a"),
                "add should return true when an element is successfully added");

        assertEquals(1, bag.size());
        assertFalse(bag.isEmpty());
        assertTrue(bag.contains("a"));
        assertEquals("a", bag.get("a"));
    }

    @Test
    public void addAllowsDuplicatesAndCountReflectsMultiplicity() {
        BasicBag<String> bag = newBag();

        bag.add("a");
        bag.add("a");
        bag.add("b");

        assertEquals(3, bag.size(),
                "Size should reflect total number of elements including duplicates");
        assertEquals(2, bag.count("a"),
                "Count should reflect duplicate occurrences");
        assertEquals(1, bag.count("b"));
        assertEquals(0, bag.count("c"));
    }

    @Test
    public void removeRemovesSingleOccurrenceAndUpdatesSize() {
        BasicBag<String> bag = newBag();
        bag.add("a");
        bag.add("a");

        assertTrue(bag.remove("a"),
                "remove should succeed when target is present");
        assertEquals(1, bag.count("a"),
                "One occurrence should remain after remove");
        assertEquals(1, bag.size());

        assertTrue(bag.remove("a"),
                "remove should succeed for last remaining occurrence");
        assertEquals(0, bag.count("a"));
        assertEquals(0, bag.size());
        assertFalse(bag.contains("a"),
                "Bag should be empty after removing all elements via remove");
    }

    @Test
    public void removeReturnsFalseWhenElementNotPresent() {
        BasicBag<String> bag = newBag();
        bag.add("a");

        assertFalse(bag.remove("b"),
                "remove should return false when target is not present");
        assertEquals(1, bag.size());
    }

    @Test
    public void grabReturnsNullOnEmptyBag() {
        BasicBag<String> bag = newBag();
        assertNull(bag.grab(), "grab should return null when bag is empty");
    }

    @Test
    public void grabReturnsElementFromNonEmptyBagAndReducesSize() {
        BasicBag<String> bag = newBag();
        bag.add("a");
        bag.add("b");

        int originalSize = bag.size();
        String grabbed = bag.grab();

        assertNotNull(grabbed,
                "grab should return a non-null element from a non-empty bag");
        assertEquals(originalSize - 1, bag.size(),
                "Size should decrease by 1 after grab");
    }

    @Test
    public void removeAllRemovesAllMatchingElementsAndReturnsCount() {
        BasicBag<String> bag = newBag();
        bag.add("a");
        bag.add("b");
        bag.add("a");
        bag.add("c");
        bag.add("a");

        int removed = bag.removeAll("a");
        assertEquals(3, removed,
                "removeAll should return number of removed elements");
        assertEquals(0, bag.count("a"));
        assertFalse(bag.contains("a"));
        assertEquals(2, bag.size(), "Only b and c should remain");
    }

    @Test
    public void clearEmptiesTheBag() {
        BasicBag<String> bag = newBag();
        bag.add("a");
        bag.add("b");

        bag.clear();

        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());
        assertFalse(bag.contains("a"));
        assertFalse(bag.contains("b"));
        assertNull(bag.get("a"));
        assertNull(bag.get("b"));
    }
}
