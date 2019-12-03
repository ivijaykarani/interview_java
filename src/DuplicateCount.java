import java.util.*;
import java.util.stream.IntStream;

public class DuplicateCount {

    public static int countDuplicateHashset(int[] inarr) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        HashSet<Integer> dupList = new HashSet<Integer>();
        for (int i = 0; i < inarr.length; i++) {
            if (hashSet.contains(inarr[i])) {
                dupList.add(inarr[i]);
            }
            else {
                hashSet.add(inarr[i]);
            }
        }
        return dupList.size();
    }

    public static int countDuplicateInArray(int[] inarr) {
        HashMap<Integer, Integer> dupMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inarr.length; i++) {
            if (dupMap.containsKey(inarr[i])) {
                int updtCount = dupMap.get(inarr[i]) + 1;
                dupMap.replace(inarr[i], updtCount);
            }
            else {
                dupMap.put(inarr[i], 1);
            }
        }
        int count = 0;
        Set<Integer> keyValues = dupMap.keySet();
        for (Integer k: keyValues) {
            if (dupMap.get(k) > 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] inArray = {1, 1, 2, 2, 2, 3, 4, 3, 9};
        int count2 = countDuplicateInArray(inArray);
        System.out.println("Duplicate Count: " + count2);

        int count3 = countDuplicateHashset(inArray);
        System.out.println("Duplicate Count: " + count3);
    }
}
