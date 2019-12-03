public class BinarySearchAlgorithm {

    public static boolean linearSearch(int[] arrList, int ele) {
        int firstIdx = 0;
        int lastIdx = arrList.length - 1;
        boolean found = false;
        while ((firstIdx < lastIdx) && !found) {
            int midIdx = (firstIdx + lastIdx / 2);
            if (arrList[midIdx] == ele) {
                found = true;
            }
            else {
                if (ele < arrList[midIdx]) {
                    lastIdx = midIdx - 1;
                }
                else {
                    firstIdx = midIdx + 1;
                }
            }
        }
        return found;
    }

    public static boolean recursionSearch(int[] arrList, int stIdx, int endIdx, int ele) {
        if (stIdx == endIdx) {
            return arrList[stIdx] == ele;
        }
        else {
            int midIdx = (stIdx + endIdx) / 2;
            if (arrList[midIdx] == ele) {
                return true;
            }
            else {
                if (ele < arrList[midIdx]) {
                    return recursionSearch(arrList, stIdx, midIdx-1, ele);
                }
                else {
                    return recursionSearch(arrList, midIdx+1, endIdx, ele);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        //boolean result = linearSearch(arr, 100);
        //System.out.println("element " + 5 + " found status: " + result);
        boolean result = recursionSearch(arr, 0, arr.length-1, 10);
        System.out.println("element " + 5 + " found status: " + result);
    }
}
