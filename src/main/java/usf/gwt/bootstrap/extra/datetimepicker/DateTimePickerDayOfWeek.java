package usf.gwt.bootstrap.extra.datetimepicker;

public enum DateTimePickerDayOfWeek {

    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

    private int value;

    DateTimePickerDayOfWeek(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static DateTimePickerDayOfWeek dayOf(int value){
    	return value >= values().length ? null :  values()[value];
    }

}