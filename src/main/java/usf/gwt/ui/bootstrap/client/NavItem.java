package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.Collapser;
import usf.gwt.ui.bootstrap.client.Bootstrap.HasIcon;
import usf.gwt.ui.bootstrap.client.Bootstrap.IconTypes;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryEvents;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;
import usf.gwt.ui.bootstrap.client.core.ListItem;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
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
public class NavItem extends ListItem implements HasIcon<IconTypes>, HasClickHandlers, Collapser {
	
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
		AnchorElement a = Document.get().createAnchorElement();
		a.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
		Text text = Document.get().createTextNode("");
		a.appendChild(text);
		e.appendChild(a);
		return e;
	}
	@Override
	protected void initStyle() {
		getContainerElement().addClassName(Constants.GWT_BOOTSTRAP_NAV_ITEM);
	}
	
	@Override
    public void setIcon(IconTypes icon) {
		getIconElement().addClassName(Constants.BOOTSTRAP_ICON_PREFIX); //temp
    	JqueryUtils.switchClass(getBaseElement(), Constants.BOOTSTRAP_ICON_PREFIX, icon);
    }
	@Override
    public IconTypes getIcon() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_ICON_PREFIX, IconTypes.class);
    }
	
	@Override
	public void setTarget(String target) {
		JqueryUtils.attachCollapser(getBaseElement(), target);
	}
	
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		JqueryEvents.addDomClickHandler(this);
		return addHandler(handler, ClickEvent.getType());
	}
	
	@Override
	public AnchorElement getBaseElement() {
		return getElement().getFirstChildElement().cast();
	}
	@Override
	public Text getTextElement() {
		return getBaseElement().getFirstChild().cast();
	}
	@Override
	public Element getIconElement() {
		return getElement().getFirstChildElement().cast();
	}
}
