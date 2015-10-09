package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.HasText;
import usf.gwt.ui.bootstrap.client.Bootstrap.InputGroupAddOn;
import usf.gwt.ui.bootstrap.client.core.BootstrapWidget;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryEvents;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class Anchor extends BootstrapWidget implements HasText, InputGroupAddOn, HasClickHandlers {

	@Override
	protected Element initWidget() {
		AnchorElement e = Document.get().createAnchorElement();
		e.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
		Text t = Document.get().createTextNode("");
		e.appendChild(t);
		return e;
	}
	
	public void setHref(String uri) {
		getBaseElement().setHref(uri);
	}
	public String getHref() {
		return getBaseElement().getHref();
	}
	@Override
	public String getText() {
		return getTextElement().getNodeValue();
	}
	@Override
	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}
	
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		JqueryEvents.addDomClickHandler(this);
		return addHandler(handler, ClickEvent.getType());
	}
	
	@Override
	public AnchorElement getBaseElement() {
		return getElement().cast();
	}
	@Override
	public Text getTextElement() {
		return getElement().getFirstChild().cast();
	}
	
}
