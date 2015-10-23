package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;

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
public class Label extends GridCol implements Constants.HasText {

	public final static String DEFAULT_LABEL_STYLE = "control-label";
	
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
        Text t = Document.get().createTextNode("");
        e.appendChild(t);
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

    public String getText() {
        return getTextElement().getNodeValue();
    }
    public void setText(String text) {
    	getTextElement().setNodeValue(text);
    }
	
	@Override
	public Text getTextElement() {
		return getElement().getFirstChild().cast();
	}


}
