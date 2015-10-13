package usf.gwt.bootstrap.extra.datetimepicker;

import usf.gwt.bootstrap.ui.core.BootstrapWidget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;

public class CalendarLegend extends BootstrapWidget {

    @Override
    protected Element initWidget() {
        Element div = Document.get().createDivElement();
        Element table = Document.get().createTableElement();
        Element tr = Document.get().createTRElement();
        table.appendChild(tr);
        div.appendChild(table);
        return div;
    }

    public Element getTableElement() {
        return getElement().getFirstChildElement();
    }
    public Element getTrElement() {
        return getTableElement().getFirstChildElement();
    }

    public CalendarLegend addLegend(String styleClassName, String label) {
        Element td = MonthCalendar.createTRElement("x");
        if(styleClassName != null && !styleClassName.isEmpty())
        	td.getFirstChildElement().addClassName(styleClassName);
        td.getFirstChildElement().getStyle().setPaddingTop(3, Unit.PX);
        getTrElement().appendChild(td);
        td = Document.get().createTDElement();
        td.setInnerText(label);
        td.getStyle().setPaddingRight(20, Unit.PX);
        td.getStyle().setPaddingLeft(5, Unit.PX);
        getTrElement().appendChild(td);
        return this;
    }

    public void clear() {
    	getTrElement().removeAllChildren();
	}

}
