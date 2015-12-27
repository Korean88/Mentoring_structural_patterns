package com.epam.mentoring.bridge.factory;

import com.epam.mentoring.bridge.PizzaPresenter;
import com.epam.mentoring.bridge.entity.Pizza;
import com.epam.mentoring.bridge.entity.PizzaType;

/**
 * Created by Andrey Yun on 27.12.15.
 */
public interface PizzaFactoryInf {

    Pizza createPizza(PizzaType pizzaType, String price, String[] ingredients, int rate, PizzaPresenter pizzaPresenter);
}
