package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;

import com.google.gwt.user.client.ui.Widget;

public class InputGroup extends Layout {

	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.DEFAULT_INPUT_GROUP_STYLE);
	}
	
	@Override
	public void add(Widget child) {
		if(child instanceof InputGroupAddOn) 
			child.addStyleName(Constants.DEFAULT_GROUP_ADD_ON_STYLE);
		super.add(child);
	}

}
