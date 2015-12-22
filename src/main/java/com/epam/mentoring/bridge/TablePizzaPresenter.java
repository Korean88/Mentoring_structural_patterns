package com.epam.mentoring.bridge;

/**
 * Created by Andrey Yun on 19.12.15.
 */
public class TablePizzaPresenter implements PizzaPresenter {
    @Override
    public String display(String name, String rate, String price, String ingredients) {
        StringBuilder res = new StringBuilder();
        res.append("| ")
                .append(name)
                .append("\t|\t")
                .append(ingredients)
                .append("\t|\t")
                .append(rate)
                .append("\t|\n");
        return res.toString();
    }
}
