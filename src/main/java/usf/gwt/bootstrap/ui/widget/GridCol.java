package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

/**
 * <pre>{@code
 *  <div class='col-md-x col-md-offset-x'> ... </div>
 * }</pre>
 * 
 * @see GridRow
 * 
 * @see <a href="http://getbootstrap.com/css/#grid">http://getbootstrap.com/css/#grid</a>
 * 
 * @author Youssef ALAMI
 * 
 */
public class GridCol extends Layout {

	public void setSize(ColumnSizes size){
		JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_COLUMN_PREFIX, size, "^col-md-offset");
	}
	public void setOffset(ColumnOffsets offset){
		JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_COLUMN_PREFIX, offset, "^md-\\d");	
	}
}
