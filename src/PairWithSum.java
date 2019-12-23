import java.util.HashSet;

public class PairWithSum {

    public static void findMatchingPairWithSum(int[] inArr, int sum) {
        HashSet<Integer> valueSet = new HashSet<Integer>();
        for (int i = 0; i < inArr.length; i++) {
            int pairValue = sum - inArr[i];
            if (valueSet.contains(pairValue)) {
                System.out.println("[ " + pairValue + " " + inArr[i] + " ]");
            }
            else {
                valueSet.add(inArr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 4, 1, 9, 7 };
        findMatchingPairWithSum(input, 9);
    }
}
