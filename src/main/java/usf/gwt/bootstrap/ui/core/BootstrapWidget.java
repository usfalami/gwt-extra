package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.js.JqueryUtils;
import usf.gwt.bootstrap.ui.widget.Bootstrap;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public abstract class BootstrapWidget extends Widget implements Bootstrap {

    public BootstrapWidget() {
        setElement(initWidget());
        initStyle();
    }

    @Override
    public void setId(String id) {
        getBaseElement().setId(id);
    }
    @Override
    public String getId() {
        return getBaseElement().getId();
    }
    
	public void setAlign(AlignementStyles align) {
		JqueryUtils.switchClass(getElement(), Constants.BOOTSTRAP_ALIGN_PREFIX, align);
	}

    protected abstract Element initWidget();
    protected void initStyle() {}

    @Override
    public Element getBaseElement() {
        return getElement();
    }
}
