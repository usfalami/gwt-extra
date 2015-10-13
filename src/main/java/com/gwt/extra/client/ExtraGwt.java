package com.gwt.extra.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.extra.client.demo.Menu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExtraGwt implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		RootPanel.get("sidebar").add(new Menu());
	}
	
}
