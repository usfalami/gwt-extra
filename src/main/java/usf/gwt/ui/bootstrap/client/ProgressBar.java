package usf.gwt.ui.bootstrap.client;

import usf.gwt.ui.bootstrap.client.Bootstrap.HasStyle;
import usf.gwt.ui.bootstrap.client.Bootstrap.HasText;
import usf.gwt.ui.bootstrap.client.Bootstrap.ProgressBarStyles;
import usf.gwt.ui.bootstrap.client.core.Constants;
import usf.gwt.ui.bootstrap.client.core.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;



public class ProgressBar extends Progress implements HasStyle<ProgressBarStyles>, HasText {
	
	@Override
	protected Element initWidget() {
		Element e =  super.initWidget();
		Element s = Document.get().createSpanElement();
		Text t = Document.get().createTextNode("");
		s.appendChild(t);
		e.appendChild(s);
		return e;
	}
	
	@Override
	protected void initStyle() {
//		super.initStyle();
		getElement().addClassName(Constants.BOOTSTRAP_PROGRESS_BAR_PREFIX);
	}

    @Override
    public ProgressBarStyles getStyle() {
    	return JqueryUtils.hasClass(getElement(), Constants.BOOTSTRAP_PROGRESS_BAR_PREFIX, 
    			ProgressBarStyles.class, Constants.BOOTSTRAP_PROGRESS_BAR_STRIPED_STYLE);
    }
    @Override
    public void setStyle(ProgressBarStyles style) {
    	JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_PROGRESS_BAR_PREFIX, style, 
    			Constants.BOOTSTRAP_PROGRESS_BAR_STRIPED_STYLE);
    }
    
    public void setText(String text) {
    	getTextElement().setNodeValue(text);
	}
    public String getText() {
    	return getTextElement().getNodeValue();
	}
    public void setValue(String value) {
    	JqueryUtils.width(getElement(), value);
	}
    public String getValue() {
    	return JqueryUtils.width(getElement());
	}
    public void setActive(boolean active) {
    	JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_PROGRESS_BAR_STRIPED_STYLE, active);
    	JqueryUtils.activate(getElement(), active);
    }
    public boolean isActive(){
    	return JqueryUtils.isActive(getElement());
    }
    
    @Override
    public Element getBaseElement() {
    	return getElement().getFirstChildElement();
    }
    @Override
    public Text getTextElement(){
    	return getBaseElement().getFirstChild().cast();
    }
    
}
