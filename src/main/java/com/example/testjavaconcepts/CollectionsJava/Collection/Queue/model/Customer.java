package com.example.testjavaconcepts.CollectionsJava.Collection.Queue.model;

public class Customer {

    private String name;
    private Long mount;

    public Customer(String name, Long mount) {
        this.name = name;
        this.mount = mount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMount() {
        return mount;
    }

    public void setMount(Long mount) {
        this.mount = mount;
    }
}
