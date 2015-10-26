package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasInputText;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * <pre>{@code
 *  <input type='text' class='form-control'>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */

public class TextBox extends FormControl<String> implements HasInputText {
	

	public TextBox() {
		super();
	}
    @Override
    protected Element initWidget() {
    	return Document.get().createTextInputElement();
    }
    @Override
    protected void initStyle() {
    	getBaseElement().addClassName(DEFAULT_FORM_CONTROL_STYLE);
    }
    @Override
    public String getText() {
        return HasInputText.Utils.getText(this);
    }
    @Override
    public void setText(String text) {
        HasInputText.Utils.setText(this, text);
    }
    public void setPlaceholder(String placeholder) {
    	getBaseElement().setAttribute(Constants.ATTRIB_PLACEHOLDER, placeholder);
    }
    public String getPlaceholder() {
        return getBaseElement().getAttribute(Constants.ATTRIB_PLACEHOLDER);
    }
    public void setAutocomplete(boolean autocomplete) {
    	getBaseElement().setAttribute(Constants.ATTRIB_AUTOCOMPLETE, autocomplete ? Constants.VALUE_ON : Constants.VALUE_OFF);
    }
    public boolean getAutocomplete() {
        return Constants.VALUE_ON.equals(getBaseElement().getAttribute(Constants.ATTRIB_AUTOCOMPLETE));
    }
    public void setMaxLength(int max) {
    	getBaseElement().setMaxLength(max);
	}
    public int getMaxLength() {
    	return getBaseElement().getMaxLength();
	}
}
