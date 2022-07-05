package com.example.classes;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.example.сlasses.*;

public class DeliveryExceptionTest {
    
    @Test(expected = NullPointerException.class)
    public void shouldThrowException() throws NullPointerException {
        Delivery delivery = Mockito.mock(Delivery.class);
        when(delivery.isOrdered()).thenThrow(new NullPointerException());
        delivery.isOrdered();
    }
}