package usf.gwt.bootstrap.extra.datetimepicker;

public enum DateTimePickerViewMode {

	DAYS, MONTHS, YEARS, DECADES;
	
	public String getValue() {
		return this.name().toLowerCase();
	}
}