package usf.gwt.ui.bootstrap.client.core;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

/**
 * <pre>{@code
 *  <ul> ... </ul>
 * }</pre>
 *
 * @author Youssef ALAMI
 * 
 */
public class List extends BootstrapContainer {
	
    protected Element initWidget() {
        return Document.get().createULElement();
    }

}
