package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;
import usf.gwt.bootstrap.ui.core.ListItem;
import usf.gwt.bootstrap.ui.js.JqueryEvents;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.Collapser;

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
public class NavItem extends ListItem implements Constants.HasIcon<Constants.IconTypes>, HasClickHandlers, Collapser {
	
	Text text;
	
	public NavItem() {}
	
    public NavItem(String text) {
    	setText(text);
	}
    public NavItem(Constants.IconTypes icon) {
    	setIcon(icon);
	}
    public NavItem(Constants.IconTypes icon, String text) {
    	setIcon(icon);
    	setText(text);
	}
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createLIElement();
		e.setAttribute(Constants.ATTRIB_ROLE, Constants.VALUE_PRESENTATION);
		AnchorElement a = Document.get().createAnchorElement();
		a.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
		a.appendChild(text = HasNodeText.Utils.create(""));
		e.appendChild(a);
		return e;
	}
	@Override
	protected void initStyle() {
		getContainerElement().addClassName(Constants.GWT_BOOTSTRAP_NAV_ITEM);
	}
	
	@Override
    public void setIcon(Constants.IconTypes icon) {
		getIconElement().addClassName(Constants.BOOTSTRAP_ICON_PREFIX); //temp
    	JqueryUtils.toggleClass(getBaseElement(), icon);
    }
	@Override
    public Constants.IconTypes getIcon() {
    	return JqueryUtils.hasClass(getElement(), Constants.IconTypes.class);
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
		return text;
	}
	
	@Override
	public void setIconElement(SpanElement e) {//TODO
//		if((icon = e) != null)
//			getElement().insertFirst(icon);
	}
	@Override
	public Element getIconElement() {
		return getElement().getFirstChildElement().cast();
	}
}
