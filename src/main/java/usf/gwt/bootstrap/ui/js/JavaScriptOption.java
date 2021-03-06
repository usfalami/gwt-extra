package usf.gwt.bootstrap.ui.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class JavaScriptOption extends JavaScriptObject {

	public final native JavaScriptOption set(final String name, final String value) /*-{
		this[name] = value;
		return this;
	}-*/;

	public final native String getString(final String name) /*-{
		return this[name];
	}-*/;

	public final native JavaScriptOption set(final String name, final boolean value) /*-{
		this[name] = value;
		return this;
	}-*/;

	public final native boolean getBoolean(final String name) /*-{
		return this[name];
	}-*/;

	public final native JavaScriptOption set(final String name, final JsDate value) /*-{
		this[name] = value;
		return this;
	}-*/;

	public final native JsDate getDate(final String name) /*-{
		return this[name];
	}-*/;
	
	public final native JavaScriptOption set(final String name, final JavaScriptOption value) /*-{
		this[name] = value;
		return this;
	}-*/;
	
	public final native JavaScriptOption getObject(final String name) /*-{
		return this[name];
	}-*/;

	public final native JavaScriptOption set(final String name, final int value) /*-{
		this[name] = value;
		return this;
	}-*/;

	public final native int getInteger(final String name) /*-{
		return this[name];
	}-*/;

	public static final native JavaScriptOption createOption() /*-{
		return new $wnd.Object(); // return {}
	}-*/;
	
	protected JavaScriptOption() {
	}

}