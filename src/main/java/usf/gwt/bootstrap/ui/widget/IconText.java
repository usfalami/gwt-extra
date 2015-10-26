package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.widget.Bootstrap.InputGroupAddOn;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;

public class IconText extends BootstrapWidget implements Constants.HasIcon<Constants.IconTypes>, InputGroupAddOn, Constants.HasNodeText {
	
	Text text;
	SpanElement icon;
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createSpanElement();
		e.appendChild(icon = Constants.HasIcon.Utils.create());
		e.appendChild(text = Constants.HasNodeText.Utils.create(""));
		return e;
	}
	
	@Override
	public String getText() {
		return Constants.HasNodeText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		Constants.HasNodeText.Utils.setText(this, text);
	}
	@Override
	public void setIcon(Constants.IconTypes icon) {
		Constants.HasIcon.Utils.setIcon(this, icon);
	}
	@Override
	public Constants.IconTypes getIcon() {
		return Constants.HasIcon.Utils.getIcon(this, Constants.IconTypes.class);
	}
	
	@Override
	public SpanElement getIconElement() {
		return icon;
	}
	@Override
	public Text getTextElement(){
		return text;		
	}

}
