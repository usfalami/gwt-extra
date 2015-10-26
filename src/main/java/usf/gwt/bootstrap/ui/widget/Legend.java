package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;

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
public class Legend extends BootstrapContainer implements Constants.HasNodeText  {

	Text text;

	@Override
	protected Element initWidget() {
		Element e = Document.get().createLegendElement();
		e.appendChild(text = HasNodeText.Utils.create(""));
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
		return text;
	}

}
