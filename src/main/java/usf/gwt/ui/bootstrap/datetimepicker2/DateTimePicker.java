package usf.gwt.ui.bootstrap.datetimepicker2;

import java.util.Date;

import usf.gwt.ui.bootstrap.client.TextBox;
import usf.gwt.ui.bootstrap.client.core.JavaScriptArray;
import usf.gwt.ui.bootstrap.client.core.JavaScriptOption;

import com.google.gwt.core.client.JavaScriptObject;
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
	
	public void setDaysOfWeekDisabled(DateTimePickerDayOfWeek... days) {
		JavaScriptArray array = JavaScriptArray.createArray();
		if(days != null)
			for(DateTimePickerDayOfWeek d : days)
				array.append(d.getValue());
		setDaysOfWeekDisabledArray(array);
	}
	public DateTimePickerDayOfWeek[] getDaysOfWeekDisabled() {
		JavaScriptArray a = getDaysOfWeekDisabledArray();
		DateTimePickerDayOfWeek[] days = new DateTimePickerDayOfWeek[a.length()];
		for(int i=0; i<a.length(); i++)
			days[i] = DateTimePickerDayOfWeek.dayOf(a.getInteger(i));
		setDaysOfWeekDisabledArray(a); //resolve get problem 
		return days;
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
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.date(date ? new $wnd.Date(c(date)) : null);
	}-*/;
	public final native Date getDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.date();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(D)(d) : null;
	}-*/;

	public final native void setDefaultDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.defaultDate(date ? new $wnd.Date(c(date)) : null);
	}-*/;
	public final native Date getDefaultDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.defaultDate();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(D)(d) : null;
	}-*/;
	
	public final native void setMinDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.minDate(date ? new $wnd.Date(c(date)) : false);
	}-*/;
	public final native Date getMinDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.minDate();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(D)(d) : null;
	}-*/;
	public final native void setMaxDate(Date date) /*-{
		var c = @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(Ljava/util/Date;);
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.maxDate(date ? new $wnd.Date(c(date)) : false);
	}-*/;
	public final native Date getMaxDate() /*-{
		var d = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.maxDate();
		return d ? @usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::convertDate(D)(d) : null;
	}-*/;
	
	/**
	 * Number of minutes the up/down arrow's will move the minutes value in the time picker
	 * 
	 * @param step
	 */
	public final native void SetStepping(double step) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.stepping(step);
	}-*/;
	/**
	 * Number of minutes the up/down arrow's will move the minutes value in the time picker
	 * 
	 * @return step
	 */
	public final native double getMinuteStep() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.stepping();
	}-*/;
	
	/**
	 * Disables the section of days of the week, e.g. weekends.
	 * 
	 * @param array
	 */
	protected final native void setDaysOfWeekDisabledArray(JavaScriptArray array) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.daysOfWeekDisabled(array ? array : new $wnd.Array());
	}-*/;
	/**
	 * 
	 * 
	 * @return Disables the section of days of the week, e.g. weekends.
	 */
	protected final native JavaScriptArray getDaysOfWeekDisabledArray() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.daysOfWeekDisabled();
	}-*/;
	
	
	
	public final native void setShowClear(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClear(visible);
	}-*/;
	public final native boolean getShowClear() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClear();
	}-*/;
	
	public final native void setShowClose(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClose(visible);
	}-*/;
	public final native boolean getShowClose() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showClose();
	}-*/;

	public final native void setShowTodayButton(boolean visible) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showTodayButton(visible);
	}-*/;
	public final native boolean getShowTodayButton() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.showTodayButton();
	}-*/;

	
	

	public final native void setOption(JavaScriptOption option) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.options(option);
	}-*/;
	public final native JavaScriptObject getOption() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.options();
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
	
	protected static double convertDate(Date date) {
		return date.getTime();
	}
	protected static Date convertDate(double date) {
		return new Date ((long)date);
	}
	
	/**
	 * creates datetimepicker javascript object
	 * 
	 */
	protected final static native JavaScriptObject render(Element e, JavaScriptObject o) /*-{
		return $wnd.deb = $wnd.$(e).datetimepicker(o).data("DateTimePicker");
	}-*/;

	public final static JavaScriptOption defaultDateTimePickerOptions(){
		return JavaScriptOption.createOption()
		.set("locale", "fr");
//		.set("format", "L");
	}

}
