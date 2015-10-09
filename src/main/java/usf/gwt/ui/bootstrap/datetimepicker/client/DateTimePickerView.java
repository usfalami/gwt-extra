package usf.gwt.ui.bootstrap.datetimepicker.client;

public enum DateTimePickerView {

    HOUR(0), DAY(1), MONTH(2), YEAR(3), DECADE(4);

    private final int value;

    DateTimePickerView(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}