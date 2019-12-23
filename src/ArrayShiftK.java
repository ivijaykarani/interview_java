import java.util.stream.IntStream;

public class ArrayShiftK {

    public static void shiftArrayElements(int[] inArray, int k) {
        int kShift = k % inArray.length;
        int eleCount = 0;
        int startIdx = 0;
        int currIdx = startIdx;
        int prev = inArray[currIdx];
        while (eleCount < inArray.length) {
            currIdx = (currIdx + kShift) % inArray.length;
            int t = inArray[currIdx];
            inArray[currIdx] = prev;
            prev = t;
            eleCount++;

            if ((eleCount < inArray.length) && (currIdx == startIdx)) {
                startIdx++;
                currIdx = startIdx;
                prev = inArray[currIdx];
            }
        }
    }

    public static void printArrayElements(int[] inArray) {
        IntStream.of(inArray).forEach(n -> System.out.print(n + " "));
    }

    public static void main(String[] args) {
        int[] inArr1 = { 1, 2, 3, 4, 5 };
        shiftArrayElements(inArr1, 2);
        printArrayElements(inArr1);
        System.out.println();

        int[] inArr2 = { 1, 2, 3, 4 };
        shiftArrayElements(inArr2, 2);
        printArrayElements(inArr2);
    }
}
