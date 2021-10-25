package com.ushakov.persons;

import java.util.ArrayList;
import java.util.List;

public class PersonData {
    private static final List<Person> data = new ArrayList<>();

    public static List<Person> getPersonsData() {
        return data;
    }
}
