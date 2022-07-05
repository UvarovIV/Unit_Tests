package com.example.Task2;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;
import com.example.Task1.Delivery;

public class DeliveryCountTest {
    
    @Test
    public void shouldCallOneTime(){
        Delivery delivery = Mockito.mock(Delivery.class);
        delivery.getInformationAboutPizza();
        verify(delivery, times(1)).getInformationAboutPizza();
    }
}