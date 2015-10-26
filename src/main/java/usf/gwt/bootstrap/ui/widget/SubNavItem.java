package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasCollapser;
import usf.gwt.bootstrap.ui.core.Constants.NavStyles;

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
public class SubNavItem extends NavItem {
	
	protected Nav nav;
	
	@Override
	protected Element initWidget() {
		Element e = super.initWidget();
		nav = new Nav();
		nav.setId(Document.get().createUniqueId());
		e.appendChild(nav.getElement());
		HasCollapser.Utils.setTarget(getBaseElement(), nav.getId());
		nav.setCollapsed(false);
		return e;
	}
    @Override
    protected void initStyle() {
    	getElement().addClassName(Constants.GWT_BOOTSTRAP_SUB_NAV);
    	nav.getContainerElement().removeClassName(Constants.GWT_BOOTSTRAP_NAV);
    }

	public NavStyles getStyle() {
		return nav.getStyle();
	}
	public void setStyle(NavStyles style) {
		nav.setStyle(style);
	}
	
    public void setStacked(boolean stack){
    	nav.setStacked(stack);
    }
    public boolean isStacked() {
    	return nav.isStacked();
	}
    
	@Override
	public Element getContainerElement() {
		return nav.getContainerElement();
	}
	
}