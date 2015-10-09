package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.core.BootstrapContainer;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Fieldset extends BootstrapContainer {
	
	@Override
	protected Element initWidget() {
		return Document.get().createFieldSetElement();
	}
	
	public void setEnabled(boolean enabled){
		JqueryUtils.setFormControlEnabled(getElement(), enabled);
	}
	
}
