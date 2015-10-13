package usf.gwt.bootstrap.ui.widget;


public class Progress extends Layout {
	
	public static final String PROGRESS_DEFAULT_STYLE = "progress";
	
	@Override
	protected void initStyle() {
		getElement().addClassName(PROGRESS_DEFAULT_STYLE);
	}

}
