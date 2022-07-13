package com.example.annotations;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public class CustomAnnotationTest {

    @CustomAnnotation(command = "testMethod1", queueNumber = 1)
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    @CustomAnnotation(command = "testMethod2", queueNumber = 2)
    public void testMethod2() {
        System.out.println("testMethod2");
    }

    @CustomAnnotation(command = "testMethod3", queueNumber = 3)
    public void testMethod3() {
        System.out.println("testMethod3");
    }

    @CustomAnnotation(command = "testMethod4", queueNumber = 4)
    public void testMethod4() {
        System.out.println("testMethod4");
    }

    private Map<Method, Integer> getCommands() {
        Map<Method, Integer> map = Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(CustomAnnotation.class)).collect(Collectors.toMap(
                        Function.identity(), value -> value.getAnnotation(CustomAnnotation.class).queueNumber()));
        return map;
    }

    private void useMethods(Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<Method, Integer> map = getCommands();
        map.entrySet()
            .stream()
            .filter(m -> m.getValue() < method.getAnnotation(CustomAnnotation.class).queueNumber())
            .forEach(m -> {
                try {
                    m.getKey().invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        method.invoke(this);
    }

    @Test
    public void getCommandsTest() {
        System.out.println(getCommands());
    }

    @Test
    public void useMethodsTest() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        useMethods(this.getClass().getDeclaredMethod("testMethod4"));
    }
}