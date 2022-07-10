package com.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import com.example.Delivery;

public class WorkWithStreams {

    public static int check(int x) {
        if (x % 2 == 0) {
            x += 5;
            System.out.println(x);
            return x;
        } else {
            x -=5;
            System.out.println(x);
            return x;
        }
    }
    public static void main(String[] args) {
        
        List<Integer> list = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99, 1010);
        
        Stream<Integer> stream = list.stream();
            
        double average = stream
            .limit(7)
            .map(x -> check(x))
            .mapToInt(x -> x)
            .average()
            .getAsDouble();

        System.out.println(average);

        Set<String> set = Set.of(
        "aaa",
        "bbbbb",
        "jjjjjj",
        "cccc",
        "ddddddddddddddddd",
        "ee",
        "ffffffffffffffff",
        "gggggggggg",
        "iiiiiiiiiiiiiiiiiiii",
        "kkkkkkk"
        );

        Map<String, Integer> map = set
            .stream()
            .filter(x -> x.length() <= 10)
            .collect(Collectors.toMap(Function.identity(), String::length));
        
        System.out.println(map);

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value4");
        hashMap.put("key5", "value5");

        List<String> llist = hashMap
            .entrySet()
            .stream()
            .map(x -> x.getKey() + "==" + x.getValue())
            .collect(Collectors.toList());

        System.out.println(llist);

        llist = hashMap
            .entrySet()
            .stream()
            .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
            .collect(Collectors.toList());
        
        System.out.println(llist);

        Delivery delivery = null;
        delivery = Optional.ofNullable(delivery).orElseGet(Delivery::new);
        delivery.setAdress("Vologda");
        delivery.arrangeDelivery();
    }   
}
