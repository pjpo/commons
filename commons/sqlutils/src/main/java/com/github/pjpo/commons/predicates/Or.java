package com.github.pjpo.commons.predicates;

public class Or extends AbstractGroupFilter implements Filter {

	public Or(Filter... filters) {
		super(filters);
	}
	
}
