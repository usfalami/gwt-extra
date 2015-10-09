package usf.gwt.ui.demo.sample;

import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class CheckableSamples extends SampleComposite {

	private static CheckableSamplesUiBinder uiBinder = GWT.create(CheckableSamplesUiBinder.class);
	interface CheckableSamplesUiBinder extends UiBinder<Widget, CheckableSamples> {}

	public CheckableSamples() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
