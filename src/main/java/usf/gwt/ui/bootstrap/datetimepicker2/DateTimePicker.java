package usf.gwt.ui.bootstrap.datetimepicker2;

import java.util.Date;

import usf.gwt.ui.bootstrap.client.TextBox;
import usf.gwt.ui.bootstrap.client.core.JavaScriptArray;
import usf.gwt.ui.bootstrap.client.core.JavaScriptOption;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Element;

/**
 * 
 * @author Youssef ALAMI
 * 
 * @see https://eonasdan.github.io/bootstrap-datetimepicker/
 *
 */

public class DateTimePicker extends TextBox {
	
    protected static final String DATE_TIME_PICKER = "DateTimePicker";

	protected JavaScriptObject picker;

	public DateTimePicker() {
		this(defaultDateTimePickerOptions());
	}
	public DateTimePicker(JavaScriptOption option) {
		picker = render(getBaseElement(), option);
	}
	
	public void setFormat(DateTimePickerFormat format) {
		setFormatAsString(format == null ? null : format.getPattern());
		setPlaceholder(format == null ? "" : format.getLabel());
	}
	public DateTimePickerFormat getFormat() {
		String f = getFormatAsString();
		return f == null ? null : DateTimePickerFormat.patternOf(f);
	}
	
	/**
	 * @see http://momentjs.com/docs/#/displaying/format/
	 * @param format
	 */
	public final native JavaScriptObject setFormatAsString(String format) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.format(format ? format : false);
	}-*/;
	public final native String getFormatAsString() /*-{
		var f = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.format();
		return f ? f : null; //f can be false if no format has been set
	}-*/;

	public final native void setDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDoube(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.date(date ? new $wnd.Date(c(date)) : null);
	}-*/;
	public final native Date getDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.date();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDate(D)(d) : null;
	}-*/;

	public final native void setDefaultDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDoube(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.defaultDate(date ? new $wnd.Date(c(date)) : false);
	}-*/;
	public final native Date getDefaultDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.defaultDate();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDate(D)(d) : null;  // d can be false
	}-*/;
	
	public final native void setMinDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDoube(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.minDate(date ? new $wnd.Date(c(date)) : false);
	}-*/;
	public final native Date getMinDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.minDate();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDate(D)(d) : null; // d can be false
	}-*/;
	public final native void setMaxDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDoube(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.maxDate(date ? new $wnd.Date(c(date)) : false);
	}-*/;
	public final native Date getMaxDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.maxDate();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toDate(D)(d) : null; // d can be false
	}-*/;
	
	/**
	 * 
	 * @param step : Number of minutes the up/down arrow's will move the minutes value in the time picker
	 */
	public final native void setStepping(double step) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.stepping(step);
	}-*/;
	/**
	 * 
	 * @return Number of minutes the up/down arrow's will move the minutes value in the time picker
	 */
	public final native double getStepping() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.stepping();
	}-*/;
	
	/**
	 * 
	 * @param Disables the section of days of the week, e.g. weekends.
	 */
	public final native void setDaysOfWeekDisabled(DateTimePickerDayOfWeek... days) /*-{
		var array = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toJsArray([Lusf/gwt/ui/bootstrap/datetimepicker2/DateTimePickerDayOfWeek;)(days);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.daysOfWeekDisabled(array ? array : false);
	}-*/;
	/**
	 * 
	 * @return Disables the section of days of the week, e.g. weekends.
	 */
	public final native DateTimePickerDayOfWeek[] getDaysOfWeekDisabled() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.daysOfWeekDisabled();
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.daysOfWeekDisabled(d); // resolve some bugs 
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toWeekDays(Lusf/gwt/ui/bootstrap/client/core/JavaScriptArray;)(d) : null;
	}-*/;
	
	
	public final native void setEnabledDates(Date... dates) /*-{
		var array = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::toJsArray([Ljava/util/Date;)(dates)
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.enabledDates(array ? array : false);
	}-*/;
	public final native JavaScriptArray getEnabledDates() /*-{
		return $wnd.enab = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.enabledDates();
	}-*/;
	
	
	
	public final native void setShowClearButton(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClear(visible);
	}-*/;
	public final native boolean getShowClearButton() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClear();
	}-*/;
	
	public final native void setShowCloseButton(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClose(visible);
	}-*/;
	public final native boolean getShowCloseButton() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClose();
	}-*/;

	public final native void setShowTodayButton(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showTodayButton(visible);
	}-*/;
	public final native boolean getShowTodayButton() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showTodayButton();
	}-*/;
	public final native void setKeepOpen(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.keepOpen(visible);
	}-*/;
	public final native boolean getKeepOpen() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.keepOpen();
	}-*/;
	public final native void setSideBySide(boolean sideBySide) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.sideBySide(sideBySide);
	}-*/;
	public final native boolean getSideBySide() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.sideBySide();
	}-*/;

	

	public final native void setOption(JavaScriptOption option) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.options(option);
	}-*/;
	public final native JavaScriptObject getOption() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.options();
	}-*/;
	
	public final native void setLocale(String locale) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.locale(locale);
	}-*/;
	public final native String getLocale() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.locale();
	}-*/;
	
	//action functions
	
	/**
	 * Clears the datepicker by setting the value to null
	 */
	public final native void clear() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.clear();
	}-*/;
	
	
	/**
	 * Destroys the widget and removes all attached event listeners
	 */
	public final native void destroy() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.destroy();
	}-*/;
	/**
	 * Shows or hides the widget
	 */
	public final native void show() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.show();
	}-*/;
	/**
	 * Hides the widget
	 */
	public final native void hide() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.hide();
	}-*/;
	/**
	 * Shows or hides the widget
	 */
	public final native void toggle() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.toggle();
	}-*/;
	
	/**
	 * 
	 * @return new DateTimePicker javascript instance
	 */
	protected final static native JavaScriptObject render(Element e, JavaScriptOption o) /*-{
		return $wnd.deb = $wnd.$(e).datetimepicker(o).data("DateTimePicker");
	}-*/;

	public final static JavaScriptOption defaultDateTimePickerOptions(){
		return JavaScriptOption.createOption()
		.set("locale", "fr");
//		.set("format", "L");
	}
	
	
	
	protected static double toDoube(Date date) {
		return date.getTime();
	}
	protected static native JsDate toJsDate(double date) /*-{
		return new $wnd.Date(date);
	}-*/;
	protected static Date toDate(double date) {
		return new Date((long)date);
	}
	protected static Date toDate(JsDate date) {
		return new Date((long)date.getTime());
	}
	
	protected static JavaScriptArray toJsArray(DateTimePickerDayOfWeek... days) {
		JavaScriptArray array = JavaScriptArray.createArray();
		if(days != null)
			for(DateTimePickerDayOfWeek d : days)
				array.append(d.getValue());
		return array;
	}
	protected static DateTimePickerDayOfWeek[] toWeekDays(JavaScriptArray array) {
		if(array == null) return null;
		DateTimePickerDayOfWeek[] days = new DateTimePickerDayOfWeek[array.length()];
		for(int i=0; i<array.length(); i++)
			days[i] = DateTimePickerDayOfWeek.dayOf(array.getInteger(i));
		return days;
	}
	
	protected static JavaScriptArray toJsArray(Date... dates) {
		JavaScriptArray array = JavaScriptArray.createArray();
		if(dates != null)
			for(Date d : dates)
				array.append(toJsDate(d.getTime()));
		return array;
	}
	protected static Date[] toDates(JavaScriptArray array) {
		if(array == null) return null;
		Date[] days = new Date[array.length()];
		for(int i=0; i<array.length(); i++)
			days[i] = toDate(array.getJsDate(i));
		return days;
	}


}
