package com.theara.spring.model;

import java.util.LinkedHashMap;

/**
 * @author Theara Seng
 * created on Jan 10, 2020
 */

public class MData extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = -7571514305569797247L;

	public MData() {

	}

	public MData(MData data) {
		super(data);
	}

	public String getString(String key) {
		return this.get(key) != null ? String.valueOf(this.get(key)) : null;
	}

	public void setString(String key, String value) {
		this.put(key, value);
	}

}
