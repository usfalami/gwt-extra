package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class BootstrapContainer extends ComplexPanel implements Bootstrap {

	public BootstrapContainer() {
		setElement(initWidget());
		initStyle();
	}
	
	@Override
	public void add(Widget child) {
		add(child, (child instanceof AttachWidget) ? getBaseElement() : getContainerElement());
	}

	public void setAlign(AlignementStyles align) {
		JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_ALIGN_PREFIX, align);
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
	protected Element getContainerElement() {
		return getElement();
	}
	
	protected abstract Element initWidget();
	protected void initStyle() {}
}
