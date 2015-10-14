package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.js.JqueryEvents;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasText;

import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public abstract class FormControl<T> extends BootstrapWidget implements HasChangeHandlers, HasText {
	
	public final static String DEFAULT_FORM_CONTROL_STYLE = "form-control";
	
	public boolean isEnabled() {
		return JqueryUtils.isFormControlEnabled(getBaseElement());
	}
	public void setEnabled(boolean enabled){
		JqueryUtils.setFormControlEnabled(getBaseElement(), enabled);
	}
	
	public void setName(String name) {
		getBaseElement().setName(name);
	}
	public String getName() {
		return getBaseElement().getName();
	}
	public String getValue() {
		return getBaseElement().getValue();
	}
	public void setValue(String value) {
		getBaseElement().setValue(value);
	}
	
	@Override
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		JqueryEvents.addDomChangeHandler(this);
		return addHandler(handler, ChangeEvent.getType());
	}
	
	@Override
	public InputElement getBaseElement() {
		return getElement().cast();
	}

}
