package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;
import usf.gwt.bootstrap.ui.widget.Bootstrap.ValidationStyles;

import com.google.gwt.dom.client.Element;

public class FormGroup extends GridCol implements HasStyle<ValidationStyles> {
	
	private static final String FORM_GROUP_STYLE = "form-group";

	@Override
	protected Element initWidget() {
		return super.initWidget(); 
	}
	
	@Override
	protected void initStyle() {
		getElement().addClassName(FORM_GROUP_STYLE);
	}
	
	@Override
	public void setStyle(ValidationStyles style) {
		JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_VALIDATION_PREFIX, style);
	}
	@Override
	public ValidationStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_VALIDATION_PREFIX, ValidationStyles.class);
	}
	
}
