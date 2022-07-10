package com.example.streams;

import static org.junit.Assert.*;
 
import org.junit.Test;
import java.util.*;
import com.example.Delivery;

public class WorkWithStreamsTest {
    @Test
    public void shouldEquals() {
        List<Integer> list = List.of(6, 6, 6, 6, 6, 6, 6, 6, 6, 6);
        assertEquals("11.0", WorkWithStreams.getAverage(list));
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
        "kkkkkkk"
        );
        Integer i = 2;
        assertEquals(i, WorkWithStreams.setToMap(set).get("ee"));
    } 
    @Test
    public void shouldEquals3() {
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i < 6; i++)
            hashMap.put("key" + i,"value" + i);
        assertEquals("key1==value1", WorkWithStreams.hashMapToList(hashMap).get(0));
    } 
    @Test
    public void shouldEquals4() {
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i < 6; i++)
            hashMap.put("key" + i,"value" + i);
        assertEquals("key1", WorkWithStreams.hashMapToList2(hashMap).get(0));
    } 

    @Test
    public void shouldNotNull() {
        Delivery delivery = null;
        assertNotNull(WorkWithStreams.createIfNull(delivery));
    }
}
