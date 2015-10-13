package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;
import usf.gwt.bootstrap.ui.widget.Bootstrap.PanelFrameStyles;

public class PanelFrame extends Layout implements HasStyle<PanelFrameStyles> {
	
    @Override
    public PanelFrameStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_PANEL_PREFIX, PanelFrameStyles.class);
    }
    @Override
    public void setStyle(PanelFrameStyles style) {
    	JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_PANEL_PREFIX, style);
    }

}
