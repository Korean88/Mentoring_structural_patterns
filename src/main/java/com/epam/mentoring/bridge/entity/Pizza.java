package com.epam.mentoring.bridge.entity;

import com.epam.mentoring.bridge.PizzaPresenter;

import java.util.Arrays;

public abstract class Pizza {
	
	private String price;
	private String[] ingredients;
	private int rate;
    private PizzaPresenter pizzaPresenter;

	public Pizza() {
		super();
	}

    protected Pizza(PizzaPresenter pizzaPresenter) {
        this.pizzaPresenter = pizzaPresenter;
    }

    protected Pizza(String price, String[] ingredients, int rate, PizzaPresenter pizzaPresenter) {
        this.price = price;
        this.ingredients = ingredients;
        this.rate = rate;
        this.pizzaPresenter = pizzaPresenter;
    }

    public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public abstract String showName();
	
	public String showPrice() {
		return price != null ? price : "unknown price";
	}

	public String showIngredients() {
		return ingredients != null ? Arrays.toString(ingredients) : "unknown ingredients";
	}

    public PizzaPresenter getPizzaPresenter() {
        return pizzaPresenter;
    }

    public void setPizzaPresenter(PizzaPresenter pizzaPresenter) {
        this.pizzaPresenter = pizzaPresenter;
    }

    public abstract String showRate();

    public void print() {
        System.out.println(pizzaPresenter.display(showName(), showRate(), showPrice(), showIngredients()));
    }

}
