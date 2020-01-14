package com.example.trainingandroidday1.repository;

import com.example.trainingandroidday1.model.Person;

import java.util.ArrayList;

public class TodoRepository {

    static ArrayList<Person> list = new ArrayList<>();

    public static void initList() {
        list.add(new Person("Ernest Marshall", "34"));
        list.add(new Person("Otto Matthews", "21"));
        list.add(new Person("Ben Hughes", "30"));
        list.add(new Person("Chase Johnson", "19"));
        list.add(new Person("Douglas Holland", "21"));
        list.add(new Person("Elias Woods", "18"));
        list.add(new Person("Dominic Lawrence", "20"));
        list.add(new Person("Brian Booth", "25"));
        list.add(new Person("Kevin Wells", "26"));
        list.add(new Person("Jaiden Black", "22"));
    }

    public static ArrayList<Person> getAllTodo() {
        return list;
    }

    public static void addPersonToList(Person person) {
        list.add(person);
    }
}
