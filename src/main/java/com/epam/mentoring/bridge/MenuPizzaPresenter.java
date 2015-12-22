package com.epam.mentoring.bridge;

/**
 * Created by Andrey Yun on 19.12.15.
 */
public class MenuPizzaPresenter implements PizzaPresenter {
    @Override
    public String display(String name, String rate, String price, String ingredients) {
        StringBuilder res = new StringBuilder();
        res.append(name)
                .append("\t")
                .append(ingredients)
                .append("\t")
                .append(price);
        return res.toString();
    }
}
