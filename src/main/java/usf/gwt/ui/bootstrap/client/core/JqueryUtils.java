package usf.gwt.ui.bootstrap.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 *
 * @author Youssef ALAMI
 * 
 */
public final class JqueryUtils {
	
	public static final boolean isActive(Element e) {
		return hasClass(e, Constants.BOOTSTRAP_ACTIVE);
	}
	public static final void activate(Element e, boolean add) {
		switchClass(e, Constants.BOOTSTRAP_ACTIVE, add);
	}
	public static final void activateUnique(Element e, boolean add) {
		switchClassUnique(e, Constants.BOOTSTRAP_ACTIVE, add);
	}
	public static final boolean isStyleEnabled(Element e) {
		return !hasClass(e, Constants.BOOTSTRAP_DISABLED);
	}
	public static final void setStyleEnabled(Element e, boolean value) {
		switchClass(e, Constants.BOOTSTRAP_DISABLED, !value);
	}
	public static final boolean isFormControlEnabled(Element e) {
		return !hasAttrib(e, Constants.BOOTSTRAP_DISABLED);
	}
	public static final void setFormControlEnabled(Element e, boolean value) {
		switchAttribute(e, Constants.BOOTSTRAP_DISABLED, !value);
	}
	
	public static final <T extends Enum<T>> T hasClass(Element e, String prefix, Class<T> t, String ... excludes){
		String s = findClassByPrefix(e, prefix, 2, arrayToJsString(excludes));
		return s == null ? null : bootstrapStyleToJavaEnum(s, t);
	}
	public static final <T extends Enum<T>> void switchClass(Element e, String prefix, Enum<T> value, String ... excludes) {
		String c = value==null ? null : javaEnumToBootstrapStyle(prefix, value);
		switchClass(e, findClassByPrefix(e, prefix, 0, arrayToJsString(excludes)), c);
	}
	
	public static final <T extends Enum<T>> T bootstrapStyleToJavaEnum(String value, Class<T> t){
		return Enum.valueOf(t, value.toUpperCase().replaceAll(Constants.BOOTSTRAP_STYLE_SEPARATOR, Constants.JAVA_STYLE_SEPARATOR));
	}
	public static final <T extends Enum<T>> String javaEnumToBootstrapStyle(String prefix, Enum<T> value){
		return prefix + Constants.BOOTSTRAP_STYLE_SEPARATOR + 
				value.name().toLowerCase().replaceAll(Constants.JAVA_STYLE_SEPARATOR, Constants.BOOTSTRAP_STYLE_SEPARATOR);
	}
	
	public static final void attachCollapser(Element elem, String target) {
        elem.setAttribute(Constants.ATTRIB_DATA_TARGET, target);
        elem.setAttribute(Constants.ATTRIB_DATA_TOGGLE, Constants.BOOTSTRAP_COLLAPSE);
        //test(elem, target);
	}
	public static final void attachCollapser(Element elem, Element target) {
        elem.setAttribute(Constants.ATTRIB_DATA_TARGET, Constants.JQUERY_ID_SELECTOR + target.getId());
        elem.setAttribute(Constants.ATTRIB_DATA_TOGGLE, Constants.BOOTSTRAP_COLLAPSE);
    	switchClass(target, Constants.BOOTSTRAP_COLLAPSE, Constants.BOOTSTRAP_COLLAPSE_IN);
	}
	
	public static final native void test(final Element e, final String t) /*-{
		var target = $wnd.$(t);
		target.on('hidden.bs.collapse', function () {$wnd.console.log(e); $wnd.$(e).addClass(@usf.gwt.ui.bootstrap.client.core.Constants::BOOTSTRAP_COLLAPSED)});
		target.on('shown.bs.collapse', function () {$wnd.console.log(e); $wnd.$(e).removeClass(@usf.gwt.ui.bootstrap.client.core.Constants::BOOTSTRAP_COLLAPSED)});
	}-*/;
	
	public static final void collapse(Element e, Element target, boolean collapse) {
        if(collapse){
        	switchClass(target, Constants.BOOTSTRAP_COLLAPSE_IN, Constants.BOOTSTRAP_COLLAPSE);
        	e.addClassName(Constants.BOOTSTRAP_COLLAPSED);
        }
        else {
        	switchClass(target, Constants.BOOTSTRAP_COLLAPSE, Constants.BOOTSTRAP_COLLAPSE_IN);
        	e.removeClassName(Constants.BOOTSTRAP_COLLAPSED);
        }
    }


	public static final native boolean hasClass(Element e, String c)/*-{
		return $wnd.$(e).hasClass(c);
	}-*/;
	public static final native String findClassByPrefix(Element e, String s, int group, String excludes)/*-{
		var reg = @usf.gwt.ui.bootstrap.client.core.JqueryUtils::createBootstrapStyleRegex(Ljava/lang/String;Ljava/lang/String;)(s, excludes);
		var res = reg.exec($wnd.$(e)[0].className);
		return res ? res[group] : null;
	}-*/;

	public static final native JavaScriptObject createBootstrapStyleRegex(final String prefix, String excludes) /*-{
		var e = excludes ? '(!?'+excludes.replace(/,/g,'|')+')':'';
		return new RegExp(e+'('+prefix+')-([\\w\-]+)',"g");
	}-*/;
		
	
	public static final native void addClass(Element e, String c)/*-{
		$wnd.$(e).addClass(c);
	}-*/;
	public static final native void removeClass(Element e, String c)/*-{
		$wnd.$(e).removeClass(c);
	}-*/;
	public static final native void switchClass(final Element e, final String className, final boolean a)/*-{
		a && $wnd.$(e).addClass(className);
		a || $wnd.$(e).removeClass(className);
	}-*/;
	public static final native void switchClass(final Element e, final String oldClass, final String newClass)/*-{
		$wnd.$(e).removeClass(oldClass).addClass(newClass);
	}-*/;
	public static final native void switchClassUnique(final Element e, final String c, final boolean a) /*-{
		$wnd.$(e).parent().find(e.tagName).removeClass(c);
		a && $wnd.$(e).addClass(c);
	}-*/;
	
	public static final native boolean hasAttrib(Element e, String c)/*-{
		return $wnd.$(e).is('['+ c +']');
	}-*/;
	public static final native void switchAttribute(final Element e, final String attr, final boolean a)/*-{
		$wnd.$(e).attr(attr, a ? '' : null);
	}-*/;
	
	public final static native String val(final Element e)/*-{
		return $wnd.$(e).val();
    }-*/;
	public final static native void val(final Element e, String text)/*-{
		$wnd.$(e).val(text);
    }-*/;
	public final static native String width(final Element e)/*-{
		return $wnd.$(e).width();
	}-*/;
	public final static native void width(final Element e, String text) /*-{
		$wnd.$(e).width(text);
	}-*/;
	
	public static final native void setButtonLoading(final Element e, final String state)/*-{
		$wnd.jQuery(e).button(state);
	}-*/;
	
	@Deprecated // in gwt 2.7  native java array conversion to js Array
	public static final String arrayToJsString(String ... values) {
		if(values == null) return null;
		StringBuilder str = new StringBuilder();
		for(int i=0; i<values.length-1; i++)
			str.append(values[i]).append(","); //Default js Array Separator
		if(values.length>0) str.append(values[values.length-1]);
		return str.toString();			
	}
	
	public static final native Element getElementById(String id)/*-{
		return $wnd.$(id)[0];
	}-*/;
    
	public static final native void jqueryConflict()/*-{
		$wnd.$.noConflict();
	}-*/;
}
