package com.github.pjpo.commons.sqlutils.predicates;

public class Boundary<T> {

	public static enum BoundaryType {
		INCLUDED, EXCLUDED;
	}
	
	private final BoundaryType boundaryType;
	
	private final T value;
		
	public Boundary(final T value, final BoundaryType boundaryType) {
		this.value = value;
		this.boundaryType = boundaryType;
	}

	public BoundaryType getBoundaryType() {
		return boundaryType;
	}

	public T getValue() {
		return value;
	}
	
}
