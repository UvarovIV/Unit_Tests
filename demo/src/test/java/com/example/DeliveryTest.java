package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;
import java.lang.reflect.Method;

public class DeliveryTest {

    @Test
    public void shouldAnswerWithTrue() {
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
        delivery.arrangeDelivery();
        assertTrue(delivery.isOrdered());
    }

    @Test
    public void shouldPizzaNotNull() {
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115", pizza);
        assertNotNull(delivery);
    }

    @Test
    public void shouldInformationIsRight() {
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115", pizza);
        assertEquals("4 сыра", delivery.getInformationAboutPizza()[0]);
        assertEquals("big", delivery.getInformationAboutPizza()[1]);
        assertEquals("450", delivery.getInformationAboutPizza()[2]);
    }

    @Test
    public void getHumanNameTest() {
        Pizza pizza = mock(Pizza.class);
        doReturn("4 сыра").when(pizza).getTitle();
        doReturn("big").when(pizza).getSize();
        doReturn("450").when(pizza).getPrice();
        Delivery delivery = new Delivery("Leningradskaya 115", pizza);
        assertEquals("4 сыра", delivery.getInformationAboutPizza()[0]);
        assertEquals("big", delivery.getInformationAboutPizza()[1]);
        assertEquals("450", delivery.getInformationAboutPizza()[2]);
    }

    @Test
    public void shouldCallOneTime() {
        Delivery delivery = spy(Delivery.class);
        delivery.arrangeDelivery();
        verify(delivery, times(1)).arrangeDelivery();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowException() throws NullPointerException {
        Delivery delivery = Mockito.mock(Delivery.class);
        when(delivery.isOrdered()).thenThrow(new NullPointerException());
        delivery.isOrdered();
    }

    @Test
    public void checkPrivateMethod() throws Exception {
          Pizza pizza = new Pizza("4 сыра", "big", "450");
          Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
          Method method = Delivery.class.getDeclaredMethod("returnTrue");
          method.setAccessible(true);
          assertTrue((boolean)method.invoke(delivery));
    }
}
