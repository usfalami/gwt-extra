package usf.gwt.ui.demo.sample;

import usf.gwt.ui.demo.SampleComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class GroupSamples extends SampleComposite {

	private static GroupSamplesUiBinder uiBinder = GWT.create(GroupSamplesUiBinder.class);

	interface GroupSamplesUiBinder extends UiBinder<Widget, GroupSamples> {
	}

	public GroupSamples() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
