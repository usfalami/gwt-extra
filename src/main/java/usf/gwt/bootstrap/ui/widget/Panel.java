package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasStyle;
import usf.gwt.bootstrap.ui.core.Constants.PanelStyles;

import com.google.gwt.dom.client.Element;

public class Panel extends Layout implements Constants.HasStyle<Constants.PanelStyles> {
	
	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.BOOTSTRAP_PANEL_PREFIX);
	}

	@Override
	public Constants.PanelStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.PanelStyles.class);
	}
	@Override
	public void setStyle(Constants.PanelStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
	}
    
	@Override
	public Element getStylElement() {
		return getElement();
	}
}
