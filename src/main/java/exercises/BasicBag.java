package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    @Override
    public T grab() {
        return null;
    }

    @Override
    public int count(T target) {
        return 0;
    }

    @Override
    public int removeAll(T target) {
        return 0;
    }

    @Override
    public void clear() {

    }

    // TODO: implement the methods in the BagInterface using an array as the underlying data structure
    // consider extending ArrayCollection<T>
    // put in the JavaDoc comments as specified in the BagInterface.
    // Which SOLID principles is being applied here?


}
