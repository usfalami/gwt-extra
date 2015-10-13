package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.ListItem;

public class GroupItem extends ListItem {
	
	public static final String DEGAULT_GROUP_ITEM_STYLE = "list-group-item";
	
	@Override
	protected void initStyle() {
		getElement().addClassName(DEGAULT_GROUP_ITEM_STYLE);
	}

}
