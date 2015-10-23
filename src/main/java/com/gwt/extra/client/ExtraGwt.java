package com.gwt.extra.client;

import usf.gwt.bootstrap.extra.datetimepicker.DateTimePicker;
import usf.gwt.bootstrap.ui.js.JavaScriptOption;
import usf.gwt.bootstrap.ui.widget.Button;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.extra.client.demo.Menu;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExtraGwt implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		
		JavaScriptOption icons = JavaScriptOption.createOption()
				.set("time", "fa fa-clock-o").set("date", "fa fa-calendar").set("up", "fa fa-chevron-up")
				.set("down", "fa fa-chevron-down").set("previous", "fa fa-chevron-left").set("next", "fa fa-chevron-right")
				.set("today", "fa fa-crosshairs").set("clear", "fa fa-trash").set("close", "fa fa-remove");
		
		DateTimePicker.getDefaultOption().set("icons", icons);
		
		RootPanel.get("sidebar").add(new Menu());
		
		new Button().getStyle();
	}
	
}
