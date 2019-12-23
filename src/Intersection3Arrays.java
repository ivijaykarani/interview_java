import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

public class Intersection3Arrays {

    public static int[] findIntersection3SortedArrays(int[] a1, int[] a2, int[] a3) {
        int a1Idx = 0;
        int a2Idx = 0;
        int a3Idx = 0;
        ArrayList<Integer> a1a2a3List = new ArrayList<Integer>();
        while (a1Idx < a1.length && a2Idx < a2.length && a3Idx < a3.length) {
            if ( (a1[a1Idx] == a2[a2Idx]) && (a2[a2Idx] == a3[a3Idx]) ) {
                a1a2a3List.add(a1[a1Idx]);
                a1Idx++; a2Idx++; a3Idx++;
            }
            else if (a1[a1Idx] < a2[a2Idx])
                a1Idx++;
            else if (a2[a2Idx] < a3[a3Idx])
                a2Idx++;
            else
                a3Idx++;
        }
        int[] retList = new int[a1a2a3List.size()];
        for (int i = 0; i < a1a2a3List.size(); i++) {
            retList[i] = a1a2a3List.get(i);
        }
        return  retList;
    }

    public static int[] intersection3Arrays(int[] a1, int[] a2, int[] a3) {
        HashMap<Integer, Integer> a1Hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < a1.length; i++) {
            if (a1Hash.containsKey(a1[i])) {
                int a1Count = a1Hash.get(a1[i]);
                a1Count += 1;
                a1Hash.put(a1[i], a1Count);
            }
            else
                a1Hash.put(a1[i], 1);
        }

        HashMap<Integer, Integer> a1a2Int = new HashMap<Integer, Integer>();
        for (int i = 0; i < a2.length; i++) {
            if (a1Hash.containsKey(a2[i])) {
                if (a1a2Int.containsKey(a2[i])) {
                    int a1Cnt = a1Hash.get(a2[i]);
                    int a1a2Cnt = a1a2Int.get(a2[i]);
                    if (a1Cnt > a1a2Cnt) {
                        a1a2Cnt += 1;
                        a1a2Int.put(a2[i], a1a2Cnt);
                    }
                }
                else
                    a1a2Int.put(a2[i], 1);
            }
        }

        HashMap<Integer, Integer> a1a2a3Int = new HashMap<Integer, Integer>();
        for (int i = 0; i < a3.length; i++) {
            if (a1a2Int.containsKey(a3[i])) {
                if (a1a2a3Int.containsKey(a3[i])) {
                    int a1a2Cnt = a1a2Int.get(a3[i]);
                    int a1a2a3Cnt = a1a2a3Int.get(a3[i]);
                    if (a1a2Cnt > a1a2a3Cnt) {
                        a1a2a3Cnt += 1;
                        a1a2a3Int.put(a3[i], a1a2a3Cnt);
                    }
                }
                else
                    a1a2a3Int.put(a3[i], 1);
            }
        }

        ArrayList<Integer> cElements = new ArrayList<Integer>();
        Iterator mIter = a1a2a3Int.entrySet().iterator();
        while (mIter.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry)mIter.next();
            int ctValues = entry.getValue();
            for (int i = 0; i < ctValues; i++) {
                cElements.add(entry.getKey());
            }
        }
        int[] retList = new int[cElements.size()];
        for (int i = 0; i < cElements.size(); i++) {
            retList[i] = cElements.get(i);
        }
        return  retList;
    }

    public static void printArray(int[] inarr) {
        IntStream.of(inarr).forEach(n-> {
            System.out.print(n + " ");
        });
    }

    public static void main(String[] args) {
        int[] a1 = { 1, 3, 5, 3, 0 };
        int[] a2 = { 0, 5, 3, 3, 13, 10 };
        int[] a3 = { 3, 7, 11, 5, 3, 0, 9 };

        int[] arr3Int = intersection3Arrays(a1, a2, a3);
        printArray(arr3Int);
        System.out.println();

        int[] a1S = { 2, 6, 9, 11, 13, 17 };
        int[] a2S = { 3, 6, 7, 10, 13, 18 };
        int[] a3S = { 4, 5, 6, 9, 11, 13 };
        int[] a1a2a3 = findIntersection3SortedArrays(a1S, a2S, a3S);
        printArray(a1a2a3);
        System.out.println();
    }
}
