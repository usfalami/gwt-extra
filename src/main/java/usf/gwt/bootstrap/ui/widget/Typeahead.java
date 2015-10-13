package usf.gwt.bootstrap.ui.widget;

import java.util.Collection;
import java.util.Map;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.KeyValue;
import usf.gwt.bootstrap.ui.js.JavaScriptOption;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

public class Typeahead extends TextBox {

	// https://github.com/tcrosen/twitter-bootstrap-typeahead
	// see also http://twitter.github.io/typeahead.js/examples/#
	
	private JavaScriptObject typeahead;
	
	public Typeahead() {
		super();
		super.setAutocomplete(false);
		setEnabled(false);
	}

	@Override
	protected Element initWidget() {
		Element e = super.initWidget();
		e.setAttribute(Constants.ATTRIB_DATA_PROVIDE, Constants.BOOTSTRAP_TYPEAHEAD);
		return e;
	}

	@Override
	public void setAutocomplete(boolean autocomplete) {
		//super.setAutocomplete(false);
	}
	
	public void setData(Collection<? extends KeyValue> list) {
		JsArray<JavaScriptOption> a = (JsArray<JavaScriptOption>) JsArray.createArray();
		for(KeyValue v : list) a.push(createJavascriptKeyValue(v));
		typeahead = set(getElement(), a);
		setEnabled(true);
	}
	public void setData(Map<String, String> map) {
		JsArray<JavaScriptOption> a = (JsArray<JavaScriptOption>) JsArray.createArray();
		for(String key : map.keySet()) a.push(createJavascriptKeyValue(key, map.get(key)));
		typeahead = set(getElement(), a);
		setEnabled(true);
	}
	public String getSelectedValue() {
		return getSelectedValue(typeahead);
	};
	
	protected final static JavaScriptOption createJavascriptKeyValue(KeyValue value) {
		return createJavascriptKeyValue(value.getValue(), value.getText());
	}
	
	protected final static native String getSelectedValue(final JavaScriptObject o) /*-{
		return (items = o.checker()).length == 1 ? items[0].id : null;
	}-*/;
	protected final static native JavaScriptObject set(final Element e, final JsArray<JavaScriptOption> list) /*-{
		return $wnd.$(e).typeahead({source:list, itemSelected: function(x, y, z){}}).data(@usf.gwt.bootstrap.ui.core.Constants::BOOTSTRAP_TYPEAHEAD);
	}-*/;
	protected final static native JavaScriptOption createJavascriptKeyValue(final String value, final String text) /*-{
		return {id: value, name: text};
	}-*/;
	
}
