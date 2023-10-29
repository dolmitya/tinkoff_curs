package edu.hw3.task8;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {

    private Integer index;
    private final Collection<T> collection;
    private T[] mas;

    public BackwardIterator(Class<T> c, Collection<T> coll) {
        this.index = coll.size();
        this.collection = coll;
        final T[] a = (T[]) Array.newInstance(c, index);
        this.mas = a;
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        collection.toArray(mas);
        index--;
        return mas[index];
    }
}
