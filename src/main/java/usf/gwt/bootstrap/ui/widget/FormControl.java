package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Constants.HasFormControlEnable;
import usf.gwt.bootstrap.ui.js.JqueryEvents;

import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public abstract class FormControl<T> extends BootstrapWidget implements HasChangeHandlers, HasFormControlEnable {
	
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
	public boolean isEnabled() {
		return HasFormControlEnable.Utils.isEnabled(this);
	}
	@Override
	public void setEnabled(boolean enabled){
		HasFormControlEnable.Utils.setEnabled(this, enabled);
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
