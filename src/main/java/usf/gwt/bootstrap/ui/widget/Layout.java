package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Layout extends BootstrapContainer {
	
	@Override
	protected Element initWidget() {
		return Document.get().createDivElement();
	}
}
