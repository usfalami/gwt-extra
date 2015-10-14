package usf.gwt.bootstrap.ui.js;

import usf.gwt.bootstrap.ui.event.SubmitEvent.HasSubmitHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;

public final class JqueryEvents {
	
    public static final native void addDomClickHandler(final HasClickHandlers w)/*-{
		if(w.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._hasClick) return;
		$wnd.$(w.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()).click(function(e) {
			@com.google.gwt.event.dom.client.ClickEvent::fireNativeEvent(Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/event/shared/HasHandlers;)(e,w);
		});
		w.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._hasClick=true;
	}-*/;
    
    public static final native void addDomClickHandler(final HasClickHandlers w, final JavaScriptObject funct)/*-{
		if(w.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._hasClick) return;
		var elem = $wnd.$(w.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()());
		elem.click(funct);
		elem.click(function(e) {
			@com.google.gwt.event.dom.client.ClickEvent::fireNativeEvent(Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/event/shared/HasHandlers;)(e,w);
		});
		w.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._hasClick=true;
	}-*/;
    
    public static final native void addDomChangeHandler(final HasChangeHandlers c)/*-{
		if(c.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._hasChange) return;
		$wnd.$(c.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()).change(function(e) {
			@com.google.gwt.event.dom.client.ChangeEvent::fireNativeEvent(Lcom/google/gwt/dom/client/NativeEvent;Lcom/google/gwt/event/shared/HasHandlers;)(e,c);
		});
		c.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._hasChange=true;
	}-*/;
    public static final native void addDomSubmitHandler(final HasSubmitHandler f)/*-{
    	if(f.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._submit) return;
    	$wnd.$(f.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()).submit(function(e) {
    		f.@com.google.gwt.user.client.ui.Widget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(
				@usf.gwt.bootstrap.ui.event.SubmitEvent::new(Lcom/google/gwt/dom/client/NativeEvent;)(e));
    	});
    	f.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()()._submit=true;
    }-*/;
    

    public static final native int registerEvent(Element w, String event, JavaScriptObject funct, boolean append)/*-{
		if(append || !w[event]){
			$wnd.$(w).on(event, null, 'gwtEvent', funct);
			w[event] = true;
		}
		else $wnd.console.log(event + " event is already attach on ", w);
    }-*/;
    
}
