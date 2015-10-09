package usf.gwt.ui.test;

import usf.gwt.ui.bootstrap.client.core.KeyValue;

public class Value implements KeyValue {
	
	private String value;
	private String text;
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

	public Value(String value, String text) {
		super();
		this.value = value;
		this.text = text;
	}
	
	public Value() {
	}

}
