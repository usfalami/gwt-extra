package usf.gwt.bootstrap.ui.js;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.core.Constants.StyleEnum;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 *
 * @author Youssef ALAMI
 * 
 */
public final class JqueryUtils {
		
	public static <T extends Enum<T> & Constants.StyleEnum> T hasClass(Element e, Class<T> clazz){
		if(clazz.getEnumConstants().length == 0) return null;
		T enm = clazz.getEnumConstants()[0];
		String style = findClassByPrefix(e, enm.prefix(), 2, arrayToJsString(enm.excludes()));
		return style == null ? enm : StyleEnum.Utils.valueOf(clazz, style);
	}
	public static <T extends Enum<T> & Constants.StyleEnum> void toggleClass(Element e, T enm) {
		String c = enm==null ? null : StyleEnum.Utils.fullValue(enm);
		replaceClass(e, findClassByPrefix(e, enm.prefix(), 0, arrayToJsString(enm.excludes())), c);
	}

	public static native boolean hasClass(Element e, String c)/*-{
		return $wnd.$(e).hasClass(c);
	}-*/;
	public static native String findClassByPrefix(Element e, String s, int group, String excludes)/*-{
		var reg = @usf.gwt.bootstrap.ui.js.JqueryUtils::createBootstrapStyleRegex(Ljava/lang/String;Ljava/lang/String;)(s, excludes);
		var res = reg.exec($wnd.$(e)[0].className);
		return res ? res[group] : null;
	}-*/;

	public static native JavaScriptObject createBootstrapStyleRegex(String prefix, String excludes) /*-{
		var e = excludes ? '(!?'+excludes.replace(/,/g,'|')+')':'';
		return new RegExp(e+'('+prefix+')-([\\w\-]+)',"g");
	}-*/;
		
	
	public static native void addClass(Element e, String c)/*-{
		$wnd.$(e).addClass(c);
	}-*/;
	public static native void removeClass(Element e, String c)/*-{
		$wnd.$(e).removeClass(c);
	}-*/;
	public static native void toggleClass(Element e, String className, boolean a)/*-{
		a && $wnd.$(e).addClass(className);
		a || $wnd.$(e).removeClass(className);
	}-*/;
	public static native void replaceClass(Element e, String oldClass, String newClass)/*-{
		$wnd.$(e).removeClass(oldClass).addClass(newClass);
	}-*/;
	public static native void toggleClassUnique(Element e, String c, boolean a) /*-{
		$wnd.$(e).parent().find(e.tagName).removeClass(c);
		a && $wnd.$(e).addClass(c);
	}-*/;
	
	public static native boolean hasAttrib(Element e, String c)/*-{
		return $wnd.$(e).is('['+ c +']');
	}-*/;
	public static native void toggleAttribute(Element e, String attr, boolean a)/*-{
		$wnd.$(e).attr(attr, a ? '' : null);
	}-*/;
	
	public static native String val(Element e)/*-{
		return $wnd.$(e).val();
    }-*/;
	public static native void val(Element e, String text)/*-{
		$wnd.$(e).val(text);
    }-*/;
	public static native String width(Element e)/*-{
		return $wnd.$(e).width();
	}-*/;
	public static native void width(Element e, String text) /*-{
		$wnd.$(e).width(text);
	}-*/;
	
	public static native void setButtonLoading(Element e, String state)/*-{
		$wnd.jQuery(e).button(state);
	}-*/;
	
	@Deprecated // in gwt 2.7  native java array conversion to js Array
	public static String arrayToJsString(String ... values) {
		if(values == null) return null;
		StringBuilder str = new StringBuilder();
		for(int i=0; i<values.length-1; i++)
			str.append(values[i]).append(","); //Default js Array Separator
		if(values.length>0) str.append(values[values.length-1]);
		return str.toString();			
	}
	
	public static native void jqueryConflict()/*-{
		$wnd.$.noConflict();
	}-*/;
}
