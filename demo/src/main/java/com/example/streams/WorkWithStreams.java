package com.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import com.example.Delivery;

public class WorkWithStreams {

    private static int check(int x) {
        if (x % 2 == 0) {
            x += 5;
            System.out.println(x);
            return x;
        } else {
            x -= 5;
            System.out.println(x);
            return x;
        }
    }

    public static double getAverage(List<Integer> list) {

        double average = list
            .stream()
            .limit(7)
            .map(x -> check(x))
            .mapToInt(x -> x)
            .average()
            .getAsDouble();

        return average;
    }

    public static Map<String, Integer> setToMap(Set<String> set) {

        Map<String, Integer> map = set
            .stream()
            .filter(x -> x.length() <= 10)
            .collect(Collectors.toMap(Function.identity(), String::length));

        return map;
    }

    public static List<String> hashMapToList(Map<String, String> hashMap) {

        List<String> list = hashMap
            .entrySet()
            .stream()
            .map(x -> x.getKey() + "==" + x.getValue())
            .collect(Collectors.toList());

        return list;
    }

    public static List<String> hashMapToList2(Map<String, String> hashMap) {

        List<String> list = hashMap
            .entrySet()
            .stream()
            .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
            .collect(Collectors.toList());

        return list;
    }

    public static Delivery createIfNull(Delivery delivery) {
        delivery = null;
        delivery = Optional.ofNullable(delivery).orElseGet(Delivery::new);
        return delivery;
    }
}
