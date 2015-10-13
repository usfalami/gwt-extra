package usf.gwt.bootstrap.ui.widget;

import com.google.gwt.user.client.ui.Widget;

public class InputGroup extends Layout {

	private static final String DEFAULT_INPUT_GROUP_STYLE = "input-group";
	private static final String DEFAULT_GROUP_ADD_ON_STYLE = "input-group-addon";
	
	@Override
	protected void initStyle() {
		getElement().addClassName(DEFAULT_INPUT_GROUP_STYLE);
	}
	
	@Override
	public void add(Widget child) {
		if(child instanceof InputGroupAddOn) 
			child.addStyleName(DEFAULT_GROUP_ADD_ON_STYLE);
		super.add(child);
	}

}
