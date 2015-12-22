package com.epam.mentoring.adapter;

import com.epam.mentoring.infrastructure.BeanInitializer;

public class AdapterRunner {
	
	public static String CONVEYOR_BEAN = "conveyorBean";

	public static void main(String[] args) {
		Conveyor pizzaConveyor = BeanInitializer.initConveyor();
		if (pizzaConveyor != null) {
			pizzaConveyor.bakePizza(); 
			pizzaConveyor.slicePizza();
			pizzaConveyor.boxPizza();
		}
	}

}
