package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;
import usf.gwt.bootstrap.ui.core.Constants.IconTypes;
import usf.gwt.bootstrap.ui.core.ListItem;
import usf.gwt.bootstrap.ui.js.JqueryEvents;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * <pre>{@code
 *  <li role='presentation'>
 *   <a href="">
 *  </li>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class NavItem extends ListItem implements HasClickHandlers {
	
	AnchorElement anchor;
	
	public NavItem() {}
	
    public NavItem(String text) {
    	setText(text);
	}
    public NavItem(IconTypes icon) {
    	setIcon(icon);
	}
    public NavItem(IconTypes icon, String text) {
    	setIcon(icon);
    	setText(text);
	}
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createLIElement();
		e.setAttribute(Constants.ATTRIB_ROLE, Constants.VALUE_PRESENTATION);
		anchor = Document.get().createAnchorElement();
		anchor.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
		anchor.appendChild(text = HasNodeText.Utils.create(""));
		e.appendChild(anchor);
		return e;
	}
	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.GWT_BOOTSTRAP_NAV_ITEM);
	}
	
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		JqueryEvents.addDomClickHandler(this);
		return addHandler(handler, ClickEvent.getType());
	}
	
	@Override
	public AnchorElement getBaseElement() {
		return anchor;
	}
	@Override
	public Text getTextElement() {
		return text;
	}
	@Override
	public void setIconElement(SpanElement e) {//TODO
		getBaseElement().insertFirst(this.icon = e);
	}
}
