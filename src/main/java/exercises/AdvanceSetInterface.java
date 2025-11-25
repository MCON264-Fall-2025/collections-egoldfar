package exercises;

import edu.touro.mcon264.apps.collections.CollectionInterface;

/**
 * Advance Set Interface
 * @param <T>
 */
public interface AdvanceSetInterface <T> extends CollectionInterface<T> {
/*
 Starter code the exercise 6
 Desig signatures for the following methods:
    union()
    intersection()
    difference()
 */

    public CollectionInterface<T> union(CollectionInterface<T> other);
    public CollectionInterface<T> intersection(CollectionInterface<T> other);
    public CollectionInterface<T> difference(CollectionInterface<T> other);

}
