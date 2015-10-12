package usf.gwt.ui.bootstrap.datetimepicker2;

public enum DateTimePickerFormat {

	YYYY("YYYY", "aaaa"),
	
    MM_YYYY("MM/YYYY", "mm/aaaa"),
	
    DD_MM_YYYY("DD/MM/YYYY", "jj/mm/aaaa"), 
    
    DD_MM_YYYY_HH_MM("DD/MM/YYYY HH:mm", "jj/mm/aaaa hh:mm"), 
    
    DD_MM_YYYY_HH_MM_SS("DD/MM/YYYY HH:mm:ss", "jj/mm/aaaa hh:mm:ss"), 
    
    HH_MM("HH:mm", "hh:mm"), 
    
    HH_MM_SS("HH:mm:ss", "hh:mm:ss"),
    
    Week("W", "N° de Semaine");
    
    private String pattern;
    private String label;

    DateTimePickerFormat(String pattern, String visibleValue) {
        this.pattern = pattern;
        this.label = visibleValue;
    }

    public String getPattern() {
        return pattern;
    }

    public String getLabel() {
        return label;
    }
    
    public static DateTimePickerFormat patternOf(String pattern) {
    	if(pattern == null) return null;
    	for(DateTimePickerFormat f : values())
    		if(pattern.equals(f.getPattern())) return f;
    	return null;
    }
}