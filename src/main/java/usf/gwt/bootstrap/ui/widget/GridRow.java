package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;

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
	
	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.DEFAULT_ROW_STYLE);
	}

}
