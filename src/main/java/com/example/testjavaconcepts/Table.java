package com.example.testjavaconcepts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Table {
    @JsonProperty("RECORD")
    List<Record> record;

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }
}
