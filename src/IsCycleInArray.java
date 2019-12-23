import java.util.HashSet;

public class IsCycleInArray {

    public static boolean isCycle(int[] inArr) {
        HashSet<Integer> visitedSet = new HashSet<Integer>();
        for (int i = 0; i < inArr.length; i++) {
            if (visitedSet.contains(inArr[i])) {
                return true;
            }
            else {
                visitedSet.add(inArr[i]);
            }
        }
        return false;
    }

    public static boolean isCycleSpace(int[] inArr) {
        boolean firstTime = true;
        int hRef = inArr[0];
        int tRef = inArr[0];
        for (;;) {
            if (hRef >= inArr.length || hRef == -1 || tRef >= inArr.length || tRef == -1) {
                return false;
            }
            else if ((!firstTime) && (hRef == tRef)) {
                return true;
            }

            hRef = inArr[hRef];
            if (hRef >= inArr.length || hRef == -1) {
                return false;
            }
            else if (hRef == tRef) {
                return true;
            }

            hRef = inArr[hRef];
            if (hRef == tRef) {
                return true;
            }

            tRef = inArr[tRef];
            if (firstTime) firstTime = false;
        }
    }

    public static void main(String[] args) {
        int[] inputArr = {1, 2, 4, 5, 3, 6, 3, 8};
        System.out.println("Is a Cycle: " + isCycleSpace(inputArr));
    }
}
