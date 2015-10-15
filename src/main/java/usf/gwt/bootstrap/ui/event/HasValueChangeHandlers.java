package usf.gwt.bootstrap.ui.event;

public interface HasValueChangeHandlers<T> extends com.google.gwt.event.logical.shared.HasValueChangeHandlers<T> {
	
	void fireChangeEvent();

}
