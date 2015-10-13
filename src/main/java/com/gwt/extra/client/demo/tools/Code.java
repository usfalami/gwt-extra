package com.gwt.extra.client.demo.tools;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.extra.client.demo.tools.CodeFormater.Languages;

public class Code extends Widget implements HasHTML {
	
	protected Languages lang;
	
	public Code(Languages lang) {
		this.lang = lang;
		setElement(Document.get().createPreElement());
		getElement().setClassName("brush:" + lang.name().toLowerCase() + ';');
	}
	
	@Override
	public String getHTML() {
		return getElement().getInnerText();
	}
	@Override
	public void setHTML(String html) {
		getElement().setInnerText(lang.format(html));
	}
	@Override
	public String getText() {
		return getElement().getInnerText();
	}
	@Override
	public void setText(String text) {
		getElement().setInnerText(text);
	}

}
