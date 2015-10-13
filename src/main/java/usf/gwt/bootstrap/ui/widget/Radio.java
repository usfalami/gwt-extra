package usf.gwt.bootstrap.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * <pre>{@code
 *  <div class='radio'>
 *   <label>
 *   	<input type='radio' >
 *   </label>
 *  </div>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class Radio extends CheckableControl {

	public static final String RADIO_STYLE = "radio";
	
	@Override
	protected Element initWidget() {
		return super.initWidget(Document.get().createRadioInputElement(""));
	}
	@Override
	protected void initStyle() {
		super.initStyle(RADIO_STYLE);
	}

}
