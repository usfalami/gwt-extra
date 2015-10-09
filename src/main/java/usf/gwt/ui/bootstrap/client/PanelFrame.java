package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.HasStyle;
import usf.gwt.ui.bootstrap.client.Bootstrap.PanelFrameStyles;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;

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
