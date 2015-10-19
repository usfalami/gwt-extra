package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.widget.TextBox;

import com.google.gwt.dom.client.InputElement;
import com.google.gwt.junit.client.GWTTestCase;

public class TextBoxTest extends GWTTestCase {
	
	TextBox t = new TextBox();
	
	public TextBoxTest() {
	}

	@Override
	public String getModuleName() {
		return "usf.gwt.bootstrap.Bootstrap";
	}

	public void testInitWidget() {
		assertEquals(t.getBaseElement().getTagName(), InputElement.TAG.toUpperCase());
		assertEquals(t.getStyleName(), TextBox.DEFAULT_FORM_CONTROL_STYLE);
	}
}
