package com.gwt.extra.client.demo.sample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.extra.client.demo.SampleComposite;

public class PanelSamples extends SampleComposite {

	private static PabelSamplesUiBinder uiBinder = GWT
			.create(PabelSamplesUiBinder.class);

	interface PabelSamplesUiBinder extends UiBinder<Widget, PanelSamples> {
	}

	public PanelSamples() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
