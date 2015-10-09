package usf.gwt.ui.timeline.client.event;

import usf.gwt.ui.timeline.client.entry.TimeLineEntry;
import usf.gwt.ui.timeline.client.event.ItemSelectionChangeEvent.ItemSelectionChangeHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;


public class ItemSelectionChangeEvent extends GwtEvent<ItemSelectionChangeHandler> {

    public static final Type<ItemSelectionChangeHandler> type = new Type<ItemSelectionChangeHandler>();

    private TimeLineEntry entry;
    
    public ItemSelectionChangeEvent(TimeLineEntry entry) {
    	this.entry = entry;
	}
    public TimeLineEntry getEntry() {
		return entry;
	}
    
	@Override
	public Type<ItemSelectionChangeHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(ItemSelectionChangeHandler handler) {
		handler.onItemSelectionChange(this);
	}
	
	public static interface ItemSelectionChangeHandler extends EventHandler {
		public void onItemSelectionChange(ItemSelectionChangeEvent event);
	}
	public static interface HasItemSelectionChangeHandler {
		public HandlerRegistration addItemSelectionChangeHandler(ItemSelectionChangeHandler handler);
	}
}
