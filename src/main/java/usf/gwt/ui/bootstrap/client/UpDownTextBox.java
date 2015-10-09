package usf.gwt.ui.bootstrap.client;

import com.google.gwt.dom.client.Element;

public class UpDownTextBox extends AddOnTextBox {

	private int step=1;
	
	public UpDownTextBox() {
		super();
		setValue("0");
		setLeftAddOn(IconTypes.CHEVRON_LEFT);
		setRightAddOn(IconTypes.CHEVRON_RIGHT);
		init(this);
	}
		
	public void setStep(int step) {
		this.step = step;
	}
	public int getStep() {
		return step;
	}
		
	protected static final native void init(final UpDownTextBox updn) /*-{
		var l = updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::getLeftAddOn()();
		var r = updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::getRightAddOn()();
		var t = updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::getBaseElement()();
		$wnd.$(l).click(function(e) {
			updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::inc(Lcom/google/gwt/dom/client/Element;I)(t, 
				-updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::getStep()());
			$wnd.$(t).trigger('change');
		});
		$wnd.$(r).click(function(e) {
			updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::inc(Lcom/google/gwt/dom/client/Element;I)(t, 
				updn.@usf.gwt.ui.bootstrap.client.UpDownTextBox::getStep()());
			$wnd.$(t).trigger('change');
		});
	}-*/;
	protected final native void inc(Element text, int value) /*-{
		var s=parseInt($wnd.$(text).val());
		!isNaN(s) && $wnd.$(text).val((s+value)+"");
	}-*/;
	
}
