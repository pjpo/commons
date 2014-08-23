package com.github.pjpo.commons.predicates;

public class IsNull<T> implements Filter {

	private final String property;
	 
	public IsNull(final String property) {
		super();
		this.property = property;
	}

	public String getProperty() {
		return property;
	}

}
