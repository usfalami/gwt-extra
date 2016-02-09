package com.gwt.extra.client.demo.sample;

import java.util.HashMap;
import java.util.Map;

import usf.gwt.bootstrap.ui.widget.Button;
import usf.gwt.bootstrap.ui.widget.Typeahead;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestSamples extends Composite {

	interface TestUiBinder extends UiBinder<Widget, TestSamples> {}
	private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);
	
	@UiField Typeahead type;
	@UiField Button btn1;
	@UiField Button btn2;
	@UiField Button btn3;
	
	private static Map<String, String> map = new HashMap<String, String>();
	private static Map<String, String> map2 = new HashMap<String, String>();
	
	
	static {
		for(int i=0; i<200; i++)
			map.put(i+"", "orig"+i);
		for(int i=0; i<500; i++)
			map2.put(i+"", "val"+i);
	}
	
	public TestSamples() {
		initWidget(uiBinder.createAndBindUi(this));
		//type.setData(map);
	}
	
	@UiHandler("btn1")
	protected void btnClick1(ClickEvent e){
		type.setData(map2);
	}
	@UiHandler("btn2")
	protected void btnClick2(ClickEvent e){
		Window.alert(type.getSelectedItem() + "");
	}
	@UiHandler("btn3")
	protected void btnClick3(ClickEvent e){
		type.setAjax("/data/load");
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
	}	
}
