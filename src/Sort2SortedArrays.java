public class Sort2SortedArrays {

    public static void createSortedArray(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];

        int arr1Idx = 0;
        int arr2Idx = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (arr1Idx > arr1.length-1) {
                arr3[i] = arr2[arr2Idx++];
            }
            else if (arr2Idx > arr2.length-1) {
                arr3[i] = arr1[arr1Idx++];
            }
            else {
                if (arr1[arr1Idx] < arr2[arr2Idx]) {
                    arr3[i] = arr1[arr1Idx++];
                }
                else {
                    arr3[i] = arr2[arr2Idx++];
                }
            }
        }

    }

    public static void createInplaceSort(int[] arr1, int[] arr2) {
        int elementCount = arr1.length + arr2.length;
        int arr1Idx = 0;
        int arr2Idx = 0;
        int arr2loc = 0;
        for (int i = 0; i < elementCount-1; i++) {
            if (arr1Idx > arr1.length-1) {
                break;
            }
            else if (arr2Idx > arr2.length-1) {
                break;
            }
            else {
                if (arr1[arr1Idx] < arr2[arr2Idx]) {
                    arr1Idx++;
                }
                else {
                    int t = arr1[arr1Idx];
                    arr1[arr1Idx] = arr2[arr2Idx];
                    arr2[arr2Idx] = t;
                    for (int j = arr2Idx; j < arr2.length-1; j++) {
                        if (arr2[j] > arr2[j + 1]) {
                            t = arr2[j];
                            arr2[j] = arr2[j + 1];
                            arr2[j + 1] = t;
                        }
                        else {
                            arr2loc = j;
                            break;
                        }
                    }
                    arr1Idx++;
                }
            }
        }
        printArrayElements(arr1);
        printArrayElements(arr2);
    }

    public static void createInplaceSortReverse(int[] arr1, int[] arr2) {
        int elementCount = arr1.length + arr2.length - 1;
        int arr1Idx = arr1.length - 1;
        int arr2Idx = arr2.length - 1;
        int arr2loc = 0;
        for (int i = 0; i < elementCount; i++) {
            if (arr1Idx < 0) {
                break;
            }
            else if (arr2Idx < 0) {
                break;
            }
            else {
                if (arr2[arr2Idx] > arr1[arr1Idx]) {
                }
                else {
                    int t = arr2[arr2Idx];
                    arr2[arr2Idx] = arr1[arr1Idx];
                    arr1[arr1Idx] = t;
                    for (int j = arr1Idx; j > 0; j--) {
                        if (arr1[j] < arr1[j - 1]) {
                            t = arr1[j];
                            arr1[j] = arr1[j - 1];
                            arr1[j - 1] = t;
                        }
                        else {
                            break;
                        }
                    }
                    arr2Idx--;
                }
            }
        }
        printArrayElements(arr1);
        printArrayElements(arr2);
    }

    public static void createInplaceInLargerArray(int[] inarr1, int[] inarr2) {
        int jIdx = inarr2.length - 1;
        int iIdx = inarr1.length - inarr2.length - 1;
        int mIdx = inarr1.length - 1;
        while (iIdx >= 0 && jIdx >= 0) {
            if (inarr1[iIdx] > inarr2[jIdx]) {
                inarr1[mIdx] = inarr1[iIdx--];
            }
            else {
                inarr1[mIdx] = inarr2[jIdx--];
            }
            mIdx--;
        }
        while (jIdx >= 0) {
            inarr1[mIdx--] = inarr2[jIdx--];
        }
        printArrayElements(inarr1);
    }

    public static void printArrayElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        //createSortedArray(arr1, arr2);
        //createInplaceSort(arr1, arr2);
        createInplaceSortReverse(arr1, arr2);

        int[] arr3 = {1, 5, 9, 10, 15, 20, 0, 0, 0, 0};
        int[] arr4 = {2, 3, 8, 13};
        //createInplaceInLargerArray(arr3, arr4);
    }
}
