package usf.gwt.ui.demo.sample;

import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ProgressSampes extends SampleComposite {

	private static ProgressSampesUiBinder uiBinder = GWT
			.create(ProgressSampesUiBinder.class);

	interface ProgressSampesUiBinder extends UiBinder<Widget, ProgressSampes> {
	}

	public ProgressSampes() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
