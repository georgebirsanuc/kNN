package knn.utils;

import java.util.Comparator;

/**
 * Created by virgil on 23.01.2016.
 */
public class Pair<U extends Comparable<U>, V extends Comparable<V>> {

    private U first;
    private V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public U getFirst() {
        return first;
    }

    public void setFirst(U first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
