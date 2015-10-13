package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.List;


public class Group extends List {
	
	public static final String DEFAULT_GROUP_STYLE = "list-group";
	
	@Override
	protected void initStyle() {
		getContainerElement().addClassName(DEFAULT_GROUP_STYLE);
	}
	
}
