package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Bootstrap.AttachWidget;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;

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
public class Badge extends BootstrapWidget implements HasNodeText, AttachWidget {

	Text text;
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createSpanElement();
		e.appendChild(text = HasNodeText.Utils.create(""));
		return e;
	}
	@Override
	protected void initStyle() {
		getElement().addClassName(Constants.DEFAUL_BADGE_STYLE);
		getElement().addClassName(Constants.GWT_BOOTSTRAP_BADGE);
	}
	
	@Override
	public String getText() {
		return HasNodeText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		HasNodeText.Utils.setText(this ,text);
	}
	@Override
	public Text getTextElement() {
		return text;
	}

}
