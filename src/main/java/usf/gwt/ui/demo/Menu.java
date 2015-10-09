package usf.gwt.ui.demo;

import usf.gwt.ui.bootstrap.client.NavItem;
import usf.gwt.ui.demo.sample.CalendarSamples;
import usf.gwt.ui.demo.sample.CheckableSamples;
import usf.gwt.ui.demo.sample.FormControlSamles;
import usf.gwt.ui.demo.sample.FormSamples;
import usf.gwt.ui.demo.sample.GroupSamples;
import usf.gwt.ui.demo.sample.InputSamples;
import usf.gwt.ui.demo.sample.NavSamples;
import usf.gwt.ui.demo.sample.PanelSamples;
import usf.gwt.ui.demo.sample.ProgressSampes;
import usf.gwt.ui.demo.sample.TestSampes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Menu extends Composite implements ClickHandler {
	
	private static MenuUiBinder uiBinder = GWT.create(MenuUiBinder.class);
	interface MenuUiBinder extends UiBinder<Widget, Menu> {}

	@UiField NavItem test;
	@UiField NavItem panels;
	@UiField NavItem navs;
	@UiField NavItem groups;
	@UiField NavItem forms;
	@UiField NavItem progress;
	@UiField NavItem controls;
	@UiField NavItem inputs;
	@UiField NavItem checkables;
	@UiField NavItem calendars;
	
	public Menu() {
		initWidget(uiBinder.createAndBindUi(this));
		test.addClickHandler(this);
		panels.addClickHandler(this);
		navs.addClickHandler(this);
		groups.addClickHandler(this);
		forms.addClickHandler(this);
		progress.addClickHandler(this);
		controls.addClickHandler(this);
		inputs.addClickHandler(this);
		checkables.addClickHandler(this);
		calendars.addClickHandler(this);
	}
	
	@Override
	protected void onLoad() {
		RootPanel.get("gwt").add(new TestSampes());
	}

	@Override
	public void onClick(ClickEvent event) {
		NavItem c = (NavItem) event.getSource();
		if(c.isActive()) return;
		RootPanel.get("gwt").clear();
		if(c == test) RootPanel.get("gwt").add(new TestSampes());
		else if(c == navs) RootPanel.get("gwt").add(new NavSamples());
		else if(c == groups) RootPanel.get("gwt").add(new GroupSamples());
		else if(c == panels) RootPanel.get("gwt").add(new PanelSamples());
		else if(c == forms) RootPanel.get("gwt").add(new FormSamples());
		else if(c == progress) RootPanel.get("gwt").add(new ProgressSampes());
		else if(c == controls) RootPanel.get("gwt").add(new FormControlSamles());
		else if(c == inputs) RootPanel.get("gwt").add(new InputSamples());
		else if(c == checkables) RootPanel.get("gwt").add(new CheckableSamples());
		else if(c == calendars) RootPanel.get("gwt").add(new CalendarSamples());
		c.setActiveUnique();
	}

}
