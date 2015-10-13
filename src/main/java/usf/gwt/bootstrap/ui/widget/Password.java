package usf.gwt.bootstrap.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Password extends TextBox {
	
	public Password() {
		super();
	}
	
	@Override
	protected Element initWidget() {
    	return Document.get().createPasswordInputElement();
	}
	@Override
	public void setAutocomplete(boolean autocomplete) {
		//super.setAutocomplete(autocomplete);
	}

}
