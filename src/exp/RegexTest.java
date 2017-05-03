package exp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) throws IOException {
		String regex = "Test";
		String str = "lkhslkhsklshlkshlskjlstestsljlskjslks";
		
		/**
		 * Regular expression in Java are by default case sensitive.
		 * it can be made insensitive by passing flag when compiling
		 * pattern
		 */
		Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);		
		Matcher m = p.matcher(str);
		System.out.println(m.find());
		// this is a test for GIt branch
				

	}
}
