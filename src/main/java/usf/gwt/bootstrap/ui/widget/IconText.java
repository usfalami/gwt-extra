package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;
import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasIcon;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasText;
import usf.gwt.bootstrap.ui.widget.Bootstrap.IconTypes;
import usf.gwt.bootstrap.ui.widget.Bootstrap.InputGroupAddOn;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

public class IconText extends BootstrapWidget implements HasIcon<IconTypes>, InputGroupAddOn, HasText {
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createSpanElement();
		Element s = Document.get().createSpanElement();
		Text t = Document.get().createTextNode("");
		e.appendChild(s);
		e.appendChild(t);
		return e;
	}
	@Override
	protected void initStyle() {
		getIconElement().addClassName(Constants.BOOTSTRAP_ICON_PREFIX);
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
	public IconTypes getIcon() {
    	return JqueryUtils.hasClass(getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, IconTypes.class);
	}
	public void setIcon(IconTypes type){
		JqueryUtils.switchClass(getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, type);
	}

	@Override
	public Element getIconElement() {
		return getElement().getFirstChildElement();
	}
	@Override
	public Text getTextElement(){
		return getElement().getChild(1).cast();		
	}


}
