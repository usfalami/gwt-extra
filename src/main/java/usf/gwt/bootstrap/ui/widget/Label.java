package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

/**
 * <pre>{@code
 *  <label class='control-label'> ... </label>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class Label extends GridCol implements Constants.HasNodeText {

	public final static String DEFAULT_LABEL_STYLE = "control-label";
	
	Text text;
	
    public Label() {
    	super();
    }
    public Label(String text) {
    	super();
    	setText(text);
    }
    
    @Override
    protected Element initWidget() {
        Element e = Document.get().createLabelElement();
		e.appendChild(text = HasNodeText.Utils.create(""));
        return e;
    }
    
    @Override
    protected void initStyle() {
        getElement().addClassName(DEFAULT_LABEL_STYLE);
    }

    public void setFor(String id) {
        getElement().setAttribute(Constants.ATTRIB_FOR, id);
    }
    public String getFor() {
        return getElement().getAttribute(Constants.ATTRIB_FOR);
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
