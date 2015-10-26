package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.HasEnable;
import usf.gwt.bootstrap.ui.core.Constants.HasNodeText;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.Text;

/**
 * <pre>{@code
 *  <div class='type_1'>
 *   <label>
 *    <input type='type_1' >
 *   </label>
 *  </div>
 * }</pre>
 *
 * @see Radio
 * @see CheckBox
 * 
 * @author Youssef ALAMI
 * 
 */
public abstract class CheckableControl extends FormControl<Boolean> implements HasNodeText {

	Text text;
	
	public CheckableControl() {
		super();
	}
	
	protected Element initWidget(InputElement check) {
		Element div = Document.get().createDivElement(); //TODO Remove this div 
		Element label = Document.get().createLabelElement();
		check.setId(Document.get().createUniqueId());
		label.appendChild(text = HasNodeText.Utils.create(""));
		label.setAttribute(Constants.ATTRIB_FOR, check.getId());
		div.appendChild(check);
		div.appendChild(label);
		return div;
	}
	protected void initStyle(String classStyle) {
		getElement().addClassName(classStyle);
	}	
	
	@Override
	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);
		HasEnable.Utils.setEnabled(this, enabled);
	}
	
	@Override
	public String getText() {
		return getTextElement().getNodeValue();
	}
	@Override
	public void setText(String text) {
		getTextElement().setNodeValue(text);
	}
	public void setChecked(boolean checked) {
		getBaseElement().setChecked(checked);
	}
	public boolean getChecked() {
		return getBaseElement().isChecked();
	}
	
	@Override
	public InputElement getBaseElement() {
		return getElement().getFirstChild().cast();
	}
	protected Element getLabelElement() {
		return getElement().getChild(1).cast();
	}
	@Override
	public Text getTextElement() {
		return text;
	}
	
}