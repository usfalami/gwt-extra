package com.gwt.extra.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

import usf.gwt.bootstrap.ui.core.KeyValue;


public class Value implements KeyValue, IsSerializable  {
	
	private String value;
	private String text;
	
	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getText() {
		return text;
	}

	public Value(String value, String text) {
		this.value = value;
		this.text = text;
	}
	
	public Value() {
	}

}
