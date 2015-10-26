package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasIcon;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;
import usf.gwt.bootstrap.ui.core.Constants.IconTypes;
import usf.gwt.bootstrap.ui.js.JqueryEvents;
import usf.gwt.bootstrap.ui.widget.Bootstrap.InputGroupAddOn;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class Anchor extends BootstrapWidget implements HasNodeText, HasIcon<IconTypes>, InputGroupAddOn, HasClickHandlers {

	Text text;
	SpanElement icon;
	
	@Override
	protected Element initWidget() {
		AnchorElement e = Document.get().createAnchorElement();
		e.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
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
	public void setIcon(IconTypes icon) {
		HasIcon.Utils.setIcon(this, icon);
	}
	@Override
	public IconTypes getIcon() {
		return HasIcon.Utils.getIcon(this, IconTypes.class);
	}
	
	public void setHref(String uri) {
		getBaseElement().setHref(uri);
	}
	public String getHref() {
		return getBaseElement().getHref();
	}
	
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		JqueryEvents.addDomClickHandler(this);
		return addHandler(handler, ClickEvent.getType());
	}

	@Override
	public void setIconElement(SpanElement e) {
		getElement().insertFirst(icon = e);
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
	public AnchorElement getBaseElement() {
		return getElement().cast();
	}
}
