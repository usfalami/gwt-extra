package usf.gwt.bootstrap.ui.event;

import usf.gwt.bootstrap.ui.event.ShowEvent.ShowHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class ShowEvent extends GwtEvent<ShowHandler> {

    public static final Type<ShowHandler> type = new Type<ShowHandler>();

    public ShowEvent() {
    }
    
	@Override
	public Type<ShowHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(ShowHandler handler) {
		handler.onShow(this);
	}
	
	public static interface ShowHandler extends EventHandler {
		public void onShow(ShowEvent handler);
	}
	public static interface HasShowHandlers extends EventHandler {
		public HandlerRegistration addShowHandler(ShowHandler handler);
	}

}
