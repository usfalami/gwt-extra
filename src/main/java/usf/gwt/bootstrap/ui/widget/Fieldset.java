package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

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
