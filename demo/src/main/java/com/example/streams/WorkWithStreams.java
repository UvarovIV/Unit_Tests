package com.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import com.example.tests.Delivery;

public class WorkWithStreams {

    private static int check(int x) {
        x += x % 2 == 0 ? 5 : -5;
        System.out.println(x);
        return x;   
    }

    public static double getAverage(List<Integer> list) {

        return list
            .stream()
            .limit(7)
            .map(x -> check(x))
            .mapToInt(x -> x)
            .average()
            .getAsDouble();

    }

    public static Map<String, Integer> setToMap(Set<String> set) {

        return set
            .stream()
            .filter(x -> x.length() <= 10)
            .collect(Collectors.toMap(Function.identity(), String::length));

    }

    public static List<String> hashMapToList(Map<String, String> hashMap) {

        return hashMap
            .entrySet()
            .stream()
            .map(x -> x.getKey() + "==" + x.getValue())
            .collect(Collectors.toList());

    }

    public static List<String> hashMapToList2(Map<String, String> hashMap) {

        return hashMap
            .entrySet()
            .stream()
            .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
            .collect(Collectors.toList());

    }

    public static Delivery createIfNull(Delivery delivery) {
        return Optional.ofNullable(delivery).orElseGet(Delivery::new);
    }
}
