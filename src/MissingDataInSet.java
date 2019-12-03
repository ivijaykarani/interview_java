public class MissingDataInSet {

    public static int FindMissingValueForK(int[] inarr, int kterm) {
        int arrIdx = 1;
        int currentValue = inarr[0];
        int missedTerm = 0;
        while (missedTerm < kterm) {
            currentValue++;
            if (arrIdx < inarr.length) {
                if (currentValue == inarr[arrIdx]) {
                    arrIdx++;
                }
                else {
                    missedTerm++;
                }
            }
            else {
                missedTerm++;
            }
        }
        return currentValue;
    }

    public static int OptimizedValueForK(int[] inarr, int kterm) {
        int arrDiffInValues = inarr[inarr.length-1] - inarr[0] + 1;
        int missedTerms = arrDiffInValues - inarr.length;
        if (kterm > missedTerms) {
            return inarr[inarr.length-1] + (kterm - missedTerms);
        }
        // missed terms within the array
        int valueMissed = recursiveOptimizeK(inarr, 0, inarr.length-1, kterm);
        return valueMissed;
    }

    public static int recursiveOptimizeK(int[] inarr, int stIdx, int endIdx, int kterm) {
        int midIdx = (stIdx + endIdx) / 2;
        int arrDiffInValues = inarr[midIdx] - inarr[stIdx] + 1;
        int missedTerms = arrDiffInValues - (midIdx - stIdx + 1);
        if (kterm <= missedTerms) {
            if (midIdx - stIdx < 3) {
                int stV = inarr[stIdx];
                for (int i = stIdx+1; i <= midIdx; i++) {
                    if (inarr[i] != (stV+1))
                        return stV+1;
                    stV = inarr[i];
                }
                return stV+1;
            }
            else
                return recursiveOptimizeK(inarr, stIdx, midIdx, kterm);
        }
        else {
            int dTerms = kterm - missedTerms;
            return recursiveOptimizeK(inarr, midIdx+1, endIdx, dTerms);
        }
    }


    public static void main(String[] args) {
        /*Input: Array = [5, 6, 8, 9, 11], K = 1
        Output: 7

        Input Array = [5, 6, 8, 9, 11], K = 2
        Output: 10

        Input Array = [5, 6, 8, 9, 11], K = 5
        Output: 14
         */
        int[] inArray = {5, 6, 8, 9, 11};
        int k = 2;
        //int missingValue = FindMissingValueForK(inArray, k);
        int missingValue = OptimizedValueForK(inArray, k);
        System.out.println("Missing value = " + missingValue);
    }
}
