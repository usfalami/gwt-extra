package usf.gwt.ui.bootstrap.datetimepicker2;

import usf.gwt.ui.bootstrap.client.TextBox;
import usf.gwt.ui.bootstrap.datetimepicker.client.JavaScriptOption;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class DateTimePicker extends TextBox {
	
    protected static final String DATE_TIME_PICKER = "DateTimePicker";

	protected JavaScriptObject picker;
	protected JavaScriptOption option;

	public DateTimePicker() {
		this.option = defaultDateTimePickerOptions();
	}
	public DateTimePicker(JavaScriptOption option) {
		this.option = option;
	}

	@Override
	protected void onLoad() {
		if(picker == null)
			render();
	}
	/**
	 * @see http://momentjs.com/docs/#/displaying/format/
	 * @param format
	 */
	public final native JavaScriptObject setFormat(String format) /*-{
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::option["format"] = format;
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		picker && picker.format(format);
	}-*/;
	public final native void getFormat() /*-{
		return picker == null ? null : picker.format();
	}-*/;


	public final native void setJsDate(JsDate date) /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		return picker == null ? null : picker.date(date);
	}-*/;
	public final native JsDate getJsDate() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		return picker == null ? null : picker.date();
	}-*/;

	public final native void setDefaultJsDate(JsDate date) /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::option["defaultDate"] = date;
		return picker && picker.defaultDate(date);
	}-*/;
	public final native JsDate getDefaultJsDate() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		return picker == null ? null : picker.defaultDate();
	}-*/;
	
	public final native void setMinJsDate(JsDate date) /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::option["minDate"] = date;
		return picker == null ? null : picker.minDate(date);
	}-*/;
	public final native JsDate getMinJsDate() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		return picker == null ? null : picker.minDate();
	}-*/;
	public final native void setMaxJsDate(JsDate date) /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::option["maxDate"] = date;
		return picker == null ? null : picker.maxDate(date);
	}-*/;
	public final native JsDate getMaxJsDate() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		return picker == null ? null : picker.maxDate();
	}-*/;
	

	public final native void setOption(JavaScriptOption option) /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::option = option;
		return picker == null ? null : picker.option(option);
	}-*/;
	public final native JsDate getOption() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		return picker == null ? null : picker.option();
	}-*/;
	
	//action functions
	/**
	 * Destroys the widget and removes all attached event listeners
	 */
	public final native void destroy() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		picker && picker.destroy();
	}-*/;
	/**
	 * Shows or hides the widget
	 */
	public final native void show() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		picker && picker.show();
	}-*/;
	/**
	 * Hides the widget
	 */
	public final native void hide() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		picker && picker.hide();
	}-*/;
	/**
	 * Shows or hides the widget
	 */
	public final native void toggole() /*-{
		var picker = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker;
		picker && picker.toggole();
	}-*/;
	
	/**
	 * creates datetimepicker javascript object
	 * 
	 */
	protected final native void render() /*-{
		var e = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::getElement()();
		var o = this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::option;
		this.@usf.gwt.ui.bootstrap.datetimepicker2.DateTimePicker::picker =
			$wnd.$(e).datetimepicker(o).data("DateTimePicker");
	}-*/;

	public static final JavaScriptOption defaultDateTimePickerOptions(){
		return JavaScriptOption.createOption()
		.set("locale", "fr")
		.set("format", "L");
	}

}
