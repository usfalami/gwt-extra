package usf.gwt.ui.bootstrap.datetimepicker.client;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

public class DateTimePicker extends Widget implements HasValueChangeHandlers<Date> {

    protected static final String DATE_TIME_PICKER = "datetimepicker";
    protected static final String DATE_TIME_PICKER_LANGUAGE = "language";
    protected static final String DATE_TIME_PICKER_DATE = "date";
    protected static final String DATE_TIME_PICKER_START_DATE = "minDate";
    protected static final String DATE_TIME_PICKER_END_DATE = "maxDate";
    protected static final String DATE_TIME_PICKER_FORMAT = "format";
    protected static final String DATE_TIME_PICKER_AUTO_CLOSE = "autoclose";
    protected static final String DATE_TIME_PICKER_MIN_VIEW = "minView";
    protected static final String DATE_TIME_PICKER_MAX_VIEW = "maxView";
    protected static final String DATE_TIME_PICKER_START_VIEW = "startView";
    protected static final String DATE_TIME_PICKER_WEEK_START = "weekStart";
    protected static final String DATE_TIME_PICKER_DAYS_OF_WEEK_DISABLED = "daysOfWeekDisabled";
    protected static final String DATE_TIME_PICKER_MINUTE_STEP = "minuteStep";

    protected static final String DEFAULT_STYLE_NAME = "form-control";

    protected final InputElement input;
    protected JavaScriptObject picker;
    protected JavaScriptOption option;

    public DateTimePicker() {
        input = Document.get().createTextInputElement();
        input.setClassName(DEFAULT_STYLE_NAME);
        input.setMaxLength(10);
        setElement(input);
        initPickerParams();
    }

    protected final void initPickerParams() {
        option = JavaScriptOption.createOption();
        option.set(DATE_TIME_PICKER_LANGUAGE, "fr");
        setAutoClose(true);
        setFormat(DateTimePickerFormat.DD_MM_YYYY);
        setStartView(DateTimePickerView.MONTH);
        setMinView(DateTimePickerView.MONTH);
        setMaxView(DateTimePickerView.DECADE);
        setWeekStart(DateTimePickerDayOfWeek.MONDAY);
        setDaysOfWeekDisabled("");
        setMinuteStep(60);
    };

    @Override
    protected void onAttach() {
        super.onAttach();
        if (isLoaded()) return;
        picker = render(this, input, option);
    }

    public void setFormat(DateTimePickerFormat format) {
        setPlaceholder(format.getVisibleValue());
        option.set(DATE_TIME_PICKER_FORMAT, format.getValue());
    }
    public void setAutoClose(boolean autoclose) {
        option.set(DATE_TIME_PICKER_AUTO_CLOSE, autoclose);
    }
    public void setMinView(DateTimePickerView view) {
        option.set(DATE_TIME_PICKER_MIN_VIEW, view.getValue());
    }
    public void setMaxView(DateTimePickerView view) {
        option.set(DATE_TIME_PICKER_MAX_VIEW, view.getValue());
    }
    public void setStartView(DateTimePickerView view) {
        option.set(DATE_TIME_PICKER_START_VIEW, view.getValue());
    }
    public void setWeekStart(DateTimePickerDayOfWeek day) {
        option.set(DATE_TIME_PICKER_WEEK_START, day.getValue());
    }
    public void setDaysOfWeekDisabled(String days) {
        option.set(DATE_TIME_PICKER_DAYS_OF_WEEK_DISABLED, days);
    }
    public void setDaysOfWeekDisabled(DateTimePickerDayOfWeek... days) {
        StringBuilder str = new StringBuilder();
        for (DateTimePickerDayOfWeek d : days)
            str.append(d.getValue() + ",");
        setDaysOfWeekDisabled(str.toString());
    }
    public void setMinuteStep(int step) {
        option.set(DATE_TIME_PICKER_MINUTE_STEP, step);
    }
    public void setTodayValue(boolean todayValue) {
        if (todayValue)
            setDate(new Date());
    }

    public Date getDate() {
        if (isLoaded()) return getValueAsString(picker) == null ? null : new Date((long) getValue(picker).getTime());
        return new Date((long) option.getDate(DATE_TIME_PICKER_DATE).getTime());
    }
    public void setDate(Date date) {
        if (date == null) {
            if (isLoaded()) setValue(picker, "");
        } else {
            long t = date.getTime();
            option.set(DATE_TIME_PICKER_DATE, JsDate.create(t));
            if (isLoaded()) setValue(picker, JsDate.create(t));
        }
    }
    public boolean isEmpty() {
        return getValueAsString(picker) == null;
    }
    public void setEnabled(boolean enabled) {
        input.setDisabled(!enabled);
    }
    public void setPlaceholder(String value) {
        input.setAttribute("placeholder", value);
    }

    protected final boolean isLoaded() {
        return picker != null;
    };

    @Override
    public final HandlerRegistration addValueChangeHandler(ValueChangeHandler<Date> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }
    protected final void fireChange(double b) {
        ValueChangeEvent.fire(this, new Date((long) b));
    }

    protected final static native JavaScriptObject render(final DateTimePicker picker, final Element e, final JavaScriptObject o) /*-{
		try {
			p = $wnd.$(e).datetimepicker({
				language : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_LANGUAGE],
				format : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_FORMAT],
				autoclose : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_AUTO_CLOSE],
				startView : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_START_VIEW],
				minView : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_MIN_VIEW],
				maxView : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_MAX_VIEW],
				weekStart : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_WEEK_START],
				daysOfWeekDisabled : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_DAYS_OF_WEEK_DISABLED],
				minuteStep : o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_MINUTE_STEP]
			});
			if (d = o[@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER_DATE]) p.datetimepicker('setDate', d);
			p.on('changeDate', function(e){picker.@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::fireChange(D)(e.timeStamp);});
			return p;
		}catch(err){}
	}-*/;
    protected final static native void setValue(final JavaScriptObject o, final JsDate date) /*-{
		if (date) o.datetimepicker('setDate', date);
	}-*/;
    protected final static native JsDate getValue(final JavaScriptObject o) /*-{
		return o.data(@usf.gwt.ui.bootstrap.datetimepicker.client.DateTimePicker::DATE_TIME_PICKER).getDate();
	}-*/;
    protected final static native void setValue(final JavaScriptObject o, final String text) /*-{
		o.val(text);
	}-*/;
    protected final static native String getValueAsString(final JavaScriptObject o) /*-{
		return "" === o.val() ? null : o.val();
	}-*/;

}
