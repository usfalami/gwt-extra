package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Image extends BootstrapWidget {

	@Override
	protected Element initWidget() {
		Element e = Document.get().createImageElement();
		e.setClassName("img-responsive");
		return e;
	}

}
