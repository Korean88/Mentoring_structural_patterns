package com.epam.mentoring.adapter;

public class ConveyorImpl implements Conveyor {

	private PizzaCooker pizzaCooker;
	
	public ConveyorImpl(PizzaCooker pizzaCooker) {
		super();
		this.pizzaCooker = pizzaCooker;
	}

	public PizzaCooker getPizzaCooker() {
		return pizzaCooker;
	}

	public void setPizzaCooker(PizzaCooker pizzaCooker) {
		this.pizzaCooker = pizzaCooker;
	}

	@Override
	public void bakePizza(String pizzaName) {
		pizzaCooker.bake(pizzaName);
	}

	@Override
	public void slicePizza() {
		pizzaCooker.cut();
	}

	@Override
	public void boxPizza() {
		pizzaCooker.box();
	}

}
