package usf.gwt.ui.timeline.client.entry;

import java.util.Date;

public interface TimeLineItem {
	
	String getGroupName();
	void setGroupName(String group);
	Date getStartDate();
	void setStartDate(Date start);
	Date getEndDate();
	void setEndDate(Date end);
	String getContent();
	void setContent(String content);
	String getClassName();
	void setClassName(String className);
	String getPopupContent();
	void setPopupContent(String popupContent);
	void setClickable(Boolean clickable);
	Boolean isClickable();
	
}
