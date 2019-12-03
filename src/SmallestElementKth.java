public class SmallestElementKth {

    public static int kthSmallestElement(int[] inarr, int kelement) {
        if (kelement == 1) {
            int smallest = inarr[0];
            for (int i = 1; i < inarr.length; i++) {
                if (inarr[i] < smallest)
                    smallest = inarr[i];
            }
            return smallest;
        }
        else if (kelement >= inarr.length) {
            int largest = inarr[0];
            for (int i = 1; i < inarr.length; i++) {
                if (inarr[i] > largest)
                    largest = inarr[i];
            }
            return largest;
        }
        else {
            int[] smallElements = new int[kelement];
            for (int i = 1; i < smallElements.length; i++)
                smallElements[i] = Integer.MAX_VALUE;
            smallElements[0] = inarr[0];
            for (int i = 1; i < inarr.length; i++) {
                int eleValue = inarr[i];
                for (int j = 0; j < smallElements.length; j++) {
                    if (eleValue < smallElements[j]) {
                        int t = smallElements[j];
                        smallElements[j] = eleValue;
                        eleValue = t;
                    }
                }
            }
            return smallElements[smallElements.length-1];
        }
    }

    public static void main(String[] args) {
        int[] arrElements = { 7, 10, 4, 3, 20, 15 };
        int value = kthSmallestElement(arrElements, 3);
        System.out.println("Kth Smallest Element: " + value);

        int[] arrElements2 = { 7, 10, 4, 20, 15 };
        int value2 = kthSmallestElement(arrElements2, 4);
        System.out.println("Kth Smallest Element: " + value2);
    }
}
