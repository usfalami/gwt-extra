package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.event.SubmitEvent;
import usf.gwt.bootstrap.ui.event.SubmitEvent.HasSubmitHandler;
import usf.gwt.bootstrap.ui.js.JqueryEvents;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.FormStyles;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

/**
 * <pre>{@code
 *  <form role='form'> ... </form>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class Form extends BootstrapContainer implements HasStyle<FormStyles>, HasSubmitHandler {
	
	@Override
    protected Element initWidget() {
        Element form = Document.get().createFormElement();
        form.setAttribute(Constants.ATTRIB_ROLE, Constants.ATTRIB_FORM);
        return form;
    }

	@Override
	public FormStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_FORM_PREFIX, FormStyles.class);
	}
	@Override
	public void setStyle(FormStyles style) {
    	JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_FORM_PREFIX, style);
	}
    
    @Override
    public HandlerRegistration addSubmitHandler(SubmitEvent.SubmitHandler handler) {
    	JqueryEvents.addDomSubmitHandler(this);
    	return addHandler(handler, SubmitEvent.type);
    }
    
    @Deprecated
    public void insert(Widget child, int index) {
    	super.insert(child, getElement(), index, true);
    }
}
