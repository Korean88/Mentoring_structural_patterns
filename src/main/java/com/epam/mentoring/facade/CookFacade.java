package com.epam.mentoring.facade;

import com.epam.mentoring.adapter.PizzaCooker;
import com.epam.mentoring.adapter.SushiSetCooker;

/**
 * Created by Andrey Yun on 22.12.15.
 */
public class CookFacade {

    private PizzaCooker pizzaCooker;
    private SushiSetCooker sushiSetCooker;

    public CookFacade() {
    }

    public CookFacade(PizzaCooker pizzaCooker, SushiSetCooker sushiSetCooker) {
        this.pizzaCooker = pizzaCooker;
        this.sushiSetCooker = sushiSetCooker;
    }

    public PizzaCooker getPizzaCooker() {

        return pizzaCooker;
    }

    public void setPizzaCooker(PizzaCooker pizzaCooker) {
        this.pizzaCooker = pizzaCooker;
    }

    public SushiSetCooker getSushiSetCooker() {
        return sushiSetCooker;
    }

    public void setSushiSetCooker(SushiSetCooker sushiSetCooker) {
        this.sushiSetCooker = sushiSetCooker;
    }

    public void cookPizza() {
        pizzaCooker.bake();
    }

    public void cookSushi() {
        sushiSetCooker.cookSushi();
    }

    public void boxPizza() {
        pizzaCooker.box();
    }

    public void boxSushi() {
        sushiSetCooker.pack();
    }
}
