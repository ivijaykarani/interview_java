import java.util.HashSet;
import java.util.Iterator;

public class MatchAnySubstring2S {

    public static String twoStrings(String s1, String s2) {
        String s01 = s1;
        String s02 = s2;
        if (s2.length() < s1.length()) {
            s01 = s2;
            s02 = s1;
        }
        char[] s01Chars = s01.toCharArray();
        HashSet<Character> distinctChars = new HashSet<Character>();
        for (int i = 0; i < s01.length(); i++) {
            distinctChars.add(s01Chars[i]);
        }
        Iterator<Character> itSet = distinctChars.iterator();
        while (itSet.hasNext()) {
            if (s02.indexOf(itSet.next()) != -1) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println("Any matching string: " + twoStrings(s1, s2));
    }
}
