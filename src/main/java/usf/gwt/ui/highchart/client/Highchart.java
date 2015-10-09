package usf.gwt.ui.highchart.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class Highchart extends Widget {

    private JavaScriptObject chart;

    public Highchart() {
        Element div = Document.get().createDivElement();
        setElement(div);
        setWidth("100%");
        init(getElement());
    }

    protected final native JavaScriptObject init(final Element e) /*-{
	  try {
		  that = this;
		  $wnd.Highcharts.setOptions({global:{useUTC: false}});
		  return $wnd.$(e).highcharts('StockChart', {
		  chart : {zoomType :'x', events : {load : function() {that.@usf.gwt.ui.highchart.client.Highchart::chart = this}}},
		  navigator : {enabled: false}, rangeSelector : {enabled : false}, yAxis : {opposite : false}});
	  }catch(err){}
	}-*/;
    
    @Override
    protected void onAttach() {
    	super.onAttach();
    	reflow();
    }

    public final native void addSerie(final Serie s) /*-{
		this.@usf.gwt.ui.highchart.client.Highchart::chart.addSeries(s, true);
	}-*/;

    public final native void clear() /*-{
		chart = this.@usf.gwt.ui.highchart.client.Highchart::chart;
		while (chart.series.length > 0) chart.series[0].remove(true);
	}-*/;

    public final static Serie createSerie(String name) {
        Serie s = (Serie) JavaScriptObject.createObject();
        s.init();
        s.setName(name);
        return s;
    }
    
    public final native void zoomOut() /*-{
		this.@usf.gwt.ui.highchart.client.Highchart::chart.zoomOut();
	}-*/;
    public final native void reflow() /*-{
		this.@usf.gwt.ui.highchart.client.Highchart::chart.reflow();
	}-*/;
    public final native void setInterval(final JsDate min, final JsDate max) /*-{
		this.@usf.gwt.ui.highchart.client.Highchart::chart.xAxis[0].setExtremes(min, max);
	}-*/;
    public final native void showLoading() /*-{
		this.@usf.gwt.ui.highchart.client.Highchart::chart.showLoading();
	}-*/;
    public final native void hideLoading() /*-{
		this.@usf.gwt.ui.highchart.client.Highchart::chart.hideLoading();
	}-*/;

}
