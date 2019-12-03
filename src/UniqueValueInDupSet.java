import java.util.HashSet;
import java.util.Iterator;

public class UniqueValueInDupSet {

    public static int FindUniqueValue(int[] input) {
        HashSet<Integer> inputSet = new HashSet<Integer>();
        HashSet<Integer> dupSet = new HashSet<Integer>();
        int uniqueV = -1;
        for (int i = 0; i < input.length; i++) {
            if (inputSet.contains(input[i])) {
                inputSet.remove(input[i]);
                dupSet.add(input[i]);
            }
            else {
                if (!dupSet.contains(input[i])) {
                    inputSet.add(input[i]);
                }
            }
        }
        Iterator<Integer> it = inputSet.iterator();
        uniqueV = it.next();
        return uniqueV;
    }

    public static void main(String[] args) {
        int[] inarr = { 1, 3, 5, 7, 7, 3, 5, 1, 2, 1 };
        int uniqueV = FindUniqueValue(inarr);
        System.out.println("Unique value is " + uniqueV);
    }
}
