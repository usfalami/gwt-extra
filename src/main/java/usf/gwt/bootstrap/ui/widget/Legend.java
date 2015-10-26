package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
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
public class Legend extends BootstrapContainer implements HasNodeText  {

	Text text;

	@Override
	protected Element initWidget() {
		Element e = Document.get().createLegendElement();
		e.appendChild(text = HasNodeText.Utils.create(""));
		return e;
	}

	@Override
	public String getText() {
		return HasNodeText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		HasNodeText.Utils.setText(this ,text);
	}
	@Override
	public Text getTextElement() {
		return text;
	}

}
