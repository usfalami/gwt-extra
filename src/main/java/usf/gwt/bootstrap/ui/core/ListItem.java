package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.core.Constants.HasText;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

/**
 * <pre>{@code
 *  <li> ... </li>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class ListItem extends BootstrapContainer implements Constants.HasText {

	@Override
	protected Element initWidget() {
		Element e =  Document.get().createLIElement();
		Text t = Document.get().createTextNode("");
		e.appendChild(t);
		return e;
	}

	@Override
	public String getText() {
		return getTextElement().getNodeValue();
	}
	@Override
	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}
	
	public boolean isEnabled() {
		return JqueryUtils.isStyleEnabled(getElement());
	}	
	public void setEnabled(boolean enable) {
		JqueryUtils.setStyleEnabled(getElement(), enable);
	}
	
	public boolean isActive() {
		return JqueryUtils.isActive(getElement());
	}
	public void setActive(boolean value) {
		JqueryUtils.activate(getElement(), value);
	}
	public void setActiveUnique() {
		JqueryUtils.activateUnique(getElement(), true);
	}
	
	@Override
	public Text getTextElement() {
		return getElement().getFirstChild().cast();
	}
	
}
