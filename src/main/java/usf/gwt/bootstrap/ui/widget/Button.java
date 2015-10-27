package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.ButtonStates;
import usf.gwt.bootstrap.ui.core.Constants.ButtonStyles;
import usf.gwt.bootstrap.ui.core.Constants.ButtonTypes;
import usf.gwt.bootstrap.ui.core.Constants.HasCollapser;
import usf.gwt.bootstrap.ui.core.Constants.HasIcon;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;
import usf.gwt.bootstrap.ui.core.Constants.HasState;
import usf.gwt.bootstrap.ui.core.Constants.HasStyle;
import usf.gwt.bootstrap.ui.core.Constants.HasType;
import usf.gwt.bootstrap.ui.core.Constants.IconTypes;
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

public class Button extends FormControl<String> implements HasNodeText, HasIcon<Constants.IconTypes>,
	HasStyle<ButtonStyles>, HasState<ButtonStates>, HasType<ButtonTypes>, HasCollapser, HasClickHandlers {

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
    	e.appendChild(text = HasNodeText.Utils.create(""));
        return e;
    }
    
    @Override
    protected void initStyle() {
        getElement().addClassName(Constants.BOOTSTRAP_BUTTON_PREFIX);
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
	public void setIcon(IconTypes icon) {
		HasIcon.Utils.setIcon(this, icon);
	}
	@Override
	public IconTypes getIcon() {
		return HasIcon.Utils.getIcon(this, IconTypes.class);
	}
	@Override
	public ButtonStyles getStyle() {
		return HasStyle.Utils.getStyle(this, ButtonStyles.class);
	}
	@Override
	public void setStyle(ButtonStyles style) {
		HasStyle.Utils.setStyle(this, style);
	}
    
    public void setType(ButtonTypes type) {
    	getElement().setAttribute(Constants.ATTRIB_TYPE, type.name().toLowerCase());
    }
    @Override
    public ButtonTypes getType() {
    	return ButtonTypes.valueOf(getElement().getAttribute(Constants.ATTRIB_TYPE));
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
	public void setTarget(String id) {
		HasCollapser.Utils.setTarget(this, id);
	}	
	@Override
	public String getTarget() {
		return HasCollapser.Utils.getTarget(this);
	}
	
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
    	JqueryEvents.addDomClickHandler(this);
        return addHandler(handler, ClickEvent.getType());
    }
    
	@Override
	public void setIconElement(SpanElement e) {
		getBaseElement().insertFirst(icon = e);
	}
    @Override
    public Text getTextElement() {
    	return text;
	}
    @Override
    public Element getStylElement() {
    	return getElement();
    }
	@Override
	public SpanElement getIconElement() {
		return icon;
	}

}
