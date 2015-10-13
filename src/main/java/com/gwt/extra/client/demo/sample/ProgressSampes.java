package com.gwt.extra.client.demo.sample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.extra.client.demo.SampleComposite;

public class ProgressSampes extends SampleComposite {

	private static ProgressSampesUiBinder uiBinder = GWT
			.create(ProgressSampesUiBinder.class);

	interface ProgressSampesUiBinder extends UiBinder<Widget, ProgressSampes> {
	}

	public ProgressSampes() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
