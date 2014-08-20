package com.github.pjpo.commons.predicates;

public class OrderBy {

	public static enum Order {
		ASC, DESC;
	}
	
	private final String property;
	
	private final Order order;

	public OrderBy(String property, Order order) {
		super();
		this.property = property;
		this.order = order;
	}

	public String getProperty() {
		return property;
	}

	public Order getOrder() {
		return order;
	}
	
}
