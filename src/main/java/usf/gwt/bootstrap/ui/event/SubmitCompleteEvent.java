package usf.gwt.bootstrap.ui.event;

import usf.gwt.bootstrap.ui.event.SubmitCompleteEvent.SubmitCompleteHandler;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class SubmitCompleteEvent extends GwtEvent<SubmitCompleteHandler> {

    public static final Type<SubmitCompleteHandler> type = new Type<SubmitCompleteHandler>();
    
	@Override
	public Type<SubmitCompleteHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(SubmitCompleteHandler handler) {
		handler.onSubmitComplete(this);
	}
	
	public static interface SubmitCompleteHandler extends EventHandler {
		void onSubmitComplete(SubmitCompleteEvent handler);
	}
	public static interface HasSubmitCompleteHandler extends EventHandler {
		HandlerRegistration addSubmitCompleteHandler(SubmitCompleteHandler handler);
	}

}
