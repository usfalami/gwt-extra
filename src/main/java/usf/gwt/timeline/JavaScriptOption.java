package usf.gwt.timeline;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class JavaScriptOption extends JavaScriptObject {

	protected JavaScriptOption() {
	}

	public final native void set(final String name, final String value) /*-{
		this[name] = value;
	}-*/;

	public final native String getString(final String name) /*-{
		return this[name];
	}-*/;

	public final native void set(final String name, final boolean value) /*-{
		this[name] = value;
	}-*/;

	protected final native boolean getbool(final String name) /*-{
		return this[name];
	}-*/;

	public final Boolean getBoolean(final String name) {
		return has(name) ? getbool(name) : null;
	}

	public final native void set(final String name, final JsDate value) /*-{
		this[name] = value;
	}-*/;

	public final void set(final String name, final Date date) {
		set(name, JsDate.create(date.getTime()));
	}

	protected final native JsDate getJsDate(final String name) /*-{
		return this[name];
	}-*/;

	public final Date getDate(final String name) {
		return getJsDate(name) == null ? null : new Date((long) getJsDate(name)
				.getTime());
	}

	public final native void set(final String name, final double value) /*-{
		this[name] = value;
	}-*/;

	protected final native double getReel(final String name) /*-{
		return this[name];
	}-*/;

	public final Double getDouble(final String name) {
		return has(name) ? getReel(name) : null;
	}

	public final native void set(final String name, final int value) /*-{
		this[name] = value;
	}-*/;

	protected final native int getInt(final String name) /*-{
		return this[name];
	}-*/;

	public final Integer getInteger(final String name) {
		return has(name) ? getInt(name) : null;
	}

	public final native boolean has(final String name) /*-{
		return this[name] != undefined;
	}-*/;

	public static final native JavaScriptOption createOption() /*-{
		return {};
	}-*/;
}