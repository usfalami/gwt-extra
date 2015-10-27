package usf.gwt.bootstrap.ui.core;

import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;

public final class Constants {

	public static interface BootstrapEnum {}
	
	public static interface StyleEnum extends BootstrapEnum {
		
		String value();
		String prefix();
		String[] excludes();
		
		class Utils {
			public static <T extends Enum<T> & StyleEnum> String fullValue(T enm){
				return enm == null ? null : enm.prefix() + BOOTSTRAP_STYLE_SEPARATOR + enm.value();
			}
			public static <T extends Enum<T> & StyleEnum> T valueOf(Class<T> clazz, String style){
				return style == null ? null : Enum.valueOf(clazz, style.replaceAll(BOOTSTRAP_STYLE_SEPARATOR, JAVA_STYLE_SEPARATOR).toUpperCase());
			}
		}
	}
	
	public static interface HasEnable {
		
		boolean isEnabled();
		void setEnabled(boolean enabled);
		Element getElement();
		
		class Utils {
			public static boolean isEnabled(HasEnable w) {
				return !JqueryUtils.hasClass(w.getElement(), BOOTSTRAP_DISABLED);
			}
			public static void setEnabled(HasEnable w, boolean enabled) {
				JqueryUtils.toggleClass(w.getElement(), BOOTSTRAP_DISABLED, !enabled);
			}
		}
	}
	
	public static interface HasFormControlEnable extends HasEnable {
		
		Element getBaseElement();
		
		class Utils {
			public static boolean isEnabled(HasFormControlEnable w) {
				return !JqueryUtils.hasAttrib(w.getBaseElement(), BOOTSTRAP_DISABLED);
			}
			public static void setEnabled(HasFormControlEnable w, boolean enabled) {
				JqueryUtils.toggleAttribute(w.getBaseElement(), BOOTSTRAP_DISABLED, !enabled);
			}
		}
	}
	
	public static interface HasActive {
		
		boolean isActive();
		void setActive(boolean active);
		Element getElement();
		
		class Utils {
			public static boolean isActive(HasActive w) {
				return JqueryUtils.hasClass(w.getElement(), BOOTSTRAP_ACTIVE);
			}
			public static void setActive(HasActive w, boolean value) {
				JqueryUtils.toggleClass(w.getElement(), BOOTSTRAP_ACTIVE, value);
			}
			public static void setActiveUnique(HasActive w, boolean value) {
				JqueryUtils.toggleClassUnique(w.getElement(), BOOTSTRAP_ACTIVE, value);
			}
		}
	}
	
	public static interface HasText {
		void setText(String text);
		String getText();
	}
	public static interface HasInputText extends HasText {

		Element getBaseElement();
		
		class Utils {
			public static void setText(HasInputText w, String text){
				JqueryUtils.val(w.getBaseElement(), text);
			}
			public static String getText(HasInputText w) {
				return JqueryUtils.val(w.getBaseElement());
			}
		}
	}
	public static interface HasNodeText extends HasText {

		Text getTextElement();
		
		class Utils {
			public static Text create(String text){
				return Document.get().createTextNode(text);
			}
			public static void setText(HasNodeText w, String text){
				w.getTextElement().setNodeValue(text);
			}
			public static String getText(HasNodeText w) {
				return w.getTextElement().getNodeValue();
			}
		}
	}
	
	public static interface CanCollapse {
		
		boolean isCollapsed();
		void setCollapsed(boolean collapse);
		Element getContainerElement();
		
		class Utils {
			public static boolean isCollapse(CanCollapse w) {
				return JqueryUtils.hasClass(w.getContainerElement(), BOOTSTRAP_COLLAPSE) || 
						!JqueryUtils.hasClass(w.getContainerElement(), BOOTSTRAP_COLLAPSE_IN);
			}
			public static void setCollapse(CanCollapse w, boolean collapse) {
			   if(collapse)
				   JqueryUtils.replaceClass(w.getContainerElement(), BOOTSTRAP_COLLAPSE_IN, BOOTSTRAP_COLLAPSE);
			   else
				   JqueryUtils.replaceClass(w.getContainerElement(), BOOTSTRAP_COLLAPSE, BOOTSTRAP_COLLAPSE_IN);
			}
		}
	}
	
