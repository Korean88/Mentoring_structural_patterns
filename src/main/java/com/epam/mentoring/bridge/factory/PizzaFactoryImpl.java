package com.epam.mentoring.bridge.factory;

import com.epam.mentoring.bridge.PizzaPresenter;
import com.epam.mentoring.bridge.entity.Margherita;
import com.epam.mentoring.bridge.entity.Pizza;
import com.epam.mentoring.bridge.entity.PizzaType;

/**
 * Created by Andrey Yun on 27.12.15.
 */
public class PizzaFactoryImpl implements PizzaFactoryInf {
    @Override
    public Pizza createPizza(PizzaType pizzaType, String price, String[] ingredients, int rate, PizzaPresenter pizzaPresenter) {
        Pizza result;
        switch (pizzaType) {
            case MARGHERITA:
                result = new Margherita(price, ingredients, rate, pizzaPresenter);
                return result;
        }
        return null;
    }
}
