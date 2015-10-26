package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasActive;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;



public class ProgressBar extends Progress implements Constants.HasStyle<Constants.ProgressBarStyles>, Constants.HasNodeText, Constants.HasActive {
	
	Text text;

	@Override
	protected Element initWidget() {
		Element e =  super.initWidget();
		Element s = Document.get().createSpanElement();
		s.appendChild(text = HasNodeText.Utils.create(""));
		e.appendChild(s);
		return e;
	}
	
	@Override
	protected void initStyle() {
//		super.initStyle();
		getElement().addClassName(Constants.BOOTSTRAP_PROGRESS_BAR_PREFIX);
	}

	@Override
	public Constants.ProgressBarStyles getStyle() {
		return Constants.HasStyle.Utils.getStyle(this, Constants.ProgressBarStyles.class);
	}
	@Override
	public void setStyle(Constants.ProgressBarStyles style) {
		Constants.HasStyle.Utils.setStyle(this, style);
	}
    
	@Override
	public String getText() {
		return HasNodeText.Utils.getText(this);
	}
	@Override
	public void setText(String text) {
		HasNodeText.Utils.setText(this ,text);
	}
    public void setValue(String value) {
    	JqueryUtils.width(getElement(), value);
	}
    public String getValue() {
    	return JqueryUtils.width(getElement());
	}
    
    @Override
    public void setActive(boolean active) {
    	Constants.HasStyle.Utils.setStyle(getElement(), Constants.BOOTSTRAP_PROGRESS_BAR_STRIPED_STYLE, active);
    	HasActive.Utils.setActive(this, active);
    }
    @Override
    public boolean isActive(){
    	return HasActive.Utils.isActive(this);
    }
    
    @Override
    public Element getBaseElement() {
    	return getElement().getFirstChildElement();
    }
    @Override
    public Text getTextElement(){
    	return text;
    }
    
    @Override
    public Element getStylElement() {
    	return getElement();
    }
}
