package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;
import usf.gwt.bootstrap.ui.widget.Bootstrap.PanelFrameStyles;

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
    public String getPrimaryStyle() {
    	return Constants.BOOTSTRAP_PANEL_PREFIX;
    }

}
