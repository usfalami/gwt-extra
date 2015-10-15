package usf.gwt.bootstrap.ui.widget;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.IsWidget;

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
	
	interface StyleEnum {}
	
	 interface HasStyle<T extends StyleEnum> {
    	void setStyle(T style);
    	T getStyle();
    }
    interface HasIcon<T extends StyleEnum> {
    	void setIcon(T icon);
    	T getIcon();
    	Element getIconElement();
    }
    interface HasType<T extends StyleEnum> {
    	void setType(T type);
    	T getType();
    }
    interface HasState<T extends StyleEnum> {
    	void setState(T state);
    }
    interface HasText {
    	void setText(String text);
    	String getText();    	
    	Text getTextElement();
    }
        
    enum AlertStyles implements StyleEnum {
        SUCCESS, INFO, WARNING, DANGER;
    }
    enum AlignementStyles implements StyleEnum {
    	LEFT, RIGHT;
    }
    enum ButtonStyles implements StyleEnum {
        DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER, LINK;
    }   
    enum ButtonStates implements StyleEnum {
        RESET, LOADING;
    }
    enum ButtonTypes implements StyleEnum {
        BUTTON, SUBMIT, RESET;
    }
    enum ColumnOffsets implements StyleEnum {
    	MD_OFFSET_1, MD_OFFSET_2, MD_OFFSET_3, MD_OFFSET_4, MD_OFFSET_5, MD_OFFSET_6, 
    	MD_OFFSET_7, MD_OFFSET_8, MD_OFFSET_9, MD_OFFSET_10, MD_OFFSET_11, MD_OFFSET_12;
    }
    enum ColumnSizes implements StyleEnum {
    	MD_1, MD_2, MD_3, MD_4, MD_5, MD_6, 
    	MD_7, MD_8, MD_9, MD_10, MD_11, MD_12;
    }
    enum FormStyles implements StyleEnum {
        HORIZONTAL, INLINE;
    }
	enum LabelStyles implements StyleEnum {
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER, LINK;
	}
	enum NavStyles implements StyleEnum {	
		TABS, PILLS;
	}
	enum PanelFrameStyles implements StyleEnum {
		HEADING, BODY, FOOTER;
	}
	enum PanelStyles implements StyleEnum {
		DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER;
	}
	enum ProgressBarStyles implements StyleEnum {
		PRIMARY, SUCCESS, INFO, WARNING, DANGER;
	}
	enum ValidationStyles implements StyleEnum {
		SUCCESS, WARNING, ERROR;
	}
	
	enum IconTypes implements StyleEnum {
		
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
	}

}
