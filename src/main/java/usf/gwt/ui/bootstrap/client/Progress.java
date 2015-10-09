package usf.gwt.ui.bootstrap.client;


public class Progress extends Layout {
	
	public static final String PROGRESS_DEFAULT_STYLE = "progress";
	
	@Override
	protected void initStyle() {
		getElement().addClassName(PROGRESS_DEFAULT_STYLE);
	}

}