	public static interface HasCollapser {
		
		void setTarget(String id);
		String getTarget();
		Element getBaseElement();
		
		class Utils {
			public static void setTarget(Element anchor, String target) {
		        anchor.setAttribute(Constants.ATTRIB_DATA_TARGET, Constants.JQUERY_ID_SELECTOR + target);
		        anchor.setAttribute(Constants.ATTRIB_DATA_TOGGLE, Constants.BOOTSTRAP_COLLAPSE);
			}
			public static void setTarget(HasCollapser w, String target) {
		        w.getBaseElement().setAttribute(Constants.ATTRIB_DATA_TARGET, Constants.JQUERY_ID_SELECTOR + target);
		        w.getBaseElement().setAttribute(Constants.ATTRIB_DATA_TOGGLE, Constants.BOOTSTRAP_COLLAPSE);
			}
			public static String getTarget(HasCollapser w){
				return w.getBaseElement().getAttribute(Constants.ATTRIB_DATA_TARGET);
			}
		}
	}
	
	
	public static interface HasAlign<T extends Enum<T> & StyleEnum> {

		void setAlign(T align);
		T getAlign();
		Element getElement();
		
		class Utils {
			public static <T extends Enum<T> & StyleEnum> void setAlign(HasAlign<T> w, T align) {
				JqueryUtils.toggleClass(w.getElement(), align);
			}
			public static <T extends Enum<T> & StyleEnum> T getAlign(HasAlign<T> w, Class<T> clazz) {
				return JqueryUtils.hasClass(w.getElement(), clazz);
			}
		}
	}
	
	public static interface HasStyle<T extends Enum<T> & StyleEnum> {
		
		void setStyle(T style);
		T getStyle();
		Element getStylElement();
		
		class Utils {

			public static boolean hasStyle(Element elem, String style){
		    	return JqueryUtils.hasClass(elem, style);
			}
			public static void setStyle(Element elem, String style, boolean set){
		    	JqueryUtils.toggleClass(elem, style, set);
			}
			public static void setStyleUnique(Element elem, String style, boolean set){
		    	JqueryUtils.toggleClassUnique(elem, style, set);
			}
			public static <T extends Enum<T> & StyleEnum> void setStyle(HasStyle<T> w, T style){
				JqueryUtils.toggleClass(w.getStylElement(), style);
			}
			public static <T extends Enum<T> & StyleEnum> T getStyle(HasStyle<T> w, Class<T> clazz) {
				return JqueryUtils.hasClass(w.getStylElement(), clazz);
			}
		}
	}
	public static interface HasIcon<T extends Enum<T> & StyleEnum> {
	    	
    	void setIcon(T icon);
    	T getIcon();
    	Element getIconElement();
    	void setIconElement(SpanElement e);
    	
    	class Utils {
    		public static SpanElement create(){
    			SpanElement s = Document.get().createSpanElement();
    			s.addClassName(BOOTSTRAP_ICON_PREFIX);
    			return s;
    		}
    		public static <T extends Enum<T> & StyleEnum> void setIcon(HasIcon<T> w, T icon){
    			if(icon == null || icon.name().equals(BOOTSTRAP_EMPTY_CONSTANT)){
    				if(w.getIconElement() != null)
    					w.getIconElement().removeFromParent();
    			}
    			else {
    				SpanElement e;
    				if(w.getIconElement() == null) 
        				w.setIconElement(e = create());
    				else 
    					e = w.getIconElement().cast();
        			JqueryUtils.toggleClass(e, icon);
    			}
    		}
    		public static <T extends Enum<T> & StyleEnum> T getIcon(HasIcon<T> w, Class<T> clazz) {
    			return JqueryUtils.hasClass(w.getIconElement(), clazz);
    		}
    	}
    }

