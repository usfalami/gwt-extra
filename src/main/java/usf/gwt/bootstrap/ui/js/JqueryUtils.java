package usf.gwt.bootstrap.ui.js;

import usf.gwt.bootstrap.ui.core.Constants;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 *
 * @author Youssef ALAMI
 * 
 */
public final class JqueryUtils {
	
	public static boolean isActive(Element e) {
		return hasClass(e, Constants.BOOTSTRAP_ACTIVE);
	}
	public static void activate(Element e, boolean add) {
		switchClass(e, Constants.BOOTSTRAP_ACTIVE, add);
	}
	public static void activateUnique(Element e, boolean add) {
		switchClassUnique(e, Constants.BOOTSTRAP_ACTIVE, add);
	}
	public static boolean isStyleEnabled(Element e) {
		return !hasClass(e, Constants.BOOTSTRAP_DISABLED);
	}
	public static void setStyleEnabled(Element e, boolean value) {
		switchClass(e, Constants.BOOTSTRAP_DISABLED, !value);
	}
	public static boolean isFormControlEnabled(Element e) {
		return !hasAttrib(e, Constants.BOOTSTRAP_DISABLED);
	}
	public static void setFormControlEnabled(Element e, boolean value) {
		switchAttribute(e, Constants.BOOTSTRAP_DISABLED, !value);
	}
	
	public static <T extends Enum<T> & Constants.StyleEnum> T hasClass(Element e, Class<T> clazz){
		T style = Enum.valueOf(clazz, "NONE");
		if(style == null) return null;
		String s = findClassByPrefix(e, style.prefix(), 2, arrayToJsString(style.excludes()));
		return s == null ? style : bootstrapStyleToJavaEnum(clazz, s);
	}
	public static <T extends Enum<T> & Constants.StyleEnum> void switchClass(Element e, T value) {
		String c = value==null ? null : javaEnumToBootstrapStyle(value.prefix(), value.value());
		switchClass(e, findClassByPrefix(e, value.prefix(), 0, arrayToJsString(value.excludes())), c);
	}
	
	public static <T extends Enum<T>> T bootstrapStyleToJavaEnum(Class<T> clazz, String style){
		return Enum.valueOf(clazz, style.toUpperCase().replaceAll(Constants.BOOTSTRAP_STYLE_SEPARATOR, Constants.JAVA_STYLE_SEPARATOR));
	}
	public static String javaEnumToBootstrapStyle(String prefix, String style){
		return prefix + Constants.BOOTSTRAP_STYLE_SEPARATOR + style;
	}
	
	public static void attachCollapser(Element elem, String target) {
        elem.setAttribute(Constants.ATTRIB_DATA_TARGET, target);
        elem.setAttribute(Constants.ATTRIB_DATA_TOGGLE, Constants.BOOTSTRAP_COLLAPSE);
        //test(elem, target);
	}
	public static void attachCollapser(Element elem, Element target) {
        elem.setAttribute(Constants.ATTRIB_DATA_TARGET, Constants.JQUERY_ID_SELECTOR + target.getId());
        elem.setAttribute(Constants.ATTRIB_DATA_TOGGLE, Constants.BOOTSTRAP_COLLAPSE);
    	switchClass(target, Constants.BOOTSTRAP_COLLAPSE, Constants.BOOTSTRAP_COLLAPSE_IN);
	}
	
	public static native void test(Element e, String t) /*-{
		var target = $wnd.$(t);
		target.on('hidden.bs.collapse', function () {$wnd.console.log(e); $wnd.$(e).addClass(@usf.gwt.bootstrap.ui.core.Constants::BOOTSTRAP_COLLAPSED)});
		target.on('shown.bs.collapse', function () {$wnd.console.log(e); $wnd.$(e).removeClass(@usf.gwt.bootstrap.ui.core.Constants::BOOTSTRAP_COLLAPSED)});
	}-*/;
	
	public static void collapse(Element e, Element target, boolean collapse) {
        if(collapse){
        	switchClass(target, Constants.BOOTSTRAP_COLLAPSE_IN, Constants.BOOTSTRAP_COLLAPSE);
        	e.addClassName(Constants.BOOTSTRAP_COLLAPSED);
        }
        else {
        	switchClass(target, Constants.BOOTSTRAP_COLLAPSE, Constants.BOOTSTRAP_COLLAPSE_IN);
        	e.removeClassName(Constants.BOOTSTRAP_COLLAPSED);
        }
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
	public static native void switchClass(Element e, String className, boolean a)/*-{
		a && $wnd.$(e).addClass(className);
		a || $wnd.$(e).removeClass(className);
	}-*/;
	public static native void switchClass(Element e, String oldClass, String newClass)/*-{
		$wnd.$(e).removeClass(oldClass).addClass(newClass);
	}-*/;
	public static native void switchClassUnique(Element e, String c, boolean a) /*-{
		$wnd.$(e).parent().find(e.tagName).removeClass(c);
		a && $wnd.$(e).addClass(c);
	}-*/;
	
	public static native boolean hasAttrib(Element e, String c)/*-{
		return $wnd.$(e).is('['+ c +']');
	}-*/;
	public static native void switchAttribute(Element e, String attr, boolean a)/*-{
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
	
	public static native Element getElementById(String id)/*-{
		return $wnd.$(id)[0];
	}-*/;
    
	public static native void jqueryConflict()/*-{
		$wnd.$.noConflict();
	}-*/;
}
