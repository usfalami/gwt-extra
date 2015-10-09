package usf.gwt.ui.highchart.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Serie extends JavaScriptObject {

	protected Serie() {
	}

	public final native void init() /*-{
		this['data'] = [];
	}-*/;

	public final native void setName(final String name) /*-{
		this['name'] = name;
	}-*/;

	public final native String getName() /*-{
		return this['name'];
	}-*/;

	public final native void setColor(final String color) /*-{
		this['color'] = color;
	}-*/;

	public final native String getColor() /*-{
		return this['color'];
	}-*/;
	
	public final void setData(Point... points) {
		init();
		addData(points);
	}

	public final native void setData(final JavaScriptObject data) /*-{
		//Map<Long, Double>
		this['data'] = data;
	}-*/;

	public final native JavaScriptObject getData() /*-{
		return this['data'];
	}-*/;

	public final void addData(Point... points) {
		for (Point p : points)
			addData(p.getPointDate(), p.getPointValue());
	}

	public final native void addData(final double date, final double value) /*-{
		array = this['data'];
		array[array.length] = [ date, value];
	}-*/;

	public final native void addData(final double value) /*-{
		array = this['data'];
		array[array.length] = value;
	}-*/;
}
