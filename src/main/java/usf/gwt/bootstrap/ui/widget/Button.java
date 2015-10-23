package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryEvents;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class Button extends FormControl<String> implements Constants.HasIcon<Constants.IconTypes>,
	Constants.HasStyle<Constants.ButtonStyles>, Constants.HasState<Constants.ButtonStates>, Constants.HasType<Constants.ButtonTypes>, HasClickHandlers {

	Text text;
	SpanElement icon;
	
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
    	e.appendChild(text = Constants.HasText.Utils.create(""));
        return e;
    }
    
    @Override
    protected void initStyle() {
        getElement().addClassName(Constants.BOOTSTRAP_BUTTON_PREFIX);
    }
    
	@Override
	public String getText() {
		return Constants.HasText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		Constants.HasText.Utils.setText(this, text);
	}
	@Override
	public void setIcon(Constants.IconTypes icon) {
		if(this.icon == null) 
			getBaseElement().insertFirst(this.icon = Constants.HasIcon.Utils.create());
		Constants.HasIcon.Utils.setIcon(this, icon);
	}
	@Override
	public Constants.IconTypes getIcon() {
		return Constants.HasIcon.Utils.getIcon(this, Constants.IconTypes.class);
	}
	@Override
	public Constants.ButtonStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.ButtonStyles.class);
	}
	@Override
	public void setStyle(Constants.ButtonStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
	}
    
    public void setType(Constants.ButtonTypes type) {
    	getElement().setAttribute(Constants.ATTRIB_TYPE, type.name().toLowerCase());
    }
    @Override
    public Constants.ButtonTypes getType() {
    	return Constants.ButtonTypes.valueOf(getElement().getAttribute(Constants.ATTRIB_TYPE));
    }

	public void setLoadingText(String text){
		getElement().setAttribute(Constants.ATTRIB_DATA_LOADING_TEXT, text);
	}
	public String getLoadingText() {
		return getElement().getAttribute(Constants.ATTRIB_DATA_LOADING_TEXT);
	}
	@Override
	public void setState(Constants.ButtonStates state) {
		JqueryUtils.setButtonLoading(getBaseElement(), state.name().toLowerCase());
	}
	
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
    	JqueryEvents.addDomClickHandler(this);
        return addHandler(handler, ClickEvent.getType());
    }
    
	@Override
	public SpanElement getIconElement() {
		return icon;
	}
    @Override
    public Text getTextElement() {
    	return text;
	}
    @Override
    public Element getStylElement() {
    	return getElement();
    }

}
