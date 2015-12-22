package com.epam.mentoring.adapter;

public class PizzaCookerImpl implements PizzaCooker {

	@Override
	public void bake() {
		System.out.println("Baking a pizza...");
	}

	@Override
	public void cut() {
		System.out.println("Cutting  a pizza into slices...");
	}

	@Override
	public void box() {
		System.out.println("Boxing a pizza...");
	}

}
