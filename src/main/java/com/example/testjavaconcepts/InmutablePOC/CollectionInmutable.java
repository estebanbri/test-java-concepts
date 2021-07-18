package com.example.testjavaconcepts.InmutablePOC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CollectionInmutable {

    private List<String> list;

    public CollectionInmutable(List<String> list) {
        // deep copy
        List<String> tempList = new ArrayList<>(list);
        this.list = tempList;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public String toString() {
        return "CollectionInmutable{" +
                "list=" + list +
                '}';
    }

}
