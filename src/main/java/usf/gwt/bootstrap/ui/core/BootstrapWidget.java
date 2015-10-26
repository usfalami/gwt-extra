package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.core.Constants.AlignementStyles;
import usf.gwt.bootstrap.ui.core.Constants.HasAlign;
import usf.gwt.bootstrap.ui.widget.Bootstrap;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public abstract class BootstrapWidget extends Widget implements Bootstrap, HasAlign<AlignementStyles> {

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
    
	@Override
	public void setAlign(Constants.AlignementStyles align) {
		HasAlign.Utils.setAlign(this, align);
	}
	@Override
	public AlignementStyles getAlign() {
		return HasAlign.Utils.getAlign(this, AlignementStyles.class);
	}

    protected abstract Element initWidget();
    protected void initStyle() {}

    @Override
    public Element getBaseElement() {
        return getElement();
    }
}