	public static interface HasType<T> {
		void setType(T type);
		T getType();
	}
	public static interface HasState<T> {
		void setState(T state);
	}
	
	public static enum AlertStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		SUCCESS, INFO, WARNING, DANGER;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_ALERT_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum AlignementStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, LEFT, RIGHT;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_ALIGN_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum ButtonStyles implements StyleEnum {
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER, LINK;
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_BUTTON_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum ColumnOffsets implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		MD_OFFSET_1, MD_OFFSET_2, MD_OFFSET_3, MD_OFFSET_4, MD_OFFSET_5, MD_OFFSET_6, 
		MD_OFFSET_7, MD_OFFSET_8, MD_OFFSET_9, MD_OFFSET_10, MD_OFFSET_11, MD_OFFSET_12;
	    
		@Override public String value() {return this.name().toLowerCase().replaceFirst("_", "-");};
	    @Override public String prefix() {return BOOTSTRAP_COLUMN_PREFIX;}
	    @Override public String[] excludes() {return BOOTSTRAP_COLUMN_OFFSET_EXCLUDES;}
	}
	public static enum ColumnSizes implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		MD_1, MD_2, MD_3, MD_4, MD_5, MD_6, 
		MD_7, MD_8, MD_9, MD_10, MD_11, MD_12;
	
