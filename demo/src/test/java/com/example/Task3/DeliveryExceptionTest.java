package com.example.Task3;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.example.Classes.*;

public class DeliveryExceptionTest {
    
    @Test(expected = NullPointerException.class)
    public void shouldThrowException() throws NullPointerException{
        Pizza pizza = new Pizza("4 сыра", "big", "450");
        Delivery delivery = new Delivery("Leningradskaya 115, ", pizza);
        delivery = Mockito.mock(Delivery.class);
        when(delivery.isOrdered()).thenThrow(new NullPointerException());
        delivery.isOrdered();
    }
}