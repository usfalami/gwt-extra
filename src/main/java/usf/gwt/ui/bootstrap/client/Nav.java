package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.HasStyle;
import usf.gwt.ui.bootstrap.client.Bootstrap.NavStyles;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;
import usf.gwt.ui.bootstrap.client.core.List;

public class Nav extends List implements HasStyle<NavStyles> {
        
    @Override
    protected void initStyle() {
    	getContainerElement().addClassName(Constants.BOOTSTRAP_NAV_PREFIX);
    	getContainerElement().addClassName(Constants.GWT_BOOTSTRAP_NAV);
    }
    @Override
    public void setStyle(NavStyles style) {
    	JqueryUtils.switchClass(getContainerElement(), Constants.BOOTSTRAP_NAV_PREFIX, style, Constants.BOOTSTRAP_NAV_STACKED_STYLE);
	}
    @Override
    public NavStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE, NavStyles.class, Constants.BOOTSTRAP_NAV_STACKED_STYLE);
    }
    public void setStacked(boolean stack){
    	JqueryUtils.switchClass(getContainerElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE, stack);
    }
    public boolean isStacked() {
    	return JqueryUtils.hasClass(getContainerElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE);
	}
    
    public void setActiveUnique() {
    	JqueryUtils.activateUnique(getElement(), false);
	}
	
    //	$('li.gwt-bootstrap-nav-item > a', e).eq(0).click();
}
