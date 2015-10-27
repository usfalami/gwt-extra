package usf.gwt.bootstrap.ui.core;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;

public interface Bootstrap extends IsWidget {
	
	void setId(String id);
	String getId();
	Element getBaseElement();
	
	interface AttachWidget {}
	interface InputGroupAddOn {}
}
