package com.epam.mentoring.bridge.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;;

public class MargheritaTest {

	@Test
	public void showRateShouldReturn5StarsForRate5() {
		Pizza pizza = new Margherita("", null, 5, null);
		String res = pizza.showRate();
		assertThat(res, equalTo("*****"));
	}
	
	@Test
	public void showRateShouldReturn1StarForRate1() {
		Pizza pizza = new Margherita("", null, 1, null);
		String res = pizza.showRate();
		assertThat(res, equalTo("*"));
	}
	
	@Test
	public void showRateShouldReturnUndefinedForZero() {
		Pizza pizza = new Margherita();
		String res = pizza.showRate();
		assertThat(res, equalTo("unrated"));
	}
	
}
