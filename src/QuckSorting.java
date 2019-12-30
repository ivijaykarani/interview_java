import java.util.stream.IntStream;

public class QuckSorting {

    public static void quickSort(int[] inArray, int stIdx, int endIdx) {
        if (stIdx >= endIdx)
            return;
        int pIdx = partition(inArray, stIdx, endIdx);
        quickSort(inArray, stIdx, pIdx-1);
        quickSort(inArray, pIdx+1, endIdx);
    }

    private static int partition(int[] inArray, int stIdx, int endIdx) {
        int pivot = inArray[endIdx];
        int pIdx = stIdx;
        for (int i = stIdx; i < endIdx; i++) {
            if (inArray[i] < pivot) {
                int t = inArray[pIdx];
                inArray[pIdx] = inArray[i];
                inArray[i] = t;
                pIdx++;
            }
        }
        int t = inArray[endIdx];
        inArray[endIdx] = inArray[pIdx];
        inArray[pIdx] = t;
        return pIdx;
    }

    public static void printArray(int[] input) {
        IntStream.of(input).forEach(n-> {System.out.print(n + " ");});
    }

    public static void main(String args[]) {
        int[] input = { 3, 7, 1, 6, 5, 2, 4 };
        quickSort(input, 0, input.length-1);
        printArray(input);
    }
}
