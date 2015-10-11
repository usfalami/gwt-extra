package usf.gwt.ui.demo.sample;

import java.util.Date;

import usf.gwt.ui.bootstrap.client.Anchor;
import usf.gwt.ui.bootstrap.client.Button;
import usf.gwt.ui.bootstrap.client.Group;
import usf.gwt.ui.bootstrap.client.Panel;
import usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
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
		
//		Window.alert("uSf");
		
		p.add(pick = new DateTimePicker());

		pick.setDate(DateTimeFormat.getFormat("dd/mm/yyyy").parse("21/10/1987"));
		
		pick.setMinDate(DateTimeFormat.getFormat("dd/mm/yyyy").parse("21/10/2011"));
		pick.setMaxDate(DateTimeFormat.getFormat("dd/mm/yyyy").parse("21/10/2012"));
		
		
//		pick.setFormat("L");

		Window.alert(pick.getDate() + "");

		usf.gwt.ui.bootstrap.client.Button b = new Button("Change date");
		b.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				Window.alert(pick.getMinDate() + " " +pick.getMaxDate()) ;
			
				pick.setMinDate(null);
				pick.setMaxDate(null);
			}
		});
		
		p.add(b);
		
//		Window.alert(pick.getJsDate() + "");
		
	}
	
}
