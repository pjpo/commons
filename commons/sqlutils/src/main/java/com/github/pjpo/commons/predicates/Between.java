package com.github.pjpo.commons.predicates;

public class Between<T extends Comparable<T>> implements Filter {

	public static enum BoundaryType {
		INCLUDED, EXCLUDED;
	}

	private final String property;
	
	private final BoundaryType startBoundary;
	
	private final T start;
	
	private final BoundaryType endBoundary;

	private final T end;
	
	public Between(String property, BoundaryType startBoundary,
			T start, BoundaryType endBoundary, T end) {
		this.property = property;
		this.startBoundary = startBoundary;
		this.start = start;
		this.endBoundary = endBoundary;
		this.end = end;
	}

	public String getProperty() {
		return property;
	}

	public BoundaryType getStartBoundary() {
		return startBoundary;
	}

	public T getStart() {
		return start;
	}

	public BoundaryType getEndBoundary() {
		return endBoundary;
	}

	public T getEnd() {
		return end;
	}
	
}
