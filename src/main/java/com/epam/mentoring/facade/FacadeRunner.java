package com.epam.mentoring.facade;

import com.epam.mentoring.adapter.PizzaCooker;
import com.epam.mentoring.adapter.SushiSetCooker;
import com.epam.mentoring.infrastructure.BeanInitializer;

/**
 * Created by Andrey Yun on 22.12.15.
 */
public class FacadeRunner {

    public static void main(String[] args) {
        PizzaCooker pizzaCooker = BeanInitializer.initBean(PizzaCooker.PIZZA_COOKER_BEAN);
        SushiSetCooker sushiSetCooker = BeanInitializer.initBean(SushiSetCooker.SUSHI_COOKER_BEAN);

        /* //without facade
        pizzaCooker.bake();
        pizzaCooker.box();
        sushiSetCooker.cookSushi();
        sushiSetCooker.pack();*/

        //with facade
        CookFacade facade = new CookFacade(pizzaCooker, sushiSetCooker);
        facade.cookPizza();
        facade.boxPizza();
        facade.cookSushi();
        facade.boxSushi();
    }
}
