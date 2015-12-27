package com.epam.mentoring.facade;

import com.epam.mentoring.adapter.PizzaCooker;
import com.epam.mentoring.adapter.PizzaCookerImpl;
import com.epam.mentoring.adapter.SushiSetCooker;
import com.epam.mentoring.adapter.SushiSetCookerImpl;

/**
 * Created by Andrey Yun on 22.12.15.
 */
public class FacadeRunner {

    public static void main(String[] args) {
        PizzaCooker pizzaCooker = new PizzaCookerImpl();
        SushiSetCooker sushiSetCooker = new SushiSetCookerImpl();

         //without facade
        /*pizzaCooker.bake("Margherita");
        pizzaCooker.box();
        pizzaCooker.bake("Bolognese");
        pizzaCooker.box();
        sushiSetCooker.cookSushi("eel");
        sushiSetCooker.pack();
        sushiSetCooker.cookSushi("shrimp");
        sushiSetCooker.pack();*/

        //with facade
        CookFacade facade = new CookFacade(pizzaCooker, sushiSetCooker);
        facade.cookAndBoxPizza("Margherita", "Bolognese");
        facade.cookAndBoxSushi("eel", "shrimp");
    }
}
