package com.epam.mentoring.adapter;

public interface SushiSetCooker {

    String SUSHI_COOKER_BEAN = "sushiCookerBean";
    String SUSHI_COOKER_ADAPTER = "sushiSetCookerAdapter";
	
	void rollUpRolls();
	
	void cutRolls();
	
	void cookSushi(); 
	
	void prepareScallop();
	
	void pack();

}
