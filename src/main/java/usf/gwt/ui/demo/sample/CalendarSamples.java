package usf.gwt.ui.demo.sample;

import usf.gwt.ui.bootstrap.datetimepicker2.YearCalendar;
import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class CalendarSamples extends SampleComposite {

	@UiField YearCalendar c_2015;
	
	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CalendarSamples> {
	}

	public CalendarSamples() {
		initWidget(binder.createAndBindUi(this));
		c_2015.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				JsDate d = c_2015.getSelectedDate();
				Window.alert("ClickHandler Exemple : Date = " + (d == null ? "Empty" : d.toLocaleDateString()));
			}
		});
	}

}
