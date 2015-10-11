package usf.gwt.ui.bootstrap.datetimepicker2;

import java.util.Date;

import usf.gwt.ui.bootstrap.client.TextBox;
import usf.gwt.ui.bootstrap.datetimepicker.client.JavaScriptOption;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * 
 * @author YAH
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

	/**
	 * @see http://momentjs.com/docs/#/displaying/format/
	 * @param format
	 */
	public final native JavaScriptObject setFormat(String format) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.format(format);
	}-*/;
	public final native String getFormat() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.format();
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
	

	public final native void setOption(JavaScriptOption option) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.option(option);
	}-*/;
	public final native JavaScriptObject getOption() /*-{
		return this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.option();
	}-*/;
	
	//action functions
	/**
	 * Destroys the widget and removes all attached event listeners
	 */
	public final native void destroy() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.estroy();
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
	public final native void toggole() /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker.toggole();
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
