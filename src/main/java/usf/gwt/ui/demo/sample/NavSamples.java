package usf.gwt.ui.demo.sample;

import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class NavSamples extends SampleComposite {

	private static final Binder binder = GWT.create(Binder.class);
	interface Binder extends UiBinder<Widget, NavSamples> {}

	public NavSamples() {
		initWidget(binder.createAndBindUi(this));
	}

}
