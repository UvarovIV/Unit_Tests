package com.example.classes;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.example.сlasses.Delivery;

public class DeliveryCountTest {
    
    @Test
    public void shouldCallOneTime() {
        Delivery delivery = Mockito.mock(Delivery.class);
        delivery.getInformationAboutPizza();
        verify(delivery, times(1)).getInformationAboutPizza();
    }
}