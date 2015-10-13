package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasIcon;
import usf.gwt.bootstrap.ui.widget.Bootstrap.IconTypes;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

public class IconButton extends Button implements HasIcon<IconTypes> {

	@Override
	protected Element initWidget() {
		Element e = super.initWidget();
		Element s = Document.get().createSpanElement();
		s.setInnerHTML("&nbsp;&nbsp;");
		e.insertFirst(s);
 		return e;
	}
	@Override
	protected void initStyle() {
		super.initStyle();
		getIconElement().addClassName(Constants.BOOTSTRAP_ICON_PREFIX);
	}
	@Override
	public void setIcon(IconTypes type) {
		JqueryUtils.switchClass(getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, type);
	}
	@Override
	public IconTypes getIcon() {
    	return JqueryUtils.hasClass(getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, IconTypes.class);
	}
	
	@Override
	public Element getIconElement(){
		return getElement().getFirstChildElement();
	}
	@Override
	public Text getTextElement(){
		return getElement().getChild(1).cast();
	}
}
