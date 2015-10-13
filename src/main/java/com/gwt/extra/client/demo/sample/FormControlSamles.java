package com.gwt.extra.client.demo.sample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.extra.client.demo.SampleComposite;

public class FormControlSamles extends SampleComposite {

	private static FormControlSamlesUiBinder uiBinder = GWT.create(FormControlSamlesUiBinder.class);

	interface FormControlSamlesUiBinder extends UiBinder<Widget, FormControlSamles> {}

	public FormControlSamles() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
