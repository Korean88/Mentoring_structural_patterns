package com.epam.mentoring.infrastructure;

import com.epam.mentoring.adapter.Conveyor;
import com.epam.mentoring.adapter.ConveyorImpl;
import com.epam.mentoring.adapter.SushiSetCooker;
import com.epam.mentoring.bridge.entity.Pizza;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanInitializerTest {

	@Test
	public void shouldInitializeConveyorWithInjectedCooker() {
		Conveyor conveyor = BeanInitializer.initConveyor();
		Assert.assertThat(conveyor, Is.is(Matchers.notNullValue()));
		Assert.assertThat(conveyor, Is.is(Matchers.instanceOf(ConveyorImpl.class)));
		ConveyorImpl conveyorImpl = (ConveyorImpl) conveyor;
		Assert.assertThat(conveyorImpl.getPizzaCooker(), Is.is(Matchers.notNullValue()));
	}
	
	@Test
	public void testLoadProps() {
		Properties props = BeanInitializer.initProps();
		Assert.assertThat(props, Is.is(Matchers.notNullValue()));
	}
	
	@Test
	public void testCookerCreation() {
		SushiSetCooker sushiSetCooker = BeanInitializer.initBean(SushiSetCooker.SUSHI_COOKER_BEAN);
		Assert.assertThat(sushiSetCooker, Is.is(Matchers.notNullValue()));
	}

    @Test
    public void testPizzaCreation() {
        Pizza pizza = BeanInitializer.initPizza();
        assertThat(pizza, is(notNullValue()));
        assertThat(pizza.getPizzaPresenter(), is(notNullValue()));
    }
	
}
