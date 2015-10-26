package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class Text extends Widget implements HasNodeText, com.google.gwt.user.client.ui.HasText {

	public Text() {
		setElement(initWidget());
	}
	
	protected Element initWidget() {
		return HasNodeText.Utils.create("").cast();
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
