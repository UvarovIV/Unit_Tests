package com.example.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

import org.junit.Test;

public class WorkWithReflectionTest {

    final WorkWithReflection wwrf = new WorkWithReflection();

    @Test
    public void workWithFields() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = wwrf.getClass().getDeclaredField("privateField");
        field.setAccessible(true);
        field.set(wwrf, "private");
        System.out.println(field.get(wwrf));
        System.out.println(wwrf.getClass().getDeclaredField("publicField").getName());
        System.out.println(wwrf.getClass().getDeclaredField("protectedField").getType());
    }

    @Test
    public void workWithMethods() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = wwrf.getClass().getDeclaredMethod("randomNumber");
        method.setAccessible(true);
        System.out.println(method.invoke(wwrf));
        Arrays.stream(wwrf.getClass().getDeclaredMethods()).forEach(
            f -> {
                f.setAccessible(true);
                System.out.println(f.getName());
            }
        );
        Arrays.stream(method.getExceptionTypes()).forEach(x -> System.out.println(x.getSimpleName()));
    }

    @Test
    public void workWithConstructors() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Constructor<WorkWithReflection> publicConstructor = WorkWithReflection.class.getDeclaredConstructor(String.class, String.class, String.class);
        System.out.println(publicConstructor);
        Constructor<WorkWithReflection> privateConstructor = WorkWithReflection.class.getDeclaredConstructor(String.class, String.class);
        privateConstructor.setAccessible(true);
        WorkWithReflection wwrf2 = privateConstructor.newInstance("fsdzkdks","dnjkuj");
        Arrays.stream(publicConstructor.getParameterTypes()).forEach(x -> System.out.println(x.getName()));
    }

}
