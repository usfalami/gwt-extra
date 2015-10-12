package usf.gwt.ui.bootstrap.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public final class JavaScriptArray extends JavaScriptObject {
	
	protected JavaScriptArray() {
		
	}
	
	public final native JavaScriptArray append(final int value) /*-{
		this[this.length] = value;
		return this;
	}-*/;
	public final native JavaScriptArray append(final double value) /*-{
		this[this.lenght] = value;
		return this;
	}-*/;
	public final native JavaScriptArray append(final String value) /*-{
		this[this.lenght] = value;
		return this;
	}-*/;
	
	public final native int getInteger(final int index) /*-{
		return this[index];
	}-*/;
	public final native double getDouble(final int index) /*-{
		return this[index];
	}-*/;
	public final native String getString(final int index) /*-{
		return this[index];
	}-*/;


	public final native int length() /*-{
		return this.length;
	}-*/;
	
    public static final native JavaScriptArray createArray() /*-{
    	return new $wnd.Array();
    }-*/;
    public static final native JavaScriptArray createArray(int size) /*-{
		return new $wnd.Array(size);
	}-*/;

}
