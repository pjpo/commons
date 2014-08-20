package com.github.pjpo.commons.predicates;

public class Between<T extends Comparable<? super T>> implements Filter {

	private final String property;
	
	private final Boundary<T> start;
	
	private final Boundary<T> end;
	
	private final Class<T> clazz;

	public Between(final String property, final Class<T> clazz, final Boundary<T> start, final Boundary<T> end) {
		this.property = property;
		this.start = start;
		this.end = end;
		this.clazz = clazz;
	}

	public String getProperty() {
		return property;
	}

	public Boundary<T> getStart() {
		return start;
	}

	public Boundary<T> getEnd() {
		return end;
	}

	public Class<T> getClazz() {
		return clazz;
	}
	
}
