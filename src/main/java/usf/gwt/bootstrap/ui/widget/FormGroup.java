package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;

import com.google.gwt.dom.client.Element;

public class FormGroup extends GridCol implements Constants.HasStyle<Constants.ValidationStyles> {
	
	private static final String FORM_GROUP_STYLE = "form-group";

	@Override
	protected void initStyle() {
		getElement().addClassName(FORM_GROUP_STYLE);
	}
	
	@Override
	public Constants.ValidationStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.ValidationStyles.class);
	}
	@Override
	public void setStyle(Constants.ValidationStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
	}
	@Override
	public Element getStylElement() {
		return getElement();
	}
	
}
