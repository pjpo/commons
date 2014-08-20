package com.github.pjpo.commons.sqlutils.predicates;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractGroupFilter {

	private final Collection<Filter> filters;
	
	public AbstractGroupFilter(Filter...filters) {
		this.filters = Collections.unmodifiableCollection(
				Arrays.asList(filters));
	}
	
	public Collection<Filter> getFilters() {
		return filters;
	}

}
