package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.AlertStyles;
import usf.gwt.bootstrap.ui.core.Constants.HasStyle;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class Alert extends BootstrapContainer implements Constants.HasStyle<Constants.AlertStyles> {

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
        setStyle(Constants.AlertStyles.INFO);
        setDismissable(true);
    }
    
	@Override
	public Constants.AlertStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.AlertStyles.class);
	}
	@Override
	public void setStyle(Constants.AlertStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
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
    public Element getStylElement() {
    	return getElement();
    }
    
}
