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

	public void setSize(Constants.ColumnSizes size){
		JqueryUtils.toggleClass(getElement(), size);
	}
	public void setOffset(Constants.ColumnOffsets offset){
		JqueryUtils.toggleClass(getElement(), offset);	
	}
}
