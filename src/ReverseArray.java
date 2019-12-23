import java.util.Arrays;

public class ReverseArray {

    public static void reverseArray(int[] inarr) {
        if (inarr == null) return;
        for (int i = 0, j = inarr.length-1; i < j; i++, j--) {
            int t = inarr[i];
            inarr[i] = inarr[j];
            inarr[j] = t;
        }
    }

    public static void printArrayElements(int[] arr) {
        Arrays.stream(arr).forEach(x->{System.out.print(x + " ");});
    }

    public static void main(String[] args) {
        int[] arrInput = { 1, 7, 35, 3, 11, 25 };
        reverseArray(arrInput);
        printArrayElements(arrInput);
        System.out.println();
    }
}
