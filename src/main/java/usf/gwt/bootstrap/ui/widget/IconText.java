package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasIcon;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasText;
import usf.gwt.bootstrap.ui.widget.Bootstrap.IconTypes;
import usf.gwt.bootstrap.ui.widget.Bootstrap.InputGroupAddOn;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;

public class IconText extends BootstrapWidget implements HasIcon<IconTypes>, InputGroupAddOn, HasText {
	
	Text text;
	SpanElement icon;
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createSpanElement();
		e.appendChild(icon = HasIcon.Utils.create());
		e.appendChild(text = HasText.Utils.create(""));
		return e;
	}
	
	@Override
	public String getText() {
		return HasText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		HasText.Utils.setText(this, text);
	}
	@Override
	public void setIcon(IconTypes icon) {
		HasIcon.Utils.setIcon(this, icon);
	}
	@Override
	public IconTypes getIcon() {
		return HasIcon.Utils.getIcon(this);
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
