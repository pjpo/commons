package com.github.pjpo.commons.sqlutils.predicates;

public class And extends AbstractGroupFilter implements Filter {

	public And(Filter...filters) {
		super(filters);
	}
	
}
