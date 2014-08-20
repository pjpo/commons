package com.github.pjpo.commons.predicates;

public class IsNull<T> implements Filter {

	private final String property;
	 
	private final Class<T> clazz;

	public IsNull(String property, Class<T> clazz) {
		super();
		this.property = property;
		this.clazz = clazz;
	}

	public String getProperty() {
		return property;
	}

	public Class<T> getClazz() {
		return clazz;
	}

}
