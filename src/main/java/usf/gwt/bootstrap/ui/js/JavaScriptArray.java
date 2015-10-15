package usf.gwt.bootstrap.ui.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class JavaScriptArray extends JavaScriptObject {

	public final native JavaScriptArray append(int value) /*-{
		this[this.length] = value;
		return this;
	}-*/;
	public final native JavaScriptArray append(JsDate value) /*-{
		this[this.length] = value;
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
	public final native JsDate getJsDate(final int index) /*-{
		return this[index];
	}-*/;

	public final native int length() /*-{
		return this.length;
	}-*/;
	
    public static final native JavaScriptArray createArray() /*-{
    	return new $wnd.Array(); //return []
    }-*/;
    public static final native JavaScriptArray createArray(int size) /*-{
		return new $wnd.Array(size);
	}-*/;
    
	protected JavaScriptArray() {
		
	}

}