		@Override public String value() {return this.name().toLowerCase().replaceFirst("_", "-");};
	    @Override public String prefix() {return BOOTSTRAP_COLUMN_PREFIX;}
	    @Override public String[] excludes() {return BOOTSTRAP_COLUMN_SIZE_EXCLUDES;}
	}
	public static enum FormStyles implements StyleEnum {
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, HORIZONTAL, INLINE;
	
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_FORM_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum LabelStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER, LINK;
	    @Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_LABEL_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum NavStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		TABS, PILLS;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_NAV_PREFIX;}
	    @Override public String[] excludes() {return BOOTSTRAP_NAV_EXCLUDES;}
	}
	public static enum PanelFrameStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		HEADING, BODY, FOOTER;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_PANEL_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum PanelStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_PANEL_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum ProgressBarStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		PRIMARY, SUCCESS, INFO, WARNING, DANGER;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_PROGRESS_BAR_PREFIX;}
	    @Override public String[] excludes() {return BOOTSTRAP_PROGRESS_BAR_NAV_EXCLUDES;}
	}
	public static enum ValidationStyles implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		SUCCESS, WARNING, ERROR;
	    
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return BOOTSTRAP_VALIDATION_PREFIX;}
	    @Override public String[] excludes() {return null;}
	}
	public static enum ActiveStyles implements StyleEnum {
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		ACTIVE;
		
		@Override public String value() {return this.name().toLowerCase();};
	    @Override public String prefix() {return value();}
	    @Override public String[] excludes() {return null;}
	}
	public static enum ButtonStates implements BootstrapEnum {
		RESET, LOADING;
	}
	public static enum ButtonTypes implements BootstrapEnum {
		BUTTON, SUBMIT, RESET;
	}
	public static enum IconTypes implements StyleEnum {
		
		NONE{@Override public String value() {return BOOTSTRAP_EMPTY_STYLE;}}, 
		GLASS, MUSIC, SEARCH, ENVELOPE_O, HEART, STAR, STAR_O, USER, FILM, TH_LARGE, TH, TH_LIST, CHECK, REMOVE, CLOSE, TIMES, SEARCH_PLUS, SEARCH_MINUS, POWER_OFF, 
		SIGNAL, GEAR, COG, TRASH_O, HOME, FILE_O, CLOCK_O, ROAD, DOWNLOAD, ARROW_CIRCLE_O_DOWN, ARROW_CIRCLE_O_UP, INBOX, PLAY_CIRCLE_O, ROTATE_RIGHT, REPEAT, REFRESH, 
		LIST_ALT, LOCK, FLAG, HEADPHONES, VOLUME_OFF, VOLUME_DOWN, VOLUME_UP, QRCODE, BARCODE, TAG, TAGS, BOOK, BOOKMARK, PRINT, CAMERA, FONT, BOLD, ITALIC, TEXT_HEIGHT, 
		TEXT_WIDTH, ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, LIST, DEDENT, OUTDENT, INDENT, VIDEO_CAMERA, PHOTO, IMAGE, PICTURE_O, PENCIL, MAP_MARKER, ADJUST, 
		TINT, EDIT, PENCIL_SQUARE_O, SHARE_SQUARE_O, CHECK_SQUARE_O, ARROWS, STEP_BACKWARD, FAST_BACKWARD, BACKWARD, PLAY, PAUSE, STOP, FORWARD, FAST_FORWARD, STEP_FORWARD, 
		EJECT, CHEVRON_LEFT, CHEVRON_RIGHT, PLUS_CIRCLE, MINUS_CIRCLE, TIMES_CIRCLE, CHECK_CIRCLE, QUESTION_CIRCLE, INFO_CIRCLE, CROSSHAIRS, TIMES_CIRCLE_O, CHECK_CIRCLE_O, 
		BAN, ARROW_LEFT, ARROW_RIGHT, ARROW_UP, ARROW_DOWN, MAIL_FORWARD, SHARE, EXPAND, COMPRESS, PLUS, MINUS, ASTERISK, EXCLAMATION_CIRCLE, GIFT, LEAF, FIRE, EYE, EYE_SLASH, 
		WARNING, EXCLAMATION_TRIANGLE, PLANE, CALENDAR, RANDOM, COMMENT, MAGNET, CHEVRON_UP, CHEVRON_DOWN, RETWEET, SHOPPING_CART, FOLDER, FOLDER_OPEN, ARROWS_V, ARROWS_H, 
		BAR_CHART_O, BAR_CHART, TWITTER_SQUARE, FACEBOOK_SQUARE, CAMERA_RETRO, KEY, GEARS, COGS, COMMENTS, THUMBS_O_UP, THUMBS_O_DOWN, STAR_HALF, HEART_O, SIGN_OUT, 
		LINKEDIN_SQUARE, THUMB_TACK, EXTERNAL_LINK, SIGN_IN, TROPHY, GITHUB_SQUARE, UPLOAD, LEMON_O, PHONE, SQUARE_O, BOOKMARK_O, PHONE_SQUARE, TWITTER, FACEBOOK, GITHUB, 
		UNLOCK, CREDIT_CARD, RSS, HDD_O, BULLHORN, BELL, CERTIFICATE, HAND_O_RIGHT, HAND_O_LEFT, HAND_O_UP, HAND_O_DOWN, ARROW_CIRCLE_LEFT, ARROW_CIRCLE_RIGHT, ARROW_CIRCLE_UP, 
		ARROW_CIRCLE_DOWN, GLOBE, WRENCH, TASKS, FILTER, BRIEFCASE, ARROWS_ALT, GROUP, USERS, CHAIN, LINK, CLOUD, FLASK, CUT, SCISSORS, COPY, FILES_O, PAPERCLIP, SAVE, FLOPPY_O, 
		SQUARE, NAVICON, REORDER, BARS, LIST_UL, LIST_OL, STRIKETHROUGH, UNDERLINE, TABLE, MAGIC, TRUCK, PINTEREST, PINTEREST_SQUARE, GOOGLE_PLUS_SQUARE, GOOGLE_PLUS, MONEY, 
		CARET_DOWN, CARET_UP, CARET_LEFT, CARET_RIGHT, COLUMNS, UNSORTED, SORT, SORT_DOWN, SORT_DESC, SORT_UP, SORT_ASC, ENVELOPE, LINKEDIN, ROTATE_LEFT, UNDO, LEGAL, GAVEL, 
		DASHBOARD, TACHOMETER, COMMENT_O, COMMENTS_O, FLASH, BOLT, SITEMAP, UMBRELLA, PASTE, CLIPBOARD, LIGHTBULB_O, EXCHANGE, CLOUD_DOWNLOAD, CLOUD_UPLOAD, USER_MD, STETHOSCOPE,
		SUITCASE, BELL_O, COFFEE, CUTLERY, FILE_TEXT_O, BUILDING_O, HOSPITAL_O, AMBULANCE, MEDKIT, FIGHTER_JET, BEER, H_SQUARE, PLUS_SQUARE, ANGLE_DOUBLE_LEFT, ANGLE_DOUBLE_RIGHT, 
		ANGLE_DOUBLE_UP, ANGLE_DOUBLE_DOWN, ANGLE_LEFT, ANGLE_RIGHT, ANGLE_UP, ANGLE_DOWN, DESKTOP, LAPTOP, TABLET, MOBILE_PHONE, MOBILE, CIRCLE_O, QUOTE_LEFT, QUOTE_RIGHT, 
		SPINNER, CIRCLE, MAIL_REPLY, REPLY, GITHUB_ALT, FOLDER_O, FOLDER_OPEN_O, SMILE_O, FROWN_O, MEH_O, GAMEPAD, KEYBOARD_O, FLAG_O, FLAG_CHECKERED, TERMINAL, CODE, 
		MAIL_REPLY_ALL, REPLY_ALL, STAR_HALF_EMPTY, STAR_HALF_FULL, STAR_HALF_O, LOCATION_ARROW, CROP, CODE_FORK, UNLINK, CHAIN_BROKEN, QUESTION, INFO, EXCLAMATION, 
		SUPERSCRIPT, SUBSCRIPT, ERASER, PUZZLE_PIECE, MICROPHONE, MICROPHONE_SLASH, SHIELD, CALENDAR_O, FIRE_EXTINGUISHER, ROCKET, MAXCDN, CHEVRON_CIRCLE_LEFT, 
		CHEVRON_CIRCLE_RIGHT, CHEVRON_CIRCLE_UP, CHEVRON_CIRCLE_DOWN, HTML5, CSS3, ANCHOR, UNLOCK_ALT, BULLSEYE, ELLIPSIS_H, ELLIPSIS_V, RSS_SQUARE, PLAY_CIRCLE, TICKET, 
		MINUS_SQUARE, MINUS_SQUARE_O, LEVEL_UP, LEVEL_DOWN, CHECK_SQUARE, PENCIL_SQUARE, EXTERNAL_LINK_SQUARE, SHARE_SQUARE, COMPASS, TOGGLE_DOWN, CARET_SQUARE_O_DOWN, 
		TOGGLE_UP, CARET_SQUARE_O_UP, TOGGLE_RIGHT, CARET_SQUARE_O_RIGHT, EURO, EUR, GBP, DOLLAR, USD, RUPEE, INR, CNY, RMB, YEN, JPY, RUBLE, ROUBLE, RUB, WON, KRW, BITCOIN, 
		BTC, FILE, FILE_TEXT, SORT_ALPHA_ASC, SORT_ALPHA_DESC, SORT_AMOUNT_ASC, SORT_AMOUNT_DESC, SORT_NUMERIC_ASC, SORT_NUMERIC_DESC, THUMBS_UP, THUMBS_DOWN, YOUTUBE_SQUARE, 
		YOUTUBE, XING, XING_SQUARE, YOUTUBE_PLAY, DROPBOX, STACK_OVERFLOW, INSTAGRAM, FLICKR, ADN, BITBUCKET, BITBUCKET_SQUARE, TUMBLR, TUMBLR_SQUARE, LONG_ARROW_DOWN, 
		LONG_ARROW_UP, LONG_ARROW_LEFT, LONG_ARROW_RIGHT, APPLE, WINDOWS, ANDROID, LINUX, DRIBBBLE, SKYPE, FOURSQUARE, TRELLO, FEMALE, MALE, GITTIP, SUN_O, MOON_O, ARCHIVE, BUG, 
		VK, WEIBO, RENREN, PAGELINES, STACK_EXCHANGE, ARROW_CIRCLE_O_RIGHT, ARROW_CIRCLE_O_LEFT, TOGGLE_LEFT, CARET_SQUARE_O_LEFT, DOT_CIRCLE_O, WHEELCHAIR, VIMEO_SQUARE, 
		TURKISH_LIRA, TRY, PLUS_SQUARE_O, SPACE_SHUTTLE, SLACK, ENVELOPE_SQUARE, WORDPRESS, OPENID, INSTITUTION, BANK, UNIVERSITY, MORTAR_BOARD, GRADUATION_CAP, YAHOO, GOOGLE, 
		REDDIT, REDDIT_SQUARE, STUMBLEUPON_CIRCLE, STUMBLEUPON, DELICIOUS, DIGG, PIED_PIPER, PIED_PIPER_ALT, DRUPAL, JOOMLA, LANGUAGE, FAX, BUILDING, CHILD, PAW, SPOON, CUBE, 
		CUBES, BEHANCE, BEHANCE_SQUARE, STEAM, STEAM_SQUARE, RECYCLE, AUTOMOBILE, CAR, CAB, TAXI, TREE, SPOTIFY, DEVIANTART, SOUNDCLOUD, DATABASE, FILE_PDF_O, FILE_WORD_O, 
		FILE_EXCEL_O, FILE_POWERPOINT_O, FILE_PHOTO_O, FILE_PICTURE_O, FILE_IMAGE_O, FILE_ZIP_O, FILE_ARCHIVE_O, FILE_SOUND_O, FILE_AUDIO_O, FILE_MOVIE_O, FILE_VIDEO_O, 
		FILE_CODE_O, VINE, CODEPEN, JSFIDDLE, LIFE_BOUY, LIFE_BUOY, LIFE_SAVER, SUPPORT, LIFE_RING, CIRCLE_O_NOTCH, RA, REBEL, GE, EMPIRE, GIT_SQUARE, GIT, HACKER_NEWS, 
		TENCENT_WEIBO, QQ, WECHAT, WEIXIN, SEND, PAPER_PLANE, SEND_O, PAPER_PLANE_O, HISTORY, CIRCLE_THIN, HEADER, PARAGRAPH, SLIDERS, SHARE_ALT, SHARE_ALT_SQUARE, BOMB, 
		SOCCER_BALL_O, FUTBOL_O, TTY, BINOCULARS, PLUG, SLIDESHARE, TWITCH, YELP, NEWSPAPER_O, WIFI, CALCULATOR, PAYPAL, GOOGLE_WALLET, CC_VISA, CC_MASTERCARD, CC_DISCOVER, 
		CC_AMEX, CC_PAYPAL, CC_STRIPE, BELL_SLASH, BELL_SLASH_O, TRASH, COPYRIGHT, AT, EYEDROPPER, PAINT_BRUSH, BIRTHDAY_CAKE, AREA_CHART, PIE_CHART, LINE_CHART, LASTFM, 
		LASTFM_SQUARE, TOGGLE_OFF, TOGGLE_ON, BICYCLE, BUS, IOXHOST, ANGELLIST, CC, SHEKEL, SHEQEL, ILS, MEANPATH;			
	
	    @Override public String value() {return this.name().toLowerCase().replaceAll("_", "-");};
	    @Override public String prefix() {return BOOTSTRAP_ICON_PREFIX;}
	    @Override public String[] excludes() {return null;}
	
	}
	public final static String ATTRIB_AUTOCOMPLETE = "autocomplete";
	public final static String ATTRIB_DATA_LOADING_TEXT = "data-loading-text";
	public final static String ATTRIB_DATA_PROVIDE = "data-provide";
	public final static String ATTRIB_DATA_TARGET = "data-target";
	public final static String ATTRIB_DATA_TOGGLE = "data-toggle";
	public final static String ATTRIB_FOR = "for";
	public final static String ATTRIB_FORM = "form";
	public final static String ATTRIB_MULTIPLE = "multiple";
	public final static String ATTRIB_PLACEHOLDER = "placeholder";
	public final static String ATTRIB_TYPE = "type";
	public final static String ATTRIB_ROLE = "role";

	public static final char JQUERY_ID_SELECTOR = '#';
	public static final String BOOTSTRAP_STYLE_SEPARATOR = "-";
	public static final String JAVA_STYLE_SEPARATOR = "_";
	public static final String BOOTSTRAP_ACTIVE = "active";
	public static final String BOOTSTRAP_COLLAPSE = "collapse";
    public static final String BOOTSTRAP_COLLAPSED = "collapsed";
    public static final String BOOTSTRAP_COLLAPSE_IN = "collapse in";
	public static final String BOOTSTRAP_DISABLED = "disabled";
    public static final String BOOTSTRAP_TYPEAHEAD = "typeahead";
    
    public static final String VALUE_ON = "on";
    public static final String VALUE_OFF = "off";
    public static final String VALUE_PRESENTATION = "presentation";
    public static final String VALUE_JAVA_SCRIPT_EMPTY_FUNCTION = "javascript:;";

	public static final String GWT_UI_ID_PREFIX = "ui";
	public static final String GWT_BOOTSTRAP = "gwt-bootstrap-";
	public static final String GWT_BOOTSTRAP_BADGE = GWT_BOOTSTRAP + "badge";
	public static final String GWT_BOOTSTRAP_NAV = GWT_BOOTSTRAP + "nav";
	public static final String GWT_BOOTSTRAP_SUB_NAV = GWT_BOOTSTRAP + "sub-nav";
	public static final String GWT_BOOTSTRAP_NAV_ITEM = GWT_BOOTSTRAP + "nav-item";
	
    public static final String BOOTSTRAP_ALERT_PREFIX = "alert";
	public static final String BOOTSTRAP_ALIGN_PREFIX = "pull";
	public static final String BOOTSTRAP_BUTTON_PREFIX = "btn";
	public static final String BOOTSTRAP_COLUMN_PREFIX = "col";
	public static final String[] BOOTSTRAP_COLUMN_SIZE_EXCLUDES = {"^col-md-offset"};
	public static final String[] BOOTSTRAP_COLUMN_OFFSET_EXCLUDES = {"^md-\\d"};
    public static final String BOOTSTRAP_FORM_PREFIX = "form";
	public static final String BOOTSTRAP_ICON_PREFIX ="fa";
	public static final String BOOTSTRAP_LABEL_PREFIX = "label";
	public static final String BOOTSTRAP_NAV_PREFIX = "nav";
	public static final String BOOTSTRAP_NAV_STACKED_STYLE = "nav-stacked";	
	public static final String[] BOOTSTRAP_NAV_EXCLUDES = {BOOTSTRAP_NAV_STACKED_STYLE};
	public static final String BOOTSTRAP_PANEL_PREFIX = "panel";
	public static final String BOOTSTRAP_PROGRESS_BAR_PREFIX = "progress-bar";
	public static final String BOOTSTRAP_PROGRESS_BAR_STRIPED_STYLE = "progress-bar-striped";
	public static final String[] BOOTSTRAP_PROGRESS_BAR_NAV_EXCLUDES = {BOOTSTRAP_PROGRESS_BAR_STRIPED_STYLE};
	public static final String BOOTSTRAP_VALIDATION_PREFIX = "has";
	
	public static final  String DEFAULT_FORM_CONTROL_STYLE = "form-control";
	public static final String FORM_GROUP_STYLE = "form-group";
	public static final String DEFAULT_ROW_STYLE = "row";
	public static final String DEFAULT_GROUP_STYLE = "list-group";
	public static final String DEGAULT_GROUP_ITEM_STYLE = "list-group-item";
	public static final String DEFAULT_INPUT_GROUP_STYLE = "input-group";
	public static final String DEFAULT_GROUP_ADD_ON_STYLE = "input-group-addon";
	public static final String DEFAULT_LABEL_STYLE = "control-label";
	public static final String DEFAUL_BADGE_STYLE = "badge";
	
	public static final String BOOTSTRAP_EMPTY_CONSTANT = "NONE";
	public static final String BOOTSTRAP_EMPTY_STYLE = " ";
}
