package usf.gwt.bootstrap.extra.datetimepicker;

public enum DateTimePickerDayOfWeek {

    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    DateTimePickerDayOfWeek() {
    }

    public int getValue() {
        return this.ordinal();
    }
    
    public static DateTimePickerDayOfWeek dayOf(int value){
    	return value >= values().length ? null :  values()[value];
    }

}