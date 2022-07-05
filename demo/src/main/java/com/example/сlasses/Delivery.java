package com.example.сlasses;

public class Delivery {

    private String adress;
    private Pizza pizza;
    private boolean isOrdered = false;
    private String[] information = new String[3];

    private static boolean returnTrue() {
        return true;
    }

    public Delivery(String adress, Pizza pizza) {
        this.adress = adress;
        this.pizza = pizza;
    }

    public boolean isOrdered() throws NullPointerException {
        if (pizza == null) throw new NullPointerException();
        return isOrdered;
    }

    public String[] getInformationAboutPizza(){
        information[0] = pizza.getTitle();
        information[1] = pizza.getSize();
        information[2] = pizza.getPrice();
        return information;
    }

    public void arrangeDelivery(){
        if (!isOrdered) {
            System.out.println("Доставка оформлена на адрес: " + adress);
            isOrdered = true;
        } else
            System.out.println("Доставка уже была оформлена ранее");
    }
    
}
