package usf.gwt.bootstrap.ui.widget;

/**
 * <pre>{@code
 *  <div class='row'> ... </div>
 * }</pre>
 * 
 * @see GridCol
 * 
 * @see <a href="http://getbootstrap.com/css/#grid">http://getbootstrap.com/css/#grid</a>
 * 
 * @author Youssef ALAMI
 * 
 */
public class GridRow extends Layout {
	
	public static final String DEFAULT_ROW_STYLE = "row";

	@Override
	protected void initStyle() {
		getElement().addClassName(DEFAULT_ROW_STYLE);
	}

}
