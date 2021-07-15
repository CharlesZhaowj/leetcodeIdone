package testpack;

public class StringTest {
    public static String reverseString(String s) {
        if(s == null || s.length() <= 1)
            return s;

        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "MaDongMei";
//        String s1 = reverseString(s);
//        System.out.println(s1);
        String a = "woshinidie";
        char[] chars = a.toCharArray();
        System.out.println(String.valueOf(chars));

    }
}
