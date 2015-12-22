package com.epam.mentoring.bridge;

import com.epam.mentoring.bridge.entity.Pizza;
import com.epam.mentoring.infrastructure.BeanInitializer;

/**
 * Created by Andrey Yun on 19.12.15.
 */
public class BridgeRunner {
    public static void main(String[] args) {
        Pizza pizza = BeanInitializer.initPizza();
        pizza.print();
    }
}
