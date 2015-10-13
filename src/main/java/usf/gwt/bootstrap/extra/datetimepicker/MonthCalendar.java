package usf.gwt.bootstrap.extra.datetimepicker;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.js.JavaScriptArray;
import usf.gwt.bootstrap.ui.js.JqueryEvents;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class MonthCalendar extends BootstrapWidget implements HasClickHandlers {

    protected static final int WEEK_DAYS = 7;
    protected static final byte DEFAULT_FIRST_DAY_OF_WEEK = 1;
    protected static final String DEAFULT_LANGUAGE = "fr";

    public static final String DEFAULT_CALENDAR_DAY_STYLE = "calendar-day";
	public static final String DEFAULT_CALENDAR_MONTH_STYLE = "calendar-month";
    public static final String DEFAULT_CALENDAR_CELL_STYLE = "calendar-cell";
    public static final String DEFAULT_CALENDAR_HEADER_STYLE = "calendar-header";

    protected int dayStartWeek;
    protected int daysCount;

    public MonthCalendar() {
        super();
    }

    public MonthCalendar(int month, int year) {
        this();
        setDiplayedMonth(month, year);
    }

    @Override
    protected Element initWidget() {
        Element div = Document.get().createDivElement();
        TableElement table = Document.get().createTableElement();
        Element theader = Document.get().createTHeadElement();
        table.appendChild(theader);
        Element tbody = Document.get().createTBodyElement();
        table.appendChild(tbody);
        Element tr = Document.get().createTRElement();
        theader.appendChild(tr);
        TableCellElement th = Document.get().createTHElement();
        th.setColSpan(WEEK_DAYS);
        tr.appendChild(th);
        tr = Document.get().createTRElement();
        JavaScriptArray array = getShortDays();
        for (int i = DEFAULT_FIRST_DAY_OF_WEEK; i < WEEK_DAYS; i++)
            tr.appendChild(createTHElement(array.getString(i)));
        for (int i = 0; i < DEFAULT_FIRST_DAY_OF_WEEK; i++)
            tr.appendChild(createTHElement(array.getString(i)));
        theader.appendChild(tr);
        div.appendChild(table);
        return div;
    }
    @Override
    protected void initStyle() {
    	getElement().addClassName(DEFAULT_CALENDAR_MONTH_STYLE + " " + "datetimepicker");
        getTable().setClassName("table table-condensed");
    }

    public void setDiplayedMonth(int month, int year) {
        Element tbody = getTableBody();
        tbody.removeAllChildren();
        setMonthLablel(getMonths().getString(month) + " " + year);
        Element tr = Document.get().createTRElement();
        dayStartWeek = (WEEK_DAYS - DEFAULT_FIRST_DAY_OF_WEEK + getStartDay(month, year)) % WEEK_DAYS;
        daysCount = getLastDay(month, year);
        int day = 1, i = 0, weeks = (dayStartWeek + daysCount) / WEEK_DAYS;
        for (; i < dayStartWeek; i++)
            tr.appendChild(createTREmptyElement());
        for (; i < WEEK_DAYS; i++, day++)
            tr.appendChild(createTRElement(day + ""));
        tbody.appendChild(tr);
        for (i = 1; i < weeks; i++) {
            tr = Document.get().createTRElement();
            for (int j = 0; j < WEEK_DAYS; j++, day++)
                tr.appendChild(createTRElement(day + ""));
            tbody.appendChild(tr);
        }
        if (day <= daysCount) {
            tr = Document.get().createTRElement();
            for (i = 0; day <= daysCount; day++, i++)
                tr.appendChild(createTRElement(day + ""));
            for (; i < WEEK_DAYS; i++)
                tr.appendChild(createTREmptyElement());
            tbody.appendChild(tr);
        }
    }
    
    protected Element getDay(String styleName, int day) {
        day = day % (daysCount + 1) - 1;
        int row = (dayStartWeek + day) / 7;
        int col = (dayStartWeek + day) % 7;
        return getTableBody().getChild(row).getChild(col).getFirstChild().cast();
    }

    public void appendStyleName(String styleName, int day) {
    	getDay(styleName, day).addClassName(styleName);
    }
    public void setStyleName(String styleName, int day) {
    	getDay(styleName, day).setClassName(styleName);
    }

    protected static Element createTHElement(String label) {
        Element th = Document.get().createTHElement();
        th.setInnerText(label);
        th.setClassName(DEFAULT_CALENDAR_HEADER_STYLE);
        return th;
    }
    protected static Element createTRElement(String day) {
        Element td = createTREmptyElement();
        td.setClassName(DEFAULT_CALENDAR_CELL_STYLE + " day");
        Element div = Document.get().createDivElement();
        div.setClassName(DEFAULT_CALENDAR_DAY_STYLE);
        div.setInnerText(day);
        td.appendChild(div);
        return td;
    }
    protected static Element createTREmptyElement() {
        return Document.get().createTDElement();
    }

    protected TableElement getTable() {
        return getElement().getFirstChild().cast();
    }
    protected TableCellElement getTableHead() {
        return getTable().getFirstChild().getFirstChild().cast();
    }
    protected TableSectionElement getTableBody() {
        return getTable().getChild(1).cast();
    }
    protected void setMonthLablel(String value) {
        Element e = getTableHead().getFirstChild().cast();
        e.setInnerText(value.toUpperCase());
    }

    public static native int getStartDay(final int month, final int year) /*-{
		return new Date(year, month, 1).getDay();
	}-*/;
    public static native int getLastDay(final int month, final int year) /*-{
		return new Date(year, month+1, 0).getDate();
	}-*/;

    public static final native JavaScriptArray getShortDays() /*-{
    	return $wnd.moment.weekdaysMin();
	}-*/;
    public static final native JavaScriptArray getMonths() /*-{
		return $wnd.moment.months();
	}-*/;
    
    public void clearStyle(){
    	for(int i=0; i<daysCount; i++)
    		setStyleName(DEFAULT_CALENDAR_DAY_STYLE, i+1);
    }
    
    @Override
    public HandlerRegistration addClickHandler(ClickHandler handler) {
    	JqueryEvents.addDomClickHandler(this, addDomClickHandler(getElement()));
    	return addHandler(handler, ClickEvent.getType());
    }
    
    public static final native JavaScriptObject addDomClickHandler(final Element w)/*-{
		return function(e) {
			$wnd.$(w).find(@com.google.gwt.dom.client.TableCellElement::TAG_TD).removeClass(@usf.gwt.bootstrap.ui.core.Constants::BOOTSTRAP_ACTIVE);
			var t = $wnd.$(e.target);
			var p = t.hasClass(@usf.gwt.bootstrap.extra.datetimepicker.MonthCalendar::DEFAULT_CALENDAR_DAY_STYLE) ? 
				t.parent() : t.hasClass(@usf.gwt.bootstrap.extra.datetimepicker.MonthCalendar::DEFAULT_CALENDAR_CELL_STYLE) ? t : null;
			if(p) p.addClass(@usf.gwt.bootstrap.ui.core.Constants::BOOTSTRAP_ACTIVE);
		};
	}-*/;
    
}
