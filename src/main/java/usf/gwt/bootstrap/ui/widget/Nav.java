package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasStyle;
import usf.gwt.bootstrap.ui.core.Constants.NavStyles;
import usf.gwt.bootstrap.ui.core.List;

import com.google.gwt.dom.client.Element;

public class Nav extends List implements HasStyle<NavStyles> {
        
    @Override
    protected void initStyle() {
    	getContainerElement().addClassName(Constants.BOOTSTRAP_NAV_PREFIX);
    	getContainerElement().addClassName(Constants.GWT_BOOTSTRAP_NAV);
    }
	
    @Override
	public NavStyles getStyle() {
		return HasStyle.Utils.getStyle(this, NavStyles.class);
	}
	@Override
	public void setStyle(NavStyles style) {
		HasStyle.Utils.setStyle(this, style);
	}
	
    public void setStacked(boolean stack){
    	HasStyle.Utils.setStyle(getContainerElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE, stack);
    }
    public boolean isStacked() {
    	return HasStyle.Utils.hasStyle(getContainerElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE);
	}
    
    public void setActiveUnique() {
    	HasStyle.Utils.setStyleUnique(getElement(), Constants.BOOTSTRAP_ACTIVE, false);
	}
    
	@Override
	public Element getStylElement() {
		return getContainerElement();
	}
	
    //	$('li.gwt-bootstrap-nav-item > a', e).eq(0).click();
}
