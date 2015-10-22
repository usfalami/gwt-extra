package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasStyle;
import usf.gwt.bootstrap.ui.widget.Bootstrap.ValidationStyles;

public class FormGroup extends GridCol implements HasStyle<ValidationStyles> {
	
	private static final String FORM_GROUP_STYLE = "form-group";

	@Override
	protected void initStyle() {
		getElement().addClassName(FORM_GROUP_STYLE);
	}
	
	@Override
	public ValidationStyles getStyle() {
		return HasStyle.Utils.getStyle(this, ValidationStyles.class);
	}
	@Override
	public void setStyle(ValidationStyles style) {
		HasStyle.Utils.setStyle(this, style);
	}
	
	@Override
	public String getPrimaryStyle() {
		return Constants.BOOTSTRAP_VALIDATION_PREFIX;
	}
	
}
