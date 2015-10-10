package usf.gwt.ui.demo.sample;

import usf.gwt.ui.bootstrap.client.Anchor;
import usf.gwt.ui.bootstrap.client.Group;
import usf.gwt.ui.bootstrap.client.Panel;
import usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestSampes extends Composite {

	interface TestUiBinder extends UiBinder<Widget, TestSampes> {}
	private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);

	@UiField Anchor anchor;
	@UiField Group group;
		
	public TestSampes() {
		Panel p = new Panel();
		initWidget(p);
		
//		Window.alert("uSf");
		
		DateTimePicker pick = new DateTimePicker();
		pick.show();
		p.add(pick);
		
	}
	
}
