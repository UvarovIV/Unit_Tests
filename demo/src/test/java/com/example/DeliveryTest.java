package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
 
import org.junit.Test;
import org.mockito.Mockito;
import java.lang.reflect.Method;

public class DeliveryTest {

    final String[] testInformation = {"4 сыра", "big", "450"}; 
    final Pizza testPizza = new Pizza(testInformation[0], testInformation[1], testInformation[2]);
    final String adress = "Leningradskaya 115";
    final Delivery testDelivery = new Delivery(adress, testPizza);

    @Test
    public void shouldAnswerWithTrue() {
        testDelivery.arrangeDelivery();
        assertTrue(testDelivery.isOrdered());
    } 

    @Test
    public void shouldPizzaNotNull() {
        assertNotNull(testDelivery);
    } 

    private void equalInformation(Delivery delivery) {
        for (int i = 0; i < testInformation.length; i++)
            assertEquals(testInformation[i], delivery.getInformationAboutPizza()[i]);
    } 

    @Test
    public void shouldInformationIsRight() {
        equalInformation(testDelivery);
    }

    @Test
    public void shouldInformationIsRight2() {
        Pizza pizza = mock(Pizza.class);
        doReturn(testInformation[0]).when(pizza).getTitle();
        doReturn(testInformation[1]).when(pizza).getSize();
        doReturn(testInformation[2]).when(pizza).getPrice();
        Delivery delivery = new Delivery(adress, pizza);
        equalInformation(delivery);
    }  

    @Test
    public void shouldCallTwoTime() {
        Delivery delivery = spy(Delivery.class);
        delivery.setAdress(adress);
        delivery.arrangeDelivery();
        delivery.arrangeDelivery();
        verify(delivery, times(2)).arrangeDelivery();
    } 

    @Test(expected = NullPointerException.class)
    public void shouldThrowException() throws NullPointerException {
        Delivery delivery = Mockito.mock(Delivery.class);
        when(delivery.isOrdered()).thenThrow(new NullPointerException());
        delivery.isOrdered();
    } 

    @Test
    public void checkPrivateMethod() throws Exception {
        Method method = Delivery.class.getDeclaredMethod("returnTrue");
        method.setAccessible(true);
        assertTrue((boolean)method.invoke(testDelivery));
    } 
}