package usf.gwt.ui.timeline.client;

import java.util.Date;

import usf.gwt.ui.timeline.client.entry.TimeLineEntry;
import usf.gwt.ui.timeline.client.event.GroupClickEvent;
import usf.gwt.ui.timeline.client.event.GroupClickEvent.GroupClickHandler;
import usf.gwt.ui.timeline.client.event.GroupClickEvent.HasGroupClickHandler;
import usf.gwt.ui.timeline.client.event.ItemSelectionChangeEvent;
import usf.gwt.ui.timeline.client.event.ItemSelectionChangeEvent.HasItemSelectionChangeHandler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author YAH
 * 
 * http://almende.github.io/chap-links-library/js/timeline/doc/
 *         v2.0
 * 
 */
public class TimeLine extends Widget implements HasItemSelectionChangeHandler,
		HasGroupClickHandler {

	private JavaScriptObject timeline;

	public TimeLine() {
		Element div = Document.get().createDivElement();
		setElement(div);
		timeline = initialize(div);
		attachClickEvent(this);
	}

	protected final native JavaScriptObject initialize(final Element e) /*-{
		var o = new $wnd.links.Timeline(e);
		o.setOptions({locale : "fr", stackEvents : false, groupsOrder : false, showMajorLabels : true, zoomable : false, groupsWidth:'150px', groupMinHeight : 15});
		return o;
	}-*/;

	public void setVisiblePeriode(Date start, Date end) {
		setVisiblePeriode(timeline, JsDate.create(start.getTime()), JsDate.create(end.getTime()));
	}
	public void setIntervalPeriode(Date start, Date end) {
		setIntervalPeriode(timeline, JsDate.create(start.getTime()), JsDate.create(end.getTime()));
	}

	public void addItem(TimeLineEntry item) {
		addItem(timeline, item);
	}

	public void setData(JsArray<TimeLineEntry> array) {
		clearItems();
		for (int i=0; i<array.length(); i++) 
			addItem(array.get(i));
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
	}
	@Override
	protected void onUnload() {
		super.onUnload();
		removeAllPopup();
	}	
	

	public JsArray<TimeLineEntry> getData() {
		return getData(timeline);
	}

	public void clearItems() {
		clearData(timeline);
	}

	public void addGroup(String groupName, boolean clickable) {
		addGroup(this, groupName, clickable);
	}	
	public void clearGroup(String group) {
		clearGroup(this, group);
	}

	@Override
	public HandlerRegistration addItemSelectionChangeHandler(ItemSelectionChangeEvent.ItemSelectionChangeHandler handler) {
		return addHandler(handler, ItemSelectionChangeEvent.type);
	}

	@Override
	public HandlerRegistration addGroupClickHandler(GroupClickHandler handler) {
		return addHandler(handler, GroupClickEvent.type);
	}
	
	protected final static native JsArray<TimeLineEntry> getData(final JavaScriptObject o) /*-{
		return o.getData();
	}-*/;

	protected final static native void setData(final JavaScriptObject o, final JsArray<TimeLineEntry> a) /*-{
		o.setData(a);
	}-*/;

	protected final static native void addItem(final JavaScriptObject o, final TimeLineEntry entry)/*-{
		o.addItem(entry);
		newItem = o.items[o.items.length - 1];
		$wnd.jQuery(newItem.dom).popover({content : entry.popupContent,
			placement:'bottom', html:true, trigger:'hover', container:'body'});
	}-*/;
	protected final static native void addGroup(final TimeLine t, final String groupName, final boolean c)/*-{
		var o = t.@usf.gwt.ui.timeline.client.TimeLine::timeline;
		o.addItem({group : groupName});
		if(!c) return;
		var e = o.dom.groups.labels[o.dom.groups.labels.length - 1];
		$wnd.$(e).click(function(e) {
			t.@usf.gwt.ui.timeline.client.TimeLine::fireGroupClick(Ljava/lang/String;)(e.target.textContent);
		});
		e.style.cursor = 'pointer';
	}-*/;

	protected final static native void clearGroup(final TimeLine t, final String groupName) /*-{
		var o = t.@usf.gwt.ui.timeline.client.TimeLine::timeline;
		for(i=o.items.length-1; i>=0; i--)
			o.getGroupName(o.items[i].group) === groupName && o.deleteItem(i);
	}-*/;
	protected final static native void clearData(JavaScriptObject o) /*-{
		o.clearItems();
		o.repaint();
	}-*/;	

	protected final static native void setVisiblePeriode(final JavaScriptObject o, final JsDate start, final JsDate end) /*-{
		o.setVisibleChartRange(start, end, true);
	}-*/;
	protected final static native void setIntervalPeriode(final JavaScriptObject o, final JsDate start, final JsDate end) /*-{
		o.options['min'] = start;
		o.options['max'] = end;
		o.repaint();
	}-*/;

	protected final static native void attachClickEvent(final TimeLine t) /*-{
		var o = t.@usf.gwt.ui.timeline.client.TimeLine::timeline;
		$wnd.links.events.addListener(o,'select', function() {
			if (o.getSelection()[0]) {
				e = o.data[o.getSelection()[0].row];
				e.clickable && t.@usf.gwt.ui.timeline.client.TimeLine::fireItemSelectEvent(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
				o.setSelection({});
			}
		});
	}-*/;
	
	private void fireItemSelectEvent(JavaScriptObject o) {
		fireEvent(new ItemSelectionChangeEvent((TimeLineEntry) o));
	}
	private void fireGroupClick(String groupName) {
		fireEvent(new GroupClickEvent(groupName));
	}
	public final static native void removeAllPopup() /*-{
		var pop = $wnd.$('.popover');
		if(pop) pop.hide();
	}-*/;
}
