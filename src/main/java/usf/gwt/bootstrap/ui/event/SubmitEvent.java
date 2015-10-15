package usf.gwt.bootstrap.ui.event;

import usf.gwt.bootstrap.ui.event.SubmitEvent.SubmitHandler;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class SubmitEvent extends GwtEvent<SubmitHandler> implements HasNativeEvent {

    public static final Type<SubmitHandler> type = new Type<SubmitHandler>();

    private NativeEvent nativeEvent;
    
    public SubmitEvent(NativeEvent event) {
    	this.nativeEvent = event;
    }
    public void cancel() {
    	nativeEvent.preventDefault();
	}
    
	@Override
	public Type<SubmitHandler> getAssociatedType() {
		return type;
	}
	@Override
	protected void dispatch(SubmitHandler handler) {
		handler.onSubmit(this);
	}
	
	public static interface SubmitHandler extends EventHandler {
		void onSubmit(SubmitEvent handler);
	}
	public static interface HasSubmitHandler extends EventHandler {
		HandlerRegistration addSubmitHandler(SubmitHandler handler);
	}
	
	@Override
	public NativeEvent getNativeEvent() {
		return nativeEvent;
	}

}
