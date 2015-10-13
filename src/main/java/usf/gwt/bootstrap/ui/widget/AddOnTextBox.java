package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;

public class AddOnTextBox extends TextBox {

	private static final String DEFAULT_INPUT_GROUP_STYLE = "input-group";
	private static final String DEFAULT_GROUP_ADD_ON_STYLE = "input-group-addon";
	
	@Override
	protected Element initWidget() {
		Element e = Document.get().createDivElement();
		AnchorElement l = Document.get().createAnchorElement();
		l.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
		e.appendChild(l);
		e.appendChild(super.initWidget());
		AnchorElement r = Document.get().createAnchorElement();
		r.setHref(Constants.VALUE_JAVA_SCRIPT_EMPTY_FUNCTION);
		e.appendChild(r);
		return e;
	}
	
	@Override
	protected void initStyle() {
		super.initStyle();
		getElement().addClassName(DEFAULT_INPUT_GROUP_STYLE);
	}
	
	public void setLeftAddOn(IconTypes type) {
		setAddOn(getLeftAddOn(), type);
	}
	public void setRightAddOn(IconTypes type) {
		setAddOn(getRightAddOn(), type);
	}
	public void removeLeftAddOn() {
		getLeftAddOn().removeClassName(DEFAULT_GROUP_ADD_ON_STYLE);
		getLeftAddOn().removeAllChildren();
	}
	public void removeRightAddOn() {
		getRightAddOn().removeClassName(DEFAULT_GROUP_ADD_ON_STYLE);
		getRightAddOn().removeAllChildren();
	}
	
	@Override
	public InputElement getBaseElement() {
		return getElement().getChild(1).cast();
	}
	protected AnchorElement getLeftAddOn(){
		return getElement().getFirstChild().cast();
	}
	protected AnchorElement getRightAddOn(){
		return getElement().getLastChild().cast();
	}
		
	protected final static void setAddOn(AnchorElement anchor, IconTypes type){
		Element span = anchor.getFirstChildElement();
		if(span==null) {
			span = Document.get().createSpanElement();
			span.addClassName(Constants.BOOTSTRAP_ICON_PREFIX);
			anchor.addClassName(DEFAULT_GROUP_ADD_ON_STYLE);
			anchor.appendChild(span);
		}
		JqueryUtils.switchClass(span, Constants.BOOTSTRAP_ICON_PREFIX, type);
	}
}
