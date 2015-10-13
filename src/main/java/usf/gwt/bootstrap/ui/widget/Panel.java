package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;
import usf.gwt.bootstrap.ui.widget.Bootstrap.PanelStyles;

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
