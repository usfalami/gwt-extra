package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasText;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

public class Paragraph extends BootstrapWidget implements HasText {

	@Override
	protected Element initWidget() {
		Element e = Document.get().createPElement();
		Text t = Document.get().createTextNode("");
		e.appendChild(t);
		return e;
	}
	@Override
	public String getText() {
		return getElement().getInnerText();
	}
	@Override
	public void setText(String text) {
		getElement().setInnerText(text);
	}
	@Override
	public Text getTextElement() {
		return getElement().getFirstChild().cast();
	}

}
