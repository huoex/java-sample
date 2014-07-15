package hex.com.test09.Enum;

public class demo {
	public static void main(String[] args) {
		System.out.println(colour.BLANK.title());
		System.out.println(colour.BLANK.value());
		colour c = colour.fromValue("1");
		System.out.println(c.title());
	}

}
