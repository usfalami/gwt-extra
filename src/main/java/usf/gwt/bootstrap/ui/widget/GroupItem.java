package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.ListItem;

public class GroupItem extends ListItem {
	
	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.DEGAULT_GROUP_ITEM_STYLE);
	}

}
