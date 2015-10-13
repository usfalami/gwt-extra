package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap.HasIcon;
import usf.gwt.bootstrap.ui.widget.Bootstrap.IconTypes;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;

public class IconAnchor extends Anchor implements HasIcon<IconTypes> {
	     
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
		getIconElement().addClassName(Constants.BOOTSTRAP_ICON_PREFIX);
	}
	
	@Override
	public void setIcon(IconTypes icon) {
		JqueryUtils.switchClass(getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, icon);
	}
	@Override
	public IconTypes getIcon() {
		return JqueryUtils.hasClass(getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, IconTypes.class);
	}
	
	public SpanElement getIconElement() {
		return super.getElement().getFirstChild().cast();
	}
	@Override
	public Text getTextElement() {
		return super.getElement().getChild(1).cast();
	}

}
