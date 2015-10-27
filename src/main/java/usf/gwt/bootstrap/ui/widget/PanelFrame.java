package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants.HasStyle;
import usf.gwt.bootstrap.ui.core.Constants.PanelFrameStyles;

import com.google.gwt.dom.client.Element;

public class PanelFrame extends Layout implements HasStyle<PanelFrameStyles> {
	
	@Override
	public PanelFrameStyles getStyle() {
		return HasStyle.Utils.getStyle(this, PanelFrameStyles.class);
	}
	@Override
	public void setStyle(PanelFrameStyles style) {
		HasStyle.Utils.setStyle(this, style);
	}
    
	@Override
	public Element getStylElement() {
		return getElement();
	}

}
