package usf.gwt.bootstrap.ui.js;

import java.util.Date;

import usf.gwt.bootstrap.ui.event.HasValueChangeHandlers;
import usf.gwt.bootstrap.ui.event.HideEvent.HasHideHandlers;
import usf.gwt.bootstrap.ui.event.ShowEvent.HasShowHandlers;
import usf.gwt.bootstrap.ui.event.SubmitEvent.HasSubmitHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class JqueryEvents {
	
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
    
    public static final native void attachChangeHandler(final HasValueChangeHandlers<Date> h)/*-{
    	var e = h.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()();
    	var f = function(e) {h.@usf.gwt.bootstrap.ui.event.HasValueChangeHandlers::fireChangeEvent()();}
    	@usf.gwt.bootstrap.ui.js.JqueryEvents::registerEvent(Lcom/google/gwt/dom/client/Element;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)
    		(e, "dp.change", f, false);
	}-*/;
    public static final native void attachHideHandler(final HasHideHandlers h)/*-{
		var e = h.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()();
		var f = function(e) {
			h.@com.google.gwt.user.client.ui.Widget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)
				(@usf.gwt.bootstrap.ui.event.HideEvent::new()());
		}
		@usf.gwt.bootstrap.ui.js.JqueryEvents::registerEvent(Lcom/google/gwt/dom/client/Element;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)
			(e, "dp.hide", f, false);
	}-*/;
    public static final native void attachShowHandler(final HasShowHandlers h)/*-{
		var e = h.@usf.gwt.bootstrap.ui.widget.Bootstrap::getBaseElement()();
		var f = function(e) {
			h.@com.google.gwt.user.client.ui.Widget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)
				(@usf.gwt.bootstrap.ui.event.ShowEvent::new()());
		}
		@usf.gwt.bootstrap.ui.js.JqueryEvents::registerEvent(Lcom/google/gwt/dom/client/Element;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Z)
			(e, "dp.show", f, false);
	}-*/;

    public static final native int registerEvent(Element w, String event, JavaScriptObject funct, boolean append)/*-{
		if(append || !w['gwtEvent'] || !w['gwtEvent'].contains(event)){
			$wnd.$(w).on(event, null, 'gwtEvent', funct);
			w['gwtEvent'] += event+ ", ";
		}
		else $wnd.console.log(event + " event is already attach on ", w);
    }-*/;
    
}
