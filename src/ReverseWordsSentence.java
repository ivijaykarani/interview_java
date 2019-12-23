public class ReverseWordsSentence {

    public static String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        String revSentence = "";
        for (int i = words.length-1; i >= 0; i--) {
            revSentence += words[i];
            if (i > 0)
                revSentence += " ";
        }
        return revSentence;
    }

    public static String revSentence(String sentence) {
        char[] letters = sentence.toCharArray();
        String rSentence = "";
        int endIdx = letters.length - 1;
        for (int i = letters.length-1; i >= 0; i--) {
            if (i == 0) {
                int wlen = endIdx - i;
                String word = new String(letters, i, wlen);
                rSentence = rSentence + " " + word;
            }
            else if (letters[i] == ' ') {
                if (i == endIdx+1) {
                    rSentence = " " + rSentence;
                }
                else {
                    int startIdx = i + 1;
                    int wlen = endIdx - startIdx + 1;
                    String word = new String(letters, startIdx, wlen);
                    if (i == letters.length - 1)
                        rSentence = word;
                    else
                        rSentence = rSentence + " " + word;
                    endIdx = i;
                }
            }
        }
        return rSentence;
    }

    public static String reverseEntireSentence(String sentence) {
        char[] sentenceChars = sentence.toCharArray();
        for (int i = 0, j = sentenceChars.length-1; i < j; i++, j--) {
            char t = sentenceChars[i];
            sentenceChars[i] = sentenceChars[j];
            sentenceChars[j] = t;
        }
        return new String(sentenceChars);
    }

    public static void main(String[] args) {
        String sentence = "I love California";
        //System.out.println("rev sentence: " + reverseSentence(sentence));
        System.out.println("rev sentence: " + reverseEntireSentence(sentence));
    }
}
