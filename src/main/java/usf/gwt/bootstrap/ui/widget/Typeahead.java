package usf.gwt.bootstrap.ui.widget;

import java.util.Collection;
import java.util.Map;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.KeyValue;
import usf.gwt.bootstrap.ui.js.JavaScriptArray;
import usf.gwt.bootstrap.ui.js.JavaScriptOption;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class Typeahead extends TextBox {

	// https://github.com/tcrosen/twitter-bootstrap-typeahead
	// see also http://twitter.github.io/typeahead.js/examples/#
	
	protected SimpleKeyValue item;
	protected JavaScriptObject typeahead;

	public Typeahead() {
		super();
		super.setAutocomplete(false);
		typeahead = get();
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
	
	public void setAjax(String url) {
		setSource(url);
	}
	public void setData(Collection<? extends KeyValue> list) {
		JavaScriptArray a = JavaScriptArray.createArray();
		for(KeyValue v : list) 
			a.append(createJavascriptKeyValue(v));
		setSource(a);
	}
	public void setData(Map<String, String> map) {
		JavaScriptArray a = JavaScriptArray.createArray();
		for(String key : map.keySet())
			a.append(createJavascriptKeyValue(key, map.get(key)));
		setSource(a);
	}
	
	public SimpleKeyValue getSelectedItem() {
		return item == null ? null : item.getText().equals(getText()) ? item : null;
	};
	
	protected final native void setSource(Object data) /*-{
		this.@usf.gwt.bootstrap.ui.widget.Typeahead::typeahead.setSource(data);
	}-*/;
	protected final native JavaScriptArray getData() /*-{
		return this.@usf.gwt.bootstrap.ui.widget.Typeahead::typeahead.source;
	}-*/;
	
	protected final static JavaScriptOption createJavascriptKeyValue(KeyValue value) {
		return createJavascriptKeyValue(value.getValue(), value.getText());
	}
	protected final static native JavaScriptOption createJavascriptKeyValue(final String value, final String text) /*-{
		return {'value': value, 'text': text};
	}-*/;
	
	protected final native JavaScriptObject get() /*-{
		var that = this;
		var e = this.@com.google.gwt.user.client.ui.Widget::getElement()(); // doesn't change if the class is moved
		return $wnd.$(e).typeahead({'val':'value','display':'text','itemSelected': function(e, v, t){
			that.@usf.gwt.bootstrap.ui.widget.Typeahead::item=@usf.gwt.bootstrap.ui.widget.Typeahead.SimpleKeyValue::new(Ljava/lang/String;Ljava/lang/String;)(v,t);
		}}).data(@usf.gwt.bootstrap.ui.core.Constants::BOOTSTRAP_TYPEAHEAD);
	}-*/;
	
	@Deprecated
	public String getSelectedValue() {
		return getSelectedItem()==null ? null : item.getValue();
	};
	
	public static class SimpleKeyValue implements KeyValue {
		private String value, text;
		public SimpleKeyValue(String value, String text) {
			this.value = value;
			this.text = text;
		}
		@Override public String getText()  {return text;}
		@Override public String getValue() {return value;}
		@Override public String toString() {return "SimpleKeyValue [value=" + value + ", text=" + text + "]";}
	}	
}
