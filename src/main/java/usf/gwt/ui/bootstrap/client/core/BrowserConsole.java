package usf.gwt.ui.bootstrap.client.core;

public class BrowserConsole {
	
	static {
		init();
	}
	
	public static final native void init() /*-{
		$wnd.logLevel=0;
	}-*/;

	public static final native void error(Object o)/*-{$wnd.logLevel<6 && $wnd.console.error(o);}-*/;
	public static final native void warn(Object o)/*-{$wnd.logLevel<5 && $wnd.console.warn(o);}-*/;
	public static final native void info(Object o)/*-{$wnd.logLevel<4 && $wnd.console.info(o);}-*/;
	public static final native void debug(Object o)/*-{$wnd.logLevel<3 && $wnd.console.debug(o);}-*/;
	public static final native void trace(Object o)/*-{$wnd.logLevel<2 && $wnd.console.trace(o);}-*/;
	public static final native void log(Object o)/*-{$wnd.logLevel<1 && $wnd.console.log(o);}-*/;
	
	public static final native void group()/*-{$wnd.console.group();}-*/;
	public static final native void groupEnd()/*-{$wnd.console.groupEnd();}-*/;
	
}
