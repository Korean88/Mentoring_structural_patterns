package com.epam.mentoring.adapter;

public class SushiSetCookerImpl implements SushiSetCooker {

	@Override
	public void rollUpRolls() {
		System.out.println("Cooking rolls...");
	}

	@Override
	public void cutRolls() {
		System.out.println("Cutting rolls into pieces...");
	}

	@Override
	public void cookSushi() {
		System.out.println("Cooking sushi...");
	}

	@Override
	public void prepareScallop() {
		System.out.println("Preparing a scallop...");
	}

	@Override
	public void pack() {
		System.out.println("Packing up the sushi set...");
	}

}
