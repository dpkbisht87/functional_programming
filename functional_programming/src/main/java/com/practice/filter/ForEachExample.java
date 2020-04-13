package com.practice.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ForEachExample {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) myList.add(i);

        List<Integer> myList1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("myList1: " + myList1);

        for (Integer integer : myList1) {
            System.out.println(integer);
        }
        System.out.println("Lambda");
        myList1.forEach(item -> System.out.println(item));

        System.out.println("Streams");
        myList1.stream()
                .filter(item -> !item.equals(4))
                .forEach(item -> System.out.println(item));

        System.out.println("Stream with optional");
       Optional<Integer> optionalInteger = myList1.stream()
                .filter(item -> !item.equals(4))
                .findAny();

        //optionalInteger.isPresent(System.out.println(item));
    }
}
