package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Bootstrap.InputGroupAddOn;
import usf.gwt.bootstrap.ui.core.Constants.HasIcon;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;
import usf.gwt.bootstrap.ui.core.Constants.IconTypes;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;

public class IconText extends BootstrapWidget implements HasIcon<IconTypes>, InputGroupAddOn, HasNodeText {
	
	Text text;
	SpanElement icon;
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createSpanElement();
//		e.appendChild(icon = HasIcon.Utils.create());
		e.appendChild(text = HasNodeText.Utils.create(""));
		return e;
	}
	
	@Override
	public String getText() {
		return HasNodeText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		HasNodeText.Utils.setText(this, text);
	}
	@Override
	public void setIcon(IconTypes icon) {
		HasIcon.Utils.setIcon(this, icon);
	}
	@Override
	public IconTypes getIcon() {
		return HasIcon.Utils.getIcon(this, IconTypes.class);
	}
	
	@Override
	public void setIconElement(SpanElement e) {
		getElement().insertFirst(icon = e);
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
