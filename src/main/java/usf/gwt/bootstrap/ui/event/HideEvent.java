package usf.gwt.bootstrap.ui.event;

import usf.gwt.bootstrap.ui.event.HideEvent.HideHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class HideEvent extends GwtEvent<HideHandler> {

    public static final Type<HideHandler> type = new Type<HideHandler>();

    public HideEvent() {
    }
    
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<HideHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(HideHandler handler) {
		handler.onHide(this);
	}
	
	public static interface HideHandler extends EventHandler {
		public void onHide(HideEvent handler);
	}
	public static interface HasHideHandlers extends EventHandler {
		public HandlerRegistration addHideHandler(HideHandler handler);
	}

}
