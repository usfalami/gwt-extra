package usf.gwt.ui.bootstrap.datetimepicker.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class JavaScriptArray extends JavaScriptObject {
	
	protected JavaScriptArray(){
		
	}
	
	public final native String getString(final int index) /*-{
		return this[index];
	}-*/;

	public final native int length() /*-{
		return this.length;
	}-*/;

}
