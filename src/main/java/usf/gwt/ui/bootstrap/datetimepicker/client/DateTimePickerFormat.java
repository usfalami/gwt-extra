package usf.gwt.ui.bootstrap.datetimepicker.client;

public enum DateTimePickerFormat {

    DD_MM_YYYY("dd/mm/yyyy", "jj/mm/aaaa"), DD_MM_YYYY_HH_MM("dd/mm/yyyy hh:ii", "jj/mm/aaaa hh:mm"), DD_MM_YYYY_HH_MM_SS("dd/mm/yyyy hh:ii:ss", "jj/mm/aaaa hh:mm:ss"), HH_MM("hh:ii", "hh:mm"), HH_MM_SS("hh:ii:ss", "hh:mm:ss"), MM_YYYY("mm/yyyy", "mm/aaaa");

    private final String value;
    private final String visibleValue;

    DateTimePickerFormat(String value, String visibleValue) {
        this.value = value;
        this.visibleValue = visibleValue;
    }

    public String getValue() {
        return value;
    }

    public String getVisibleValue() {
        return visibleValue;
    }
}