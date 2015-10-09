package usf.gwt.ui.test;

import usf.gwt.ui.timeline.client.JavaScriptOption;

public class Opt extends JavaScriptOption {
	
	protected Opt() {
		// TODO Auto-generated constructor stub
	}
	
	public final String getValue() {
		return getString("id");
	}
	public final void setValue(String value) {
		set("id", value);
	}
	public final String getText() {
		return getString("name");
	}
	public final void setText(String text) {
		set("name", text);
	}
	
	public final static Opt createOpt(String value, String text) {
		Opt p = (Opt)createOption();
		p.setText(text);
		p.setValue(text);
		return p;
	}

}
