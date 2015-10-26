package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.core.Constants.HasActive;
import usf.gwt.bootstrap.ui.core.Constants.HasEnable;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;

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
public class ListItem extends BootstrapContainer implements HasNodeText, HasActive, HasEnable {

	Text text;
	
	@Override
	protected Element initWidget() {
		Element e =  Document.get().createLIElement();
		e.appendChild(text = HasNodeText.Utils.create(""));
		return e;
	}

	@Override
	public String getText() {
		return HasNodeText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		HasNodeText.Utils.setText(this, text);
	}
	
	@Override
	public boolean isEnabled() {
		return HasEnable.Utils.isEnabled(this);
	}
	@Override
	public void setEnabled(boolean enable) {
		HasEnable.Utils.setEnabled(this, enable);
	}
	
	@Override
	public boolean isActive() {
		return HasActive.Utils.isActive(this);
	}
	@Override
	public void setActive(boolean value) {
		HasActive.Utils.setActive(this, value);
	}
	public void setActiveUnique() {
		HasActive.Utils.setActiveUnique(this, true);
	}
	
	@Override
	public Text getTextElement() {
		return text;
	}
	
}
