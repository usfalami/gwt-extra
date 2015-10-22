package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.widget.Bootstrap.AlertStyles;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;

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
		return HasStyle.Utils.getStyle(this, AlertStyles.class);
	}
	@Override
	public void setStyle(AlertStyles style) {
		HasStyle.Utils.setStyle(this, style);
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
    
    @Override
    public String getPrimaryStyle() {
    	return Constants.BOOTSTRAP_ALERT_PREFIX;
    }
}
