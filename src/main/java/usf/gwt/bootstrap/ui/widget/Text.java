package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HasText;

public class Text extends BootstrapWidget implements HasText {

	@Override
	protected Element initWidget() {
		return Document.get().createTextNode("").cast();
	}
	@Override
	public String getText() {
		return getElement().getNodeValue();
	}
	@Override
	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}

	public com.google.gwt.dom.client.Text getTextElement() {
		return getElement().cast();
	}

}
