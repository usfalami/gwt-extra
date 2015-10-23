package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasText;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

/**
 * <pre>{@code
 *  <legend> ... </label>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class Legend extends BootstrapContainer implements Constants.HasText  {

	@Override
	protected Element initWidget() {
		Element e = Document.get().createLegendElement();
		Text t = Document.get().createTextNode("");
		e.appendChild(t);
		return e;
	}

	public String getText() {
		return getTextElement().getNodeValue();
	}

	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}
	
	@Override
	public Text getTextElement() {
		return getElement().getFirstChild().cast();
	}

}
