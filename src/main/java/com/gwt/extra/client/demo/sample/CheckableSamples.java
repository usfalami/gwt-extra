package com.gwt.extra.client.demo.sample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.extra.client.demo.SampleComposite;

public class CheckableSamples extends SampleComposite {

	private static CheckableSamplesUiBinder uiBinder = GWT.create(CheckableSamplesUiBinder.class);
	interface CheckableSamplesUiBinder extends UiBinder<Widget, CheckableSamples> {}

	public CheckableSamples() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
