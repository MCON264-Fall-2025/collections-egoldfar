package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    /**
     * If this bag is not empty, removes and returns a random element of the bag;
     * otherwise returns null.
     *
     * @return a random element from this bag, or null if the bag is empty
     */
    @Override
    public T grab() {
        if(isEmpty())
            return null;
        try {
        return elements[size()-1];
        } finally {
            remove(elements[size()-1]);
        }
    }

    /**
     * Returns a count of all elements e in this collection such that e.equals(target).
     *
     * @param target the element to count occurrences of
     * @return the number of times target appears in this bag
     */
    @Override
    public int count(T target) {
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(target)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Removes all elements e from this collection such that e.equals(target)
     * and returns the number of elements removed.
     *
     * @param target the element whose occurrences are to be removed
     * @return the number of elements removed from this bag
     */
    @Override
    public int removeAll(T target) {
        int count = 0;
        while (remove(target)) {
            count++;
        }
        return count;
    }

    /**
     * Empties this bag so that it contains zero elements.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            remove(elements[0]);
        }
    }

}
