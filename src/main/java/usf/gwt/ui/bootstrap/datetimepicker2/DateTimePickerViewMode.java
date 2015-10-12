package usf.gwt.ui.bootstrap.datetimepicker2;

public enum DateTimePickerViewMode {

	DAYS, MONTHS, YEARS, DECADES;
	
	public String getValue() {
		return this.name().toLowerCase();
	}
}