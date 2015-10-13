package com.gwt.extra.client.demo;

import com.google.gwt.user.client.ui.Composite;

public class SampleComposite extends Composite {
	
	@Override
	protected void onAttach() {
		super.onAttach();
		highlight();
	}
	
	public static final native void highlight() /*-{
		$wnd.SyntaxHighlighter.highlight();
		$wnd.$("div.syntaxhighlighter>div.toolbar").remove(); //remove syntaxhighlighter redirect url
	}-*/;

}
