package usf.gwt.bootstrap.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * <pre>{@code
 *  <div class='checkbox'>
 *   <label>
 *    <input type='checkbox' >
 *   </label>
 *  </div>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class CheckBox extends CheckableControl {
	
	private static final String CHECKBOX_STYLE = "checkbox";
	
	@Override
	protected Element initWidget() {
		return super.initWidget(Document.get().createCheckInputElement());
	}
	@Override
	protected void initStyle() {
		super.initStyle(CHECKBOX_STYLE);
	}
}
