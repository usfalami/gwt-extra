package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.AlertStyles;
import usf.gwt.ui.bootstrap.client.Bootstrap.HasStyle;
import usf.gwt.ui.bootstrap.client.core.BootstrapContainer;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Alert extends BootstrapContainer implements HasStyle<AlertStyles> {

    protected Element close; 
    
    @Override
    protected Element initWidget() {
    	Element div = Document.get().createDivElement();
        close = Document.get().createPushButtonElement();
        close.setAttribute("data-dismiss", "alert");
        close.setAttribute("aria-hidden", "true");
        close.setInnerHTML("&times;");
        return div;
    }
    
    @Override
    protected void initStyle() {
    	getElement().addClassName("alert");
        close.addClassName("close");
        setStyle(AlertStyles.INFO);
        setDismissable(true);
    }
    
    @Override
    public AlertStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_ALERT_PREFIX, AlertStyles.class);
    }
	@Override
	public void setStyle(AlertStyles style) {
		JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_ALERT_PREFIX, style);
	}

    public void setDismissable(boolean dismissable) {
        if (dismissable) {
            getElement().addClassName("alert-dismissable");
            getElement().appendChild(close);
        } else {
        	getElement().removeClassName("alert-dismissable");
            close.removeFromParent();
        }
    }
}
