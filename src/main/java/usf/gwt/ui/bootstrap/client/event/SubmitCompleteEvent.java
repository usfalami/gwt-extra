package usf.gwt.ui.bootstrap.client.event;

import usf.gwt.ui.bootstrap.client.event.SubmitCompleteEvent.SubmitCompleteHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class SubmitCompleteEvent extends GwtEvent<SubmitCompleteHandler> {

    public static final Type<SubmitCompleteHandler> type = new Type<SubmitCompleteHandler>();
    
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SubmitCompleteHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(SubmitCompleteHandler handler) {
		handler.onSubmitComplete(this);
	}
	
	public static interface SubmitCompleteHandler extends EventHandler {
		public void onSubmitComplete(SubmitCompleteEvent handler);
	}
	public static interface HasSubmitCompleteHandler extends EventHandler {
		public HandlerRegistration addSubmitCompleteHandler(SubmitCompleteHandler handler);
	}

}
