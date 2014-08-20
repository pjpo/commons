package com.github.pjpo.commons.sqlutils.predicates;

public class Compare<T> implements Filter {

	public static enum Type {
		EQUAL, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL;
	}
	 
	private final String property;
	 
	private final T value;
	 
	private final Type type;

	private final Class<T> clazz;
	
	public Compare(final String property, final Class<T> clazz,
			final T value, final Type type) {
		this.property = property;
		this.value = value;
		this.type = type;
		this.clazz = clazz;
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

	public Class<T> getClazz() {
		return clazz;
	}
	 
}
