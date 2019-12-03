public class Median2SortedArrays {

    public static double FindMedianArrays(int[] arr1, int[] arr2) {
        int[] mergeList = new int[arr1.length+arr2.length];
        int iIdx = 0;
        int jIdx = 0;
        int mIdx = 0;
        while (iIdx < arr1.length && jIdx < arr2.length) {
            if (arr1[iIdx] < arr2[jIdx]) {
                mergeList[mIdx] = arr1[iIdx++];
            }
            else {
                mergeList[mIdx] = arr2[jIdx++];
            }
            mIdx++;
        }
        while (iIdx < arr1.length) {
            mergeList[mIdx++] = arr1[iIdx++];
        }
        while (jIdx < arr2.length) {
            mergeList[mIdx++] = arr2[jIdx++];
        }

        int medianIdx = 0;
        double medianV = 0;
        if (mergeList.length % 2 == 0) {
            medianIdx = mergeList.length/2;
            medianV = ((double)(mergeList[medianIdx] + mergeList[medianIdx-1])) / 2;
        } else {
            medianIdx = mergeList.length/2;
            medianV = mergeList[medianIdx];
        }
        return medianV;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6 };

        double median = FindMedianArrays(arr1, arr2);
        System.out.println("Median value = " + median);
    }
}
