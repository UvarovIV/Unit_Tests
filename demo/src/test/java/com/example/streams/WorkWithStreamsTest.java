package com.example.streams;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.tests.Delivery;

import java.util.*;

public class WorkWithStreamsTest {
    @Test
    public void shouldEquals() {
        List<Integer> list = List.of(4, 6, 6, 6, 6, 6, 6, 6, 6, 6);
        assertEquals(10.714, WorkWithStreams.getAverage(list), 0.001);
    }

    @Test
    public void shouldEquals2() {
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
            "kkkkkkk");
        assertEquals((Integer) 2, WorkWithStreams.setToMap(set).get("ee"));
    }

    @Test
    public void shouldEquals3() {
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i < 6; i++)
            hashMap.put("key" + i, "value" + i);
        assertEquals("key1==value1", WorkWithStreams.hashMapToList(hashMap).get(0));
    }

    @Test
    public void shouldEquals4() {
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i < 6; i++)
            hashMap.put("key" + i, "value" + i);
        assertEquals("key1", WorkWithStreams.hashMapToList2(hashMap).get(0));
    }

    @Test
    public void shouldNotNull() {
        assertNotNull(WorkWithStreams.createIfNull(new Delivery()));
    }
}
