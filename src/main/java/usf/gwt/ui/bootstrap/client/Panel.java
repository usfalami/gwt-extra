package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.HasStyle;
import usf.gwt.ui.bootstrap.client.Bootstrap.PanelStyles;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;

public class Panel extends Layout implements HasStyle<PanelStyles> {
	
	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.BOOTSTRAP_PANEL_PREFIX);
	}

    @Override
    public PanelStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_PANEL_PREFIX, PanelStyles.class);
    }
    @Override
    public void setStyle(PanelStyles style) {
    	JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_PANEL_PREFIX, style);
    }
}
