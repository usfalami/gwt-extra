package usf.gwt.ui.demo.sample;

import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class InputSamples extends SampleComposite {

	private static InputSamplesUiBinder uiBinder = GWT.create(InputSamplesUiBinder.class);
	interface InputSamplesUiBinder extends UiBinder<Widget, InputSamples> {}

	public InputSamples() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
