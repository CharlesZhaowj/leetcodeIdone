package testpack;

import java.util.regex.*;

public class RegexTest {
    public static void main(String[] args) {
        String a = "www.qq.com";
        String b = "www.abc.com";

        String pattern = ".*[abc|qq].*";

        System.out.println(Pattern.matches(pattern, a));
        System.out.println(Pattern.matches(pattern, b));
    }

}
