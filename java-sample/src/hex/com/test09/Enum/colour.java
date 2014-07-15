package hex.com.test09.Enum;

import java.util.HashMap;
import java.util.Map;

public enum colour{
	RED("1", "红色"), 
	GREEN("2", "绿色"), 
	BLANK("3", "白色"), 
	YELLO("4", "黄色");  

	private static final Map<String, colour> MAP;
	private final String VALUE;
	private final String TITLE;

	static {
		MAP = new HashMap<String, colour>();
		MAP.put("1", RED);
		MAP.put("2", GREEN);
		MAP.put("3", BLANK);
		MAP.put("4", YELLO);
	}

	colour(final String value, final String title) {
		this.VALUE = value;
		this.TITLE = title;
	}

	public String value() {
		return VALUE;
	}

	public String title() {
		return TITLE;
	}

	public static colour fromValue(String value) {
		colour val = (colour) MAP.get(value);
		return val;
	}
}