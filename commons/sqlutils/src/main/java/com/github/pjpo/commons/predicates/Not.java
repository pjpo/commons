package com.github.pjpo.commons.predicates;

public class Not implements Filter {

	private final Filter filter;

	public Not(Filter filter) {
		super();
		this.filter = filter;
	}

	public Filter getFilter() {
		return filter;
	}
	
}
