package com.gwt.extra.client.demo.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usf.gwt.bootstrap.extra.datetimepicker.DateTimePicker;
import usf.gwt.bootstrap.extra.datetimepicker.DateTimePickerDayOfWeek;
import usf.gwt.bootstrap.extra.datetimepicker.DateTimePickerFormat;
import usf.gwt.bootstrap.ui.core.BrowserConsole;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JavaScriptOption;
import usf.gwt.bootstrap.ui.widget.Button;
import usf.gwt.bootstrap.ui.widget.CheckBox;
import usf.gwt.bootstrap.ui.widget.GridCol;
import usf.gwt.bootstrap.ui.widget.Layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class TestSamples_ extends Composite {

	interface TestUiBinder extends UiBinder<Widget, TestSamples_> {}
	private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);

	@UiField TextArea log;
	@UiField GridCol main;
	
	@UiField DateTimePicker pick;
	
	DateTimeFormat df = DateTimeFormat.getFormat("dd/MM/yyyy");
	
	public TestSamples_() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		Button reset = new Button("Reset");
		reset.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				pick.setOption(JavaScriptOption.createOption());
			}
		});
		main.add(reset);
		
		pick.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> arg0) {
		    	BrowserConsole.log("Event 1 : " + arg0.getValue());
			}
		});

//		
//		pick.setDisabledDates(df.parse("30/10/2015"), new Date());
//		
//		BrowserConsole.log(pick.getDisabledDates() + "");

		
//		pick.setDefaultDate(df.parse("21/01/2012"));
//		
//		pick.setMinDate(df.parse("01/01/2011"));
//		pick.setMaxDate(df.parse("30/12/2012"));
		
//		pick.setFormat("DD/MM/YYYY HH:mm:ss");
		
//		pick.SetStepping(30);
		
//		pick.setDaysOfWeekDisabled(DateTimePickerDayOfWeek.SUNDAY, DateTimePickerDayOfWeek.SATURDAY, DateTimePickerDayOfWeek.WEDNESDAY);
		
		Layout formatLayout = new Layout();
		main.add(formatLayout);

		Button b = new Button("default");
		b.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				pick.setFormat(null);
				log("selected format is reset to default");
			}
		});
		formatLayout.add(b);

		for(final DateTimePickerFormat l : DateTimePickerFormat.values()) {
			Button but = new Button(l.getLabel()) ;
			but.setStyle(Constants.ButtonStyles.PRIMARY);
			but.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					pick.setFormat(l);
					pick.show();
					log("selected format is : " + pick.getFormat());
				}
			});
			formatLayout.add(but);
		}
		

		Button clear = new Button("clear");
		clear.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				Window.alert(pick.getFormatAsString() + "") ;
			}
		});
		formatLayout.add(clear);
		
		Button test = new Button("test");
		test.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				Window.alert(pick.getDaysOfWeekDisabled().length + "") ;
				pick.show();
			}
		});
		main.add(test);
		
		
		//****************************** show/hide control buttons ******************************//
		
		Layout btnLayout = new Layout();
		main.add(btnLayout);
		
		final Button hideBtn = new Button("hide control buttons");
		final Button showBtn = new Button("show control buttons");
		
		ClickHandler c = new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				boolean v = arg0.getSource().equals(showBtn);
				pick.setShowClearButton(v);
				pick.setShowCloseButton(v);
				pick.setShowTodayButton(v);
				pick.show();
				log("control buttons are " + (pick.getShowClearButton() && pick.getShowCloseButton() && pick.getShowTodayButton() ? "shown" : "hidden"));
			}
		};
		
		hideBtn.addClickHandler(c);
		showBtn.addClickHandler(c);
		
		btnLayout.add(showBtn);
		btnLayout.add(hideBtn);

		//****************************** Day Of Week ******************************//
		
		Layout weekDay = new Layout();
		main.add(weekDay);
		
		final ListBox listday = new ListBox();
		listday.setMultipleSelect(true);
		for(DateTimePickerDayOfWeek d : DateTimePickerDayOfWeek.values())
			listday.addItem(d.name(), d.getValue() + "");
		weekDay.add(listday);
		
		listday.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				List<DateTimePickerDayOfWeek> days = new ArrayList<DateTimePickerDayOfWeek>();
				for(int i =0; i<listday.getItemCount(); i++){
					if(listday.isItemSelected(i)) {
						int val = Integer.parseInt(listday.getValue(i));
						days.add(DateTimePickerDayOfWeek.dayOf(val));
					}
				}
				pick.setDaysOfWeekDisabled(days.toArray(new DateTimePickerDayOfWeek[days.size()]));
				pick.show();
				log("disabled days are : " + pick.getDaysOfWeekDisabled());
			}
		});		
		

		//****************************** Local ******************************//


		Layout localDiv = new Layout();
		main.add(localDiv);
		
		final CheckBox local = new CheckBox();
		local.setText("Local");
		
		local.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				pick.setLocale(local.getChecked() ? "fr" : "en");
				pick.show();
			}
		});

		localDiv.add(local);
		


		//****************************** Side by side ******************************//
		

		Layout sideByDiv = new Layout();
		main.add(sideByDiv);
		
		final CheckBox side = new CheckBox();
		side.setText("Side by Side");
		
		side.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				pick.setSideBySide(side.getChecked());
				pick.show();
			}
		});

		sideByDiv.add(side);
		
		


		//****************************** Weeks ******************************//
		

		Layout weekLayout = new Layout();
		main.add(weekLayout);
		
		final CheckBox week = new CheckBox();
		week.setText("Week number");
		
		week.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				pick.setShowWeeksNumber(week.getChecked());
				pick.show();
			}
		});
		weekLayout.add(week);
	}
	
	
	
	

	public void log(String text) {
		log.setText(log.getText() + "\n" + text);
	}
	
	
}
