package hex.com.test16.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {

		// 将字符串"a2389a"中的数字用*替换，\d 表示“0--9”数字
		p("a2389a".replaceAll("\\d", "*"));
		// matches()判断字符串是否匹配某个表达式，"."表示任何一个字符
		regex("abc", "...");
		// 将任何是a--z的字符串长度为3的字符匹配
		regex("abc", "[a-z]{3}");

		// 初步认识. * + ?
		// . 任何字符
		regex("a", ".");// true
		// a? a一次或一次也没有
		regex("aaaa", "a?");// false
		regex("", "a?");// true
		regex("a", "a?");// true
		// a* a零次或多次
		regex("aaaa", "a*");// true
		regex("", "a*");// true
		// a+ a一次或多次
		regex("aaaa", "a+");// true
		// a{n} a恰好 n 次
		// a{n,} a至少n次
		// a{n,m} a至少n次，但是不超过m次
		regex("1232435463685899", "\\d{3,100}");// true
		regex("192.168.0.1", "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");// false
		regex("192", "[0-2][0-9][0-9]");// true

		// [abc] a、b 或 c（简单类）
		// [^abc] 任何字符，除了 a、b 或 c（否定）
		// [a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围）
		// [a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集）
		// [a-z&&[def]] d、e 或 f（交集）
		// [a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去）
		// [a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去）

		// 范围
		System.out.println("***范围***");
		regex("a", "[abc]");// true
		regex("a", "[^abc]");// false
		regex("A", "[a-zA-Z]");// true
		regex("A", "[a-z]|[A-Z]");// true
		regex("A", "[a-z[A-Z]]");// true
		regex("R", "[A-Z&&[RFG]]");// true

		// \d 数字：[0-9]
		// \D 非数字： [^0-9]
		// \s 空白字符：[ \t\n\x0B\f\r]
		// \S 非空白字符：[^\s]
		// \w 单词字符：[a-zA-Z_0-9]
		// \W 非单词字符：[^\w]
		// 认识\s \w \d \
		System.out.println("***认识\\s \\w \\d \\***");
		regex("\n\r\t", "\\s(3)");// false
		regex(" ", "\\S");// false
		regex("a_8 ", "\\w(3)");// false
		regex("abc888&^#%", "[a-z]{1,3}\\d+[&^#%]+");// true
		regex("\\", "\\\\");// true

		// 边界匹配器
		// ^ 行的开头
		// $ 行的结尾
		// \b 单词边界
		// \B 非单词边界
		// \A 输入的开头
		// \G 上一个匹配的结尾
		// \Z 输入的结尾，仅用于最后的结束符（如果有的话）
		// \z 输入的结尾

		// 边界匹配
		System.out.println("***边界匹配***");
		regex("hello sir", "^h.*");// true
		regex("hello sir", ".*ir$");// true
		regex("hello sir", "^h[a-z]{1,3}o\\b.*");// true
		regex("hellosir", "^h[a-z]{1,3}o\\b.*");// false
		// 空白行:一个或多个(空白并且非换行符)开头，并以换行符结尾
		regex(" \n", "^[\\s&&[^\\n]]*\\n$");// true
		
		// 自定义能够匹配 '多种字符' 的表达式
		// 使用方括号 [ ] 包含一系列字符，能够匹配其中任意一个字符。
		// 用 [^ ] 包含一系列字符，则能够匹配其中字符之外的任意一个字符。同样的道理，
		// 虽然可以匹配其中任意一个，但是只能是一个，不是多个。
		
		regex("a", "[ab5@]");
		
		find("abc123","[abc][abc]");
		find("It costs $12.5","\\d+\\.?\\d*");
		// 贪婪匹配：a.*b匹配所有
		find("aabbacbaeb","a.*b");
		// 懒惰匹配：a.*?b配以匹配aab,acb,aeb
		find("aabbacbaeb","a.*?b");
		// 侵占匹配：a.*+b则所有字符串都被.*优先匹配并吃掉，结果b无法匹配出现匹配为空
		find("aabbacbaeb","a.*+b");
		
		find("<a href=\"http://abc.com\"><img src=\"def\" name=\"123\" /></a>","<a\\shref=\"(http://[A-Za-z0-9\\./]+?)\"><img\\ssrc=\"(.*?)\"\\sname=\"(.*?)\"\\s/></a>");
		

	}

	public static void p(Object o) {
		System.out.println(o.toString() + ":" + o);
	}

	public static void regex(String s, String p) {
		// 模式类：字符串要被匹配的这么一个模式，该模式本身已经被编译过，使用的话效率要高很多。
		Pattern pattern = Pattern.compile(p);
		// 匹配类：这个模式匹配某个字符串所产生的结果，这个结果可能会有很多个。
		Matcher matcher = pattern.matcher(s);
		System.out.println("\"" + s + "\"" + ".matches(\"" + p + "\")" + ":"
				+ matcher.matches());
	}
	
	public static void find(String s, String p) {
		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find())
			System.out.println("\"" + s + "\"" + ".find(\"" + p + "\")" + ":"
					+ matcher.group());
	}
}