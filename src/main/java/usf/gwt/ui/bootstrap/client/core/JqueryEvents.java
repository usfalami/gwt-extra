package usf.gwt.ui.bootstrap.client.core;

import usf.gwt.ui.bootstrap.client.event.SubmitEvent.HasSubmitHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;

public final class JqueryEvents {
	
    public static final native void addDomClickHandler(final HasClickHandlers w)/*-{
		if(w.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._hasClick) return;
		$wnd.$(w.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()).click(function(e) {
			@com.google.gwt.event.dom.client.ClickEvent::fireNativeEvent(Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/event/shared/HasHandlers;)(e,w);
		});
		w.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._hasClick=true;
	}-*/;
    
    public static final native void addDomClickHandler(final HasClickHandlers w, final JavaScriptObject funct)/*-{
		if(w.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._hasClick) return;
		var elem = $wnd.$(w.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()());
		elem.click(funct);
		elem.click(function(e) {
			@com.google.gwt.event.dom.client.ClickEvent::fireNativeEvent(Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/event/shared/HasHandlers;)(e,w);
		});
		w.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._hasClick=true;
	}-*/;
    
    public static final native void addDomChangeHandler(final HasChangeHandlers c)/*-{
		if(c.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._hasChange) return;
		$wnd.$(c.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()).change(function(e) {
			@com.google.gwt.event.dom.client.ChangeEvent::fireNativeEvent(Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/event/shared/HasHandlers;)(e,c);
		});
		c.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._hasChange=true;
	}-*/;
    public static final native void addDomSubmitHandler(final HasSubmitHandler f)/*-{
    	if(f.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._submit) return;
    	$wnd.$(f.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()).submit(function(e) {
    		f.@com.google.gwt.user.client.ui.Widget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(
				@usf.gwt.ui.bootstrap.client.event.SubmitEvent::new(Lcom/google/gwt/dom/client/NativeEvent;)(e));
    	});
    	f.@usf.gwt.ui.bootstrap.client.Bootstrap::getBaseElement()()._submit=true;
    }-*/;
    
}
