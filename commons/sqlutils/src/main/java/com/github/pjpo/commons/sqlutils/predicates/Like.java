package com.github.pjpo.commons.sqlutils.predicates;

public class Like implements Filter {

	private final String property;
	
	private final String value;
	
	private boolean caseSensitive;

	public Like(final String property, final String value,
			final boolean caseSensitive) {
		super();
		this.property = property;
		this.value = value;
		this.caseSensitive = caseSensitive;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public String getProperty() {
		return property;
	}

	public String getValue() {
		return value;
	}

}
