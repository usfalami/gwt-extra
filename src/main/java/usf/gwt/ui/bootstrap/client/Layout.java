package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.core.BootstrapContainer;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Layout extends BootstrapContainer {
	
	@Override
	protected Element initWidget() {
		return Document.get().createDivElement();
	}
}
