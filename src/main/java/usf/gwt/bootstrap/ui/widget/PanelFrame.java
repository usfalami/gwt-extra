package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;

import com.google.gwt.dom.client.Element;

public class PanelFrame extends Layout implements Constants.HasStyle<Constants.PanelFrameStyles> {
	
	@Override
	public Constants.PanelFrameStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.PanelFrameStyles.class);
	}
	@Override
	public void setStyle(Constants.PanelFrameStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
	}
    
	@Override
	public Element getStylElement() {
		return getElement();
	}

}
