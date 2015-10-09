package usf.gwt.ui;

import usf.gwt.ui.demo.Menu;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExtraGwt implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		RootPanel.get("sidebar").add(new Menu());
	}
	
}
