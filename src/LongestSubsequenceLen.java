import java.util.HashSet;
import java.util.Iterator;

public class LongestSubsequenceLen {

    public static int longestSubsequence(int[] inarr) {
        int lcsCount = 0;
        HashSet<Integer> seqSet = new HashSet<Integer>();
        for (int i = 0; i < inarr.length; i++) {
            seqSet.add(inarr[i]);
        }
        int currNum;
        int seqCount = 0;
        Iterator<Integer> itSet = seqSet.iterator();
        while (itSet.hasNext()) {
            currNum = itSet.next();
            if (!seqSet.contains(currNum-1)) {
                seqCount = 1;
                boolean nextElementFound = true;
                while (nextElementFound) {
                    currNum++;
                    if (seqSet.contains(currNum)) {
                        seqCount++;
                    }
                    else
                        nextElementFound = false;
                }
                if (seqCount > lcsCount)
                    lcsCount = seqCount;
            }
        }
        return lcsCount;
    }

    public static void main(String[] args) {
        int[] input = { 2, 1, 6, 9, 4, 3, 7, 8, 10 };
        System.out.println("LCS: " + longestSubsequence(input));
    }
}
