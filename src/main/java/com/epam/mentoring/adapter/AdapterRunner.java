package com.epam.mentoring.adapter;

public class AdapterRunner {

	public static void main(String[] args) {
        SushiSetCooker sushiSetCooker = new SushiSetCookerImpl();
        PizzaCooker sushiCooker = new SushiSetCookerAdapter(sushiSetCooker);
		Conveyor pizzaConveyor = new ConveyorImpl(sushiCooker);
		if (pizzaConveyor != null) {
			pizzaConveyor.bakePizza("Margherita");
			pizzaConveyor.slicePizza();
			pizzaConveyor.boxPizza();
		}
	}

}
