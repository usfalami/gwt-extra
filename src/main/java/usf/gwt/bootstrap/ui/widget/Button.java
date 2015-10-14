package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryEvents;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.ButtonStates;
import usf.gwt.bootstrap.ui.widget.Bootstrap.ButtonStyles;
import usf.gwt.bootstrap.ui.widget.Bootstrap.ButtonTypes;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasState;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasText;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasType;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class Button extends FormControl<String> implements HasStyle<ButtonStyles>, HasState<ButtonStates>, HasType<ButtonTypes>, HasText, HasClickHandlers {
	
    public Button() {
        super();
    }
    public Button(String text) {
    	super();
    	setText(text);
    }

    @Override
    protected Element initWidget() {
    	Element e = Document.get().createPushButtonElement();
    	Text t = Document.get().createTextNode("");
    	e.appendChild(t);
        return e;
    }
    @Override
    protected void initStyle() {
        getElement().addClassName(Constants.BOOTSTRAP_BUTTON_PREFIX);
    }
    
    public void setType(ButtonTypes type) {
    	getElement().setAttribute(Constants.ATTRIB_TYPE, type.name().toLowerCase());
    }
    @Override
    public ButtonTypes getType() {
    	return ButtonTypes.valueOf(getElement().getAttribute(Constants.ATTRIB_TYPE));
    }
    
    @Override
    public ButtonStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_BUTTON_PREFIX, ButtonStyles.class);
    }
    @Override
    public void setStyle(ButtonStyles style) {
    	JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_BUTTON_PREFIX, style);
    }
    
	@Override
	public String getText() {
		return getTextElement().getNodeValue();
	}
	@Override
	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}
	public void setLoadingText(String text){
		getElement().setAttribute(Constants.ATTRIB_DATA_LOADING_TEXT, text);
	}
	public String getLoadingText() {
		return getElement().getAttribute(Constants.ATTRIB_DATA_LOADING_TEXT);
	}
	@Override
	public void setState(ButtonStates state) {
		JqueryUtils.setButtonLoading(getBaseElement(), state.name().toLowerCase());
	}
	
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
    	JqueryEvents.addDomClickHandler(this);
        return addHandler(handler, ClickEvent.getType());
    }
    
    @Override
    public Text getTextElement() {
    	return getElement().getFirstChild().cast();
	}

}