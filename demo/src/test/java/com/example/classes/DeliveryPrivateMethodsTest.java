package com.example.classes;

import static org.junit.Assert.*;

import org.junit.Test;
import com.example.сlasses.*;
import java.lang.reflect.Method;

public class DeliveryPrivateMethodsTest {
    @Test
    public void shouldCallOneTime() {
      try {
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
        Method method = Delivery.class.getDeclaredMethod("returnTrue");
        method.setAccessible(true);
        assertTrue((boolean)method.invoke(delivery));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
