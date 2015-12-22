package com.epam.mentoring.adapter;

public class SushiSetCookerAdapter implements PizzaCooker {

	private SushiSetCooker adaptee;
	
	public SushiSetCookerAdapter() {
		super();
	}

	public SushiSetCookerAdapter(SushiSetCooker sushiSetCooker) {
		super();
		this.adaptee = sushiSetCooker;
	}

	public SushiSetCooker getAdaptee() {
		return adaptee;
	}

	public void setAdaptee(SushiSetCooker adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void bake() {
		adaptee.cookSushi();
		adaptee.rollUpRolls();
		adaptee.prepareScallop();
	}

	@Override
	public void cut() {
		adaptee.cutRolls();
	}

	@Override
	public void box() {
		adaptee.pack();
	}

}
