package com.gwt.extra.client.demo.tools;

public abstract class CodeFormater {

	protected static final native String formatXML(final String xml)/*-{
		var reg = /(<[\w\s=_\.\-':@%,]+>[\w\s\\.]*<\/[\w]+>)|(<[\w\s=_\.\-':@%,]+>)|(<\/[\w]+>)/g;
		var ind = @com.gwt.extra.client.demo.tools.CodeFormater::indent(I);
		var t=""; var sp=0;
		while(m=reg.exec(xml))
		    t += (m[1]!=null?ind(sp):m[2]!=null?ind(sp++):ind(--sp))+m[0]+'\n';	    
		return t;
	}-*/;
	protected static final native String indent(int sp)/*-{
	    var s = "";
	    for(i=0;i<sp;i++) s+="  ";
	    return s;
	}-*/;

	public static enum Languages {
		NONE{@Override public String format(String code) {return code;}},
		XML{@Override public String format(String code) {return CodeFormater.formatXML(code);}};				
		public abstract String format(String code);
	}

}
