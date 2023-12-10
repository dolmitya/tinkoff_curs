package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {

    private Integer index = 0;
    private final List<T> list;

    public BackwardIterator(Class<T> c, Collection<T> coll) {
        this.index = coll.size();
        list = new ArrayList<>(coll);
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        index--;
        return list.get(index);
    }
}
