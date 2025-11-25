package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
    /**
     * Returns a string representation of this collection.
     * The string representation consists of a list of the collection's elements
     * in the order they are stored in the linked list, enclosed in square brackets ("[]").
     * Adjacent elements are separated by the characters ", " (comma and space).
     * 
     * @return a string representation of this collection
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        LLNode<T> current = head;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getLink() != null) {
                sb.append(", ");
            }
            current = current.getLink();
        }
        
        sb.append("]");
        return sb.toString();
    }

    /**
     * Counts the number of times the specified target element appears in this collection.
     * This method traverses the entire collection and compares each element with the target
     * using the equals method.
     * 
     * @param target the element whose occurrences are to be counted
     * @return the number of times target appears in this collection
     */
    public int count(T target) {
        int count = 0;
        LLNode<T> current = head;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                count++;
            }
            current = current.getLink();
        }
        return count;
    }

    /**
     * Removes all occurrences of the specified target element from this collection.
     * This method traverses the collection and removes every element that matches the target
     * using the equals method. The collection's size is reduced by the number of elements removed.
     * 
     * @param target the element to be removed from this collection
     */
    public void removeAll(T target) {
        LLNode<T> current = head;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                remove(current.getInfo());
            }
            current = current.getLink();
        }
    }
}
