package com.epam.mentoring.infrastructure;

import com.epam.mentoring.adapter.*;
import com.epam.mentoring.bridge.PizzaPresenter;
import com.epam.mentoring.bridge.entity.Pizza;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class BeanInitializer {

	private static Properties props;

	public static Conveyor initConveyor() {
		initProps();
		Conveyor result = null;
		try {
			String conveyorFqcn = props.getProperty(AdapterRunner.CONVEYOR_BEAN);
			PizzaCooker pizzaCooker = initBean(SushiSetCooker.SUSHI_COOKER_ADAPTER);
			injectCookerIntoAdapter(pizzaCooker);
			Class conveyorClass = Class.forName(conveyorFqcn);
			Constructor<? extends Conveyor> conveyorConstructor = conveyorClass.getConstructor(PizzaCooker.class);
			result = conveyorConstructor.newInstance(pizzaCooker);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <T> T initBean(String name) {
		initProps();
		String fqcl = props.getProperty(name);
		T result = null;
		try {
			result = (T) Class.forName(fqcl).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static <T> void injectCookerIntoAdapter(T adapter) {
		try {
			Field[] fields = adapter.getClass().getDeclaredFields();
			if (Arrays.asList(fields).stream().anyMatch(f -> "adaptee".equals(f.getName()))){
				SushiSetCooker sushiSetCooker = initBean(SushiSetCooker.SUSHI_COOKER_BEAN);
				Method setter = adapter.getClass().getMethod("setAdaptee", SushiSetCooker.class);
				setter.invoke(adapter, sushiSetCooker);
			}
		} catch (SecurityException | IllegalArgumentException 
				| NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

    public static Pizza initPizza() {
        Pizza res = null;
        try {
            initProps();
            String fqcn = props.getProperty(Pizza.PIZZA_BEAN);
            Class pizzaClass = Class.forName(fqcn);
            Optional<Constructor> constructorOptional = Arrays.asList(pizzaClass.getConstructors()).stream()
                    .filter(c -> {
                        List<Class<?>> parameterTypes = Arrays.asList(c.getParameterTypes());
                        return parameterTypes.size() == 1 && parameterTypes.contains(PizzaPresenter.class);
                    })
                    .findFirst();
            PizzaPresenter pizzaPresenter = initBean(Pizza.PRESENTER_BEAN);
            if (constructorOptional.isPresent()) {
                Constructor<Pizza> pizzaConstructor = constructorOptional.get();
                res = pizzaConstructor.newInstance(pizzaPresenter);
                res.setPizzaPresenter(pizzaPresenter);
            } else {
                res = initBean(Pizza.PIZZA_BEAN);
            }
            String rate = props.getProperty(Pizza.PIZZA_RATE);
            String[] ingredients = props.getProperty(Pizza.PIZZA_INGREDIENTS).split(", ");
            String price = props.getProperty(Pizza.PIZZA_PRICE);
            res.setRate(Integer.valueOf(rate));
            res.setIngredients(ingredients);
            res.setPrice(price);
        } catch (ClassNotFoundException | InvocationTargetException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return res;
    }

	static Properties initProps() {
		if (props == null) {
			props = new Properties();
			try {
				props.load(BeanInitializer.class.getResourceAsStream("bean_impl.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return props;
	}

}
