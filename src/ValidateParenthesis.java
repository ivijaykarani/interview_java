import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ValidateParenthesis {
    private static LinkedList<Character> stack = new LinkedList<Character>();
    private static HashSet<Character> openP = new HashSet<Character>();
    private static HashMap<Character, Character> matchP = new HashMap<Character, Character>();

    static {
        openP.add('(');
        openP.add('[');
        openP.add('{');
        matchP.put(')', '(');
        matchP.put('}', '{');
        matchP.put(']', '[');
    }

    public static boolean validate(String input) {
        char[] inChars = input.toCharArray();
        for(int i = 0; i < inChars.length; i++) {
            if (matchP.containsKey(inChars[i])) {
                char v = stack.peek();
                char m = matchP.get(inChars[i]);
                if (v != m)
                    return false;
                stack.pop();
            }
            else if (openP.contains(inChars[i])) {
                stack.push(inChars[i]);
            }
        }
        if (stack.size() > 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String str1 = "({}[])";
        System.out.println("Validation " + str1 + " : " + validate(str1));
        String str2 = "({]})";
        System.out.println("Validation " + str2 + " : " + validate(str2));
    }
}
