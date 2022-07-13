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
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(CustomAnnotation.class)).collect(Collectors.toMap(
                        Function.identity(), value -> value.getAnnotation(CustomAnnotation.class).queueNumber()));
    }

    private void useMethods(Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<Method, Integer> map = getCommands();
        int currentNumber = map.get(method);

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(x -> {
            if (x.getValue() <= currentNumber)
                try {
                    x.getKey().invoke(this);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
        });
    }

    @Test
    public void getCommandsTest() {
        System.out.println(getCommands());
    }

    @Test
    public void useMethodsTest() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        useMethods(this.getClass().getDeclaredMethod("testMethod3"));
    }
}
