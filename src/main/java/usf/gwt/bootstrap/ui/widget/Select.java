package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.KeyValue;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.Text;

public class Select extends FormControl<String> {
	
	@Override
	protected Element initWidget() {
		return Document.get().createSelectElement();
	}
	@Override
	protected void initStyle() {
		getElement().addClassName(DEFAULT_FORM_CONTROL_STYLE);
	}
	
	public void setMultiple(boolean multiple) {
		JqueryUtils.switchAttribute(getElement(), Constants.ATTRIB_MULTIPLE, multiple);
	}
	public boolean isMultiple() {
		return JqueryUtils.hasAttrib(getElement(), Constants.ATTRIB_MULTIPLE);
	}
	
	public void add(String text, String value){
		OptionElement o = Document.get().createOptionElement();
		o.setValue(value);
		o.setText(text);
		getElement().appendChild(o);
	}
	public void add(KeyValue v){
		add(v.getValue(), v.getText());
	}
	
	@Override
	public String getText() {
		return null;
	}
	@Override
	public void setText(String text) {
		
	}
	@Override
	public Text getTextElement() {
		return null;
	}

}
