package usf.gwt.ui.demo.sample;

import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class FormSamples extends SampleComposite {

	private static FormSamplesUiBinder uiBinder = GWT.create(FormSamplesUiBinder.class);
	interface FormSamplesUiBinder extends UiBinder<Widget, FormSamples> {}
	
	public FormSamples() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
