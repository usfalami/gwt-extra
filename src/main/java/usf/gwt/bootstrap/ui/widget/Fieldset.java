package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.core.Constants.HasFormControlEnable;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Fieldset extends BootstrapContainer implements HasFormControlEnable {
	
	@Override
	protected Element initWidget() {
		return Document.get().createFieldSetElement();
	}
	
	public void setEnabled(boolean enabled){
		HasFormControlEnable.Utils.setEnabled(this, enabled);
	}
	@Override
	public boolean isEnabled() {
		return HasFormControlEnable.Utils.isEnabled(this);
	}
	
}
