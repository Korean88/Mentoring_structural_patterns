package com.epam.mentoring.bridge.entity;

import com.epam.mentoring.bridge.PizzaPresenter;

import java.util.stream.IntStream;

public class Margherita extends Pizza {
	
	private static final String NAME = "Margherita";
	
	public Margherita() {
		super();
	}

    public Margherita(String price, String[] ingredients, int rate, PizzaPresenter pizzaPresenter) {
        super(price, ingredients, rate, pizzaPresenter);
    }

    @Override
    public String showName() {
		return NAME;
	}

    @Override
	public String showRate() {
		
		if (getRate() == 0) {
			return "unrated";
		} else {
			StringBuilder result = new StringBuilder();
			IntStream.range(0, getRate()).forEach(i -> result.append("*"));
			return result.toString();
		}
	}

}
