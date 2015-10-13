package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasIcon;
import usf.gwt.bootstrap.ui.widget.Bootstrap.IconTypes;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;


/**
 * <pre>{@code
 *  <li>
 *   <a role='presentation'> ... </a>
 *    <ul class='nav' >
 *    </ul>
 *  </li>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class SubNavItem extends Nav implements HasIcon<IconTypes> {
	
	protected NavItem i;
	
	@Override
	protected Element initWidget() {
		i = new NavItem();
		Element l = super.initWidget();
		l.setId(Document.get().createUniqueId());
		i.getElement().appendChild(l);
		JqueryUtils.attachCollapser(i.getBaseElement(), l);
		return i.getElement();
	}
    @Override
    protected void initStyle() {
    	getContainerElement().addClassName(Constants.BOOTSTRAP_NAV_PREFIX);
    	JqueryUtils.switchClass(i.getElement(), Constants.GWT_BOOTSTRAP_NAV_ITEM, Constants.GWT_BOOTSTRAP_SUB_NAV);
    }
	
	public String getText() {
		return i.getText();
	}
	public void setText(String text) {
		i.setText(text);
	}
    public void setIcon(IconTypes icon) {
    	i.setIcon(icon);
    }
    public IconTypes getIcon() {
    	return i.getIcon();
	}

	public void setCollapsed(boolean collapse) {
		JqueryUtils.collapse(getBaseElement(), getContainerElement(), collapse);
	}

	/**
	 * Return the Anchor Element
	 */
	@Override
	public Element getBaseElement() {
		return i.getBaseElement();
	}
	/**
	 * Return the UL Element
	 */
	@Override
	protected Element getContainerElement() {
		return getElement().getChild(1).cast();
	}
	@Override
	public Element getIconElement() {
		return i.getIconElement();
	}
}