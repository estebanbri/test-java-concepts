package com.example.testjavaconcepts;

/**
 * Created by JacksonGenerator on 25/03/19.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {
    @JsonProperty("TABLE")
    private List<TABLEItem> tABLE;
    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("resultCode")
    private Integer resultCode;
    @JsonProperty("ret_status")
    private Integer retStatus;

    public static void main(String[] args) {
        String s = new String("asd");
        Class<? extends String> aClass = s.getClass();
        Class<? extends String> aClass1 = String.class;
        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass1.getName());
        System.out.println(aClass1.getSimpleName());
    }

}