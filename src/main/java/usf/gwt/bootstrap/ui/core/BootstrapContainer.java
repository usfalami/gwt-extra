package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.core.Constants.AlignementStyles;
import usf.gwt.bootstrap.ui.core.Constants.CanCollapse;
import usf.gwt.bootstrap.ui.core.Constants.HasAlign;
import usf.gwt.bootstrap.ui.widget.Bootstrap;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class BootstrapContainer extends ComplexPanel implements Bootstrap, CanCollapse, HasAlign<AlignementStyles> {

	public BootstrapContainer() {
		setElement(initWidget());
		initStyle();
	}
	
	@Override
	public void add(Widget child) {
		add(child, (child instanceof AttachWidget) ? getBaseElement() : getContainerElement());
	}

	@Override
	public void setAlign(Constants.AlignementStyles align) {
		HasAlign.Utils.setAlign(this, align);
	}
	@Override
	public AlignementStyles getAlign() {
		return HasAlign.Utils.getAlign(this, AlignementStyles.class);
	}
	
	@Override
	public void setId(String id) {
		getElement().setId(id);
	}
	@Override
	public String getId() {
		return getElement().getId();
	}

	public Element getBaseElement() {
		return getElement();
	}
	public Element getContainerElement() {
		return getElement();
	}
	
	protected abstract Element initWidget();
	protected void initStyle() {}
	

	@Override
	public void setCollapsed(boolean collapse) {
		CanCollapse.Utils.setCollapse(this, collapse);
	}
	@Override
	public boolean isCollapsed() {
		return CanCollapse.Utils.isCollapse(this);
	}
	
	
}
