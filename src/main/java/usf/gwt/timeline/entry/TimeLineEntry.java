package usf.gwt.timeline.entry;

import java.util.Date;

import usf.gwt.timeline.JavaScriptOption;

public class TimeLineEntry extends JavaScriptOption implements TimeLineItem {

    protected TimeLineEntry() {
    	
    }
	
	@Override
	public final String getGroupName() {
		return getString("group");
	}
	@Override
	public final void setGroupName(String group) {
		set("group", group);
	}
	@Override
	public final Date getStartDate() {
		return getDate("start");
	}
	@Override
	public final void setStartDate(Date start) {
		set("start", start);
	}
	@Override
	public final Date getEndDate() {
		return getDate("end");
	}
	@Override
	public final void setEndDate(Date end) {
		set("end", end);
	}
	@Override
	public final String getContent() {
		return getString("content");
	}
	@Override
	public final void setContent(String content) {
		set("content", content);
	}
	@Override
	public final String getClassName() {
		return getString("className");
	}
	@Override
	public final void setClassName(String className) {
		set("className", className);
	}
	@Override
	public String getPopupContent() {
		return getString("popupContent");
	}
	@Override
	public void setPopupContent(String popupContent) {
		set("popupContent", popupContent);
	}
	@Override
	public void setClickable(Boolean clickable){
		set("clickable", clickable);
	}
	@Override
	public Boolean isClickable() {
		return getBoolean("clickable");
	}
	
	public static final native TimeLineEntry create() /*-{
		return {};
	}-*/;
	public static final TimeLineEntry create(String group, String content, String className, Date start, Date end){
		return create(group, content, className, start, end, null);
	}
	public static final TimeLineEntry create(String group, String content, String className, Date start, Date end, String popupContent){
		TimeLineEntry t = create();
		t.setGroupName(group);
		t.setStartDate(start);
		t.setEndDate(end);
		t.setContent(content);
		t.setClassName(className);
		t.setPopupContent(popupContent);
		return t;
	}

}
