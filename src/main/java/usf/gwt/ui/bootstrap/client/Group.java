package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.core.List;

public class Group extends List {
	
	public static final String DEFAULT_GROUP_STYLE = "list-group";
	
	@Override
	protected void initStyle() {
		getContainerElement().addClassName(DEFAULT_GROUP_STYLE);
	}
	
}
