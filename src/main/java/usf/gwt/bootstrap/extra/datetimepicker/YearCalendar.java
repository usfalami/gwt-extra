package usf.gwt.bootstrap.extra.datetimepicker;

import usf.gwt.bootstrap.ui.core.BootstrapContainer;
import usf.gwt.bootstrap.ui.js.JqueryEvents;

import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class YearCalendar extends BootstrapContainer implements HasClickHandlers {
	
	protected static final int MONTHS = 12;
	protected static final int DEFAULT_FIRST_MONTHS = 0;
	public static final String DEFAULT_CALENDAR_YEAR_STYLE = "calendar-year";
	
	protected int diplayedFirstMonth = 0;
	protected int diplayedYear = 0;
	
	public YearCalendar() {
		super();
	}

	@Override
	protected Element initWidget() {
        Element div = Document.get().createDivElement();
        div.setClassName(DEFAULT_CALENDAR_YEAR_STYLE);
		return div;
	}
	
	public void setDisplayedYear(int year) {
		setDisplayedYear(year, DEFAULT_FIRST_MONTHS);
	}
	
	public void setDisplayedYear(int year, int first) {
		clear();
		this.diplayedYear = year;
		this.diplayedFirstMonth = first % (MONTHS + 1); int i;
		for(i=this.diplayedFirstMonth; i<MONTHS; i++) add(new MonthCalendar(i, year));
		for(i=0; i<this.diplayedFirstMonth; i++) add(new MonthCalendar(i, year+1));
	}
	
	public void appendStyleName(String styleName, int month, int... days){
		month = (MONTHS - diplayedFirstMonth + month) % MONTHS;
		MonthCalendar c = (MonthCalendar)getWidget(month);
		for(int i=0; i<days.length; i++) c.appendStyleName(styleName, days[i]);
	}
	
	public int getDiplayedFirstMonth() {
		return diplayedFirstMonth;
	}
	public int getDiplayedYear() {
		return diplayedYear;
	}
	
	public void clearStyle() {
		for(int i=0; i<getWidgetCount(); i++){
			MonthCalendar c = (MonthCalendar)getWidget(i);
			c.clearStyle();
		}
	}
	
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
    	JqueryEvents.addDomClickHandler(this, MonthCalendar.addDomClickHandler(getElement()));
    	return addHandler(handler, ClickEvent.getType());
    }
    
    public final native JsDate getSelectedDate() /*-{
    	var elem = $wnd.$(this.@usf.gwt.bootstrap.extra.datetimepicker.YearCalendar::getElement()()).find(".active");
    	if(!elem.length) return null;
    	var y = this.@usf.gwt.bootstrap.extra.datetimepicker.YearCalendar::diplayedYear;
    	var m = (elem.parents('.' + @usf.gwt.bootstrap.extra.datetimepicker.MonthCalendar::DEFAULT_CALENDAR_MONTH_STYLE).index() + 
    		this.@usf.gwt.bootstrap.extra.datetimepicker.YearCalendar::diplayedFirstMonth) % @usf.gwt.bootstrap.extra.datetimepicker.YearCalendar::MONTHS;
    	var d = elem.children(0).text();
    	return new Date(y, m, d);
    }-*/;

}
