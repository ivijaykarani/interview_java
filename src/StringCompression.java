public class StringCompression {

    public static String compressInputString(String inStr) {
        char[] inChars = inStr.toCharArray();
        String out = "";
        char prevChar = inChars[0];
        int charCount = 1;
        for (int i = 1; i < inChars.length; i++) {
            if (inChars[i] == prevChar) {
                charCount++;
            }
            else {
                out += "" + prevChar + charCount;
                prevChar = inChars[i];
                charCount = 1;
            }
        }
        out += "" + prevChar + charCount;
        return out;
    }

    public static void main(String[] args) {
        String inStr1 = "a";
        String inStr2 = "aaa";
        String inStr3 = "aaabbb";
        String inStr4 = "aaabccc";

        System.out.println(compressInputString(inStr4));
    }
}
