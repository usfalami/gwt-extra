package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasStyle;
import usf.gwt.bootstrap.ui.core.Constants.NavStyles;
import usf.gwt.bootstrap.ui.core.List;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Element;

public class Nav extends List implements Constants.HasStyle<Constants.NavStyles> {
        
    @Override
    protected void initStyle() {
    	getContainerElement().addClassName(Constants.BOOTSTRAP_NAV_PREFIX);
    	getContainerElement().addClassName(Constants.GWT_BOOTSTRAP_NAV);
    }
	
    @Override
	public Constants.NavStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.NavStyles.class);
	}
	@Override
	public void setStyle(Constants.NavStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
	}
	
    public void setStacked(boolean stack){
    	Constants.HasStyle.Utils.setStyle(getContainerElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE, stack);
    }
    public boolean isStacked() {
    	return Constants.HasStyle.Utils.hasStyle(getContainerElement(), Constants.BOOTSTRAP_NAV_STACKED_STYLE);
	}
    
    public void setActiveUnique() {
    	JqueryUtils.activateUnique(getElement(), false);
	}
    
	@Override
	public Element getStylElement() {
		return getContainerElement();
	}
	
    //	$('li.gwt-bootstrap-nav-item > a', e).eq(0).click();
}
