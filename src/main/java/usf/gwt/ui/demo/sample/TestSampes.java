package usf.gwt.ui.demo.sample;

import usf.gwt.ui.bootstrap.client.Anchor;
import usf.gwt.ui.bootstrap.client.Bootstrap.ButtonStyles;
import usf.gwt.ui.bootstrap.client.Button;
import usf.gwt.ui.bootstrap.client.Group;
import usf.gwt.ui.bootstrap.client.Layout;
import usf.gwt.ui.bootstrap.client.Panel;
import usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker;
import usf.gwt.ui.bootstrap.datetimepicker2.DateTimePickerDayOfWeek;
import usf.gwt.ui.bootstrap.datetimepicker2.DateTimePickerFormat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestSampes extends Composite {

	interface TestUiBinder extends UiBinder<Widget, TestSampes> {}
	private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);

	@UiField Anchor anchor;
	@UiField Group group;
	
	DateTimePicker pick;
		
	public TestSampes() {
		Panel p = new Panel();
		initWidget(p);
		
		p.add(pick = new DateTimePicker());

//		pick.setDate();
		
//		pick.setDefaultDate(DateTimeFormat.getFormat("dd/MM/yyyy").parse("21/01/2012"));
//		
//		pick.setMinDate(DateTimeFormat.getFormat("dd/MM/yyyy").parse("01/01/2011"));
//		pick.setMaxDate(DateTimeFormat.getFormat("dd/MM/yyyy").parse("30/12/2012"));
		
//		pick.setFormat("DD/MM/YYYY HH:mm:ss");
		
//		pick.SetStepping(30);
		
		pick.setDaysOfWeekDisabled(DateTimePickerDayOfWeek.SUNDAY, DateTimePickerDayOfWeek.SATURDAY, DateTimePickerDayOfWeek.WEDNESDAY);
		
		
		
		Layout formatLayout = new Layout();
		p.add(formatLayout);

		Button b = new Button("default");
		b.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				pick.setFormat(null);
			}
		});
		formatLayout.add(b);

		for(final DateTimePickerFormat l : DateTimePickerFormat.values()) {
			Button but = new Button(l.getLabel()) ;
			but.setStyle(ButtonStyles.PRIMARY);
			but.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					pick.setFormat(l);
//					Window.alert(pick.getFormat().toString());
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
				pick.setDaysOfWeekDisabled();
			}
		});
		p.add(test);
		
	}
	
}
