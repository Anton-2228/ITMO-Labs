package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class AllHit implements Iterable<Hit> {

    private ArrayList<Hit> hits;

    public AllHit() {
        this.hits = new ArrayList<>();
    }

    public void addHit(Hit hit) {
        this.hits.add(hit);
    }

    @Override
    public Iterator<Hit> iterator() {
        return hits.listIterator();
    }
}
