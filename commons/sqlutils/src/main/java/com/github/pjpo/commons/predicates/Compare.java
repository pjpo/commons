package com.github.pjpo.commons.predicates;

public class Compare<T extends Comparable<T>> implements Filter {

	public static enum Type {
		EQUAL, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL;
	}
	 
	private final String property;
	 
	private final T value;
	 
	private final Type type;
	
	public Compare(final String property,
			final T value, final Type type) {
		this.property = property;
		this.value = value;
		this.type = type;
	}

	public String getProperty() {
		return property;
	}

	public T getValue() {
		return value;
	}

	public Type getType() {
		return type;
	}

}
