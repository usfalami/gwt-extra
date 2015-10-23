package usf.gwt.bootstrap.ui.widget;

import usf.gwt.bootstrap.ui.core.Constants;
import usf.gwt.bootstrap.ui.js.JqueryUtils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface Bootstrap extends IsWidget {
	
	void setId(String id);
	String getId();
	Element getBaseElement();
	
	interface AttachWidget {}
	interface InputGroupAddOn {}

	interface Collapser {
		void setTarget(String target);
		Element getBaseElement();
	}
	
	interface BootstrapEnum {
		
	}
	interface StyleEnum extends BootstrapEnum {
		String value();
		String fullValue();
	}
	
	 interface HasStyle<T extends Enum<T> & StyleEnum> {
    	
		 void setStyle(T style);
    	T getStyle();
    	String getPrimaryStyle();
    	
    	class Utils {
    		public static <T extends Enum<T> & StyleEnum, E extends Widget & HasStyle<T>> void setStyle(E w, T style, String... excludes){
    			if(w.getElement() != null)
    				JqueryUtils.switchClass(w.getElement(), w.getPrimaryStyle(), style, excludes);
    		}
    		public static <T extends Enum<T> & StyleEnum, E extends Widget & HasStyle<T>> T getStyle(E w, Class<T> clazz, String... excludes) {
    			
    			return w.getElement() == null ? null : 
    					JqueryUtils.hasClass(w.getElement(), w.getPrimaryStyle(), clazz, excludes);
    		}
    		public static boolean hasStyle(Element elem, String style){
    	    	return JqueryUtils.hasClass(elem, style);
    		}
    		public static void setStyle(Element elem, String style, boolean set){
    	    	JqueryUtils.switchClass(elem, style, set);
    		}
    	}
    }
    interface HasIcon<T extends Enum<T> & StyleEnum> {
    	
    	void setIcon(T icon);
    	T getIcon();
    	Element getIconElement();
    	
    	class Utils {
    		public static SpanElement create(){
    			SpanElement s = Document.get().createSpanElement();
    			s.addClassName(Constants.BOOTSTRAP_ICON_PREFIX);
    			s.setInnerHTML("&nbsp;&nbsp;");
    			return s;
    		}
    		public static <T extends Enum<T> & StyleEnum> void setIcon(HasIcon<T> w, T icon){
    			JqueryUtils.switchClass(w.getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, icon);
    		}
    		public static <T extends Enum<T> & StyleEnum> T getIcon(HasIcon<T> w, Class<T> clazz) {
    			return w.getIconElement() == null ? null : 
    					JqueryUtils.hasClass(w.getIconElement(), Constants.BOOTSTRAP_ICON_PREFIX, clazz);
    		}
    	}
    }
    interface HasText {
    	void setText(String text);
    	String getText();    	
    	Text getTextElement();
    	class Utils {
    		public static Text create(String text){
    			return Document.get().createTextNode(text);
    		}
    		public static void setText(HasText w, String text){
    			w.getTextElement().setNodeValue(text);
    		}
    		public static String getText(HasText w) {
    			return w.getTextElement().getNodeValue();
    		}
    	}
    }
    interface HasType<T extends Enum<T> & BootstrapEnum> {
    	void setType(T type);
    	T getType();
    }
    interface HasState<T extends Enum<T> & BootstrapEnum> {
    	void setState(T state);
    }
        
    enum AlertStyles implements StyleEnum {
		
    	NONE{@Override public String value() {return "";}}, 
		SUCCESS, INFO, WARNING, DANGER;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_ALERT_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
    }
    
    enum AlignementStyles implements StyleEnum {
		
    	NONE{@Override public String value() {return "";}}, LEFT, RIGHT;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_ALIGN_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
    }
    
    enum ButtonStyles implements StyleEnum {
		NONE{@Override public String value() {return "";}}, 
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER, LINK;
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_BUTTON_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
    } 
    
    enum ColumnOffsets implements StyleEnum {
		
    	NONE{@Override public String value() {return "";}}, 
		MD_OFFSET_1, MD_OFFSET_2, MD_OFFSET_3, MD_OFFSET_4, MD_OFFSET_5, MD_OFFSET_6, 
    	MD_OFFSET_7, MD_OFFSET_8, MD_OFFSET_9, MD_OFFSET_10, MD_OFFSET_11, MD_OFFSET_12;
        
		@Override public String value() {return this.name().toLowerCase().replaceFirst("_", "-");};
        @Override public String fullValue() {return Constants.BOOTSTRAP_BUTTON_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
    }
    
    enum ColumnSizes implements StyleEnum {
		
    	NONE{@Override public String value() {return "";}}, 
		MD_1, MD_2, MD_3, MD_4, MD_5, MD_6, 
    	MD_7, MD_8, MD_9, MD_10, MD_11, MD_12;
       
    	@Override public String value() {return this.name().toLowerCase().replaceFirst("_", "-");};
        @Override public String fullValue() {return Constants.BOOTSTRAP_BUTTON_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
    }
    
    enum FormStyles implements StyleEnum {
		NONE{@Override public String value() {return "";}}, HORIZONTAL, INLINE;
       
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_FORM_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
    }
    
	enum LabelStyles implements StyleEnum {
		
		NONE{@Override public String value() {return "";}}, 
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER, LINK;
        @Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_LABEL_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	}
	
	enum NavStyles implements StyleEnum {
		NONE{@Override public String value() {return "";}}, 
		TABS, PILLS;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_NAV_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	}
	
	enum PanelFrameStyles implements StyleEnum {
		
		NONE{@Override public String value() {return "";}}, 
		HEADING, BODY, FOOTER;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_PANEL_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	}
	
	enum PanelStyles implements StyleEnum {
		
		NONE{@Override public String value() {return "";}}, 
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_PANEL_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	}
	
	enum ProgressBarStyles implements StyleEnum {
		
		NONE{@Override public String value() {return "";}}, 
		PRIMARY, SUCCESS, INFO, WARNING, DANGER;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_PROGRESS_BAR_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	}
	
	enum ValidationStyles implements StyleEnum {
		
		NONE{@Override public String value() {return "";}}, 
		SUCCESS, WARNING, ERROR;
        
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return Constants.BOOTSTRAP_VALIDATION_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	}
	
	enum ActiveStyles implements StyleEnum {
		NONE{@Override public String value() {return "";}}, 
		ACTIVE;
		
		@Override public String value() {return this.name().toLowerCase();};
        @Override public String fullValue() {return value();}
	}

    
    enum ButtonStates implements BootstrapEnum {
		RESET, LOADING;
    }
    enum ButtonTypes implements BootstrapEnum {
		BUTTON, SUBMIT, RESET;
    }
	
	enum IconTypes implements StyleEnum {
		
		NONE{@Override public String value() {return "";}}, 
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
        @Override public String fullValue() {return Constants.BOOTSTRAP_ICON_PREFIX + Constants.BOOTSTRAP_STYLE_SEPARATOR + value();}
	
	}

}
