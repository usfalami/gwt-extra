package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.widget.Bootstrap.AttachWidget;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasText;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

/**
 * <pre>{@code
 *  <span class='badge'> ... </span>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class Badge extends BootstrapWidget implements HasText, AttachWidget {

	public static final String DEFAUL_BADGE_STYLE = "badge";
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createSpanElement();
		Text t = Document.get().createTextNode("");
		e.appendChild(t);
		return e;
	}
	@Override
	protected void initStyle() {
		getElement().addClassName(DEFAUL_BADGE_STYLE);
		getElement().addClassName(Constants.GWT_BOOTSTRAP_BADGE);
	}
	
	@Override
	public String getText() {
		return getTextElement().getNodeValue();
	}
	@Override
	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}
	@Override
	public Text getTextElement() {
		return getElement().getFirstChild().cast();
	}

}
