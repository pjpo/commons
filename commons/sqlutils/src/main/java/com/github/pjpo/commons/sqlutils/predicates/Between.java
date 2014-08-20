package com.github.pjpo.commons.sqlutils.predicates;

public class Between<T> implements Filter {

	private final String property;
	
	private final Boundary<? extends T> start;
	
	private final Boundary<? extends T> end;
	
	private final Class<T> clazz;

	public Between(final String property, final Class<T> clazz, final Boundary<? extends T> start, final Boundary<? extends T> end) {
		this.property = property;
		this.start = start;
		this.end = end;
		this.clazz = clazz;
	}

	public String getProperty() {
		return property;
	}

	public Boundary<? extends T> getStart() {
		return start;
	}

	public Boundary<? extends T> getEnd() {
		return end;
	}

	public Class<T> getClazz() {
		return clazz;
	}
	
}
