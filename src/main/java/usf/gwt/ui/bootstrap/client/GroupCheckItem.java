package usf.gwt.ui.bootstrap.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;

public class GroupCheckItem extends GroupItem {
	
	protected CheckBox c;

	@Override
	protected Element initWidget() {
    	Element e = super.initWidget();
		add(c=new CheckBox(), e);
    	return e;
	}
	
    public void setColor(String color) {
    	c.getLabelElement().getStyle().setColor(color);
    }
    public void getColor() {
    	c.getLabelElement().getStyle().getColor();
	}
    public void setChecked(boolean checked) {
    	c.setChecked(checked);
    }
    public boolean isChecked() {
        return c.getChecked();
    }
    @Override
    public void setEnabled(boolean enabled) {
    	super.setEnabled(enabled);
    	c.setEnabled(enabled);
    }
    
    public CheckBox getChecbox() {
		return c;
	}

    @Override
    public Element getBaseElement() {
    	return c.getElement();
    }
    @Override
	public Text getTextElement() {
    	return c.getTextElement();
    }

}
