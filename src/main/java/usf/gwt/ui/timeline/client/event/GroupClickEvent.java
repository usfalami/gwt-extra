package usf.gwt.ui.timeline.client.event;

import usf.gwt.ui.timeline.client.event.GroupClickEvent.GroupClickHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class GroupClickEvent extends GwtEvent<GroupClickHandler> {

    public static final Type<GroupClickHandler> type = new Type<GroupClickHandler>();

    private String groupName;
    
    public GroupClickEvent(String groupName) {
    	this.groupName = groupName;
	}
    public String getGroup() {
		return groupName;
	}
    
	@Override
	public Type<GroupClickHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(GroupClickHandler handler) {
		handler.onItemSelectionChange(this);
	}
	
	public static interface GroupClickHandler extends EventHandler {
		public void onItemSelectionChange(GroupClickEvent event);
	}
	public static interface HasGroupClickHandler {
		public HandlerRegistration addGroupClickHandler(GroupClickHandler handler);
	}
}
