package usf.gwt.bootstrap.extra.datetimepicker;

import usf.gwt.bootstrap.ui.widget.TextBox;

import com.google.gwt.junit.client.GWTTestCase;

public class DateTimePickerTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "usf.gwt.bootstrap.extra.DateTimePicker";
	}
	
	public void testInitWidget() {
		DateTimePicker p = new DateTimePicker();
		assertTrue(p instanceof TextBox);
		assertFalse(p.getAutocomplete());
//		assertEquals(p.getDate(), null);
	}
	
}
