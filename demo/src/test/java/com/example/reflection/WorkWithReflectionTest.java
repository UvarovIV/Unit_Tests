package com.example.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

import org.junit.Test;

public class WorkWithReflectionTest {

    final WorkWithReflection workWithReflection = new WorkWithReflection("private", "public", "protected");
    final Class<?> classForReflection = workWithReflection.getClass();

    @Test
    public void workWithFields() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = classForReflection.getDeclaredField("privateField");
        field.setAccessible(true);
        field.set(workWithReflection, "private");
        System.out.println(field.get(workWithReflection));
        System.out.println(classForReflection.getDeclaredField("publicField").getName());
        System.out.println(classForReflection.getDeclaredField("protectedField").getType());
    }

    @Test
    public void workWithMethods() throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = classForReflection.getDeclaredMethod("randomNumber");
        method.setAccessible(true);
        System.out.println(method.invoke(workWithReflection));
        Arrays.stream(classForReflection.getSuperclass().getDeclaredMethods()).forEach(
            f -> System.out.println(f.getName())
        );
        Arrays.stream(method.getExceptionTypes()).forEach(x -> System.out.println(x.getSimpleName()));
    }

    @Test
    public void workWithConstructors() throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Constructor<WorkWithReflection> publicConstructor = WorkWithReflection.class.getDeclaredConstructor(String.class, String.class, String.class);
        System.out.println(publicConstructor);
        Constructor<WorkWithReflection> privateConstructor = WorkWithReflection.class.getDeclaredConstructor(String.class, String.class);
        privateConstructor.setAccessible(true);
        WorkWithReflection workWithReflection2 = privateConstructor.newInstance("fsdzkdks","dnjkuj");
        System.out.println(workWithReflection2.getClass());
        Arrays.stream(publicConstructor.getParameterTypes()).forEach(x -> System.out.println(x.getName()));
    }

}
