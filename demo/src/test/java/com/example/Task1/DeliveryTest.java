package com.example.Task1;

import static org.junit.Assert.*;
import org.junit.Test;

import com.example.сlasses.Delivery;
import com.example.сlasses.Pizza;

public class DeliveryTest {

    @Test
    public void shouldAnswerWithTrue(){
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
        delivery.arrangeDelivery();
        assertTrue( delivery.isOrdered() );
    }

    @Test
    public void shouldPizzaNotNull(){
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
        assertNotNull(delivery);
    }

    @Test
    public void shouldInformationIsRight(){
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
        assertEquals( "4 сыра", delivery.getInformationAboutPizza()[0]);
        assertEquals( "big", delivery.getInformationAboutPizza()[1]);
        assertEquals( "450", delivery.getInformationAboutPizza()[2]);
    }
}
