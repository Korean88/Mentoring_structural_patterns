package com.epam.mentoring.bridge;

import com.epam.mentoring.bridge.entity.Pizza;
import com.epam.mentoring.bridge.entity.PizzaType;
import com.epam.mentoring.bridge.factory.PizzaFactoryImpl;

/**
 * Created by Andrey Yun on 19.12.15.
 */
public class BridgeRunner {
    public static void main(String[] args) {
        PizzaPresenter pizzaPresenter = new TablePizzaPresenter();
        String price = "$12.99";
        String[] ingredients = new String[]{"dough", "tomato", "mozzarella cheese", "garlic", "tomato sauce"};
        int rate = 5;
        PizzaFactoryImpl pizzaFactory = new PizzaFactoryImpl();
        Pizza pizza = pizzaFactory.createPizza(PizzaType.MARGHERITA, price, ingredients, rate, pizzaPresenter);
        pizza.print();
    }
}
