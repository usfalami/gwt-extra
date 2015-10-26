package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.List;


public class Group extends List {
	
	@Override
	protected void initStyle() {
		getContainerElement().addClassName(Constants.DEFAULT_GROUP_STYLE);
	}
	
}
