import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeKSortedArrays {

    public static int[] mergeKSortedArray(int[][] ksortedArr) {
        int[] firstArr = ksortedArr[0];
        for (int i = 1; i < ksortedArr.length; i++) {
            int[] secondArr = ksortedArr[i];
            firstArr = merge2SortedArray(firstArr, secondArr);
        }
        return firstArr;
    }

    public static int[] merge2SortedArray(int[] arr1, int[] arr2) {
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
        return mergeList;
    }

    public static void main(String[] args) {
        int[][] sortedArr = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[] sortArr = mergeKSortedArray(sortedArr);
        //Arrays.stream(sortArr).forEach(System.out::print);
        IntStream.of(sortArr).forEach(System.out::print);
    }
}
