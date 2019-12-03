import java.util.HashMap;

public class TargetValueInList {

    public static boolean FindIfValuesAdd2Target(int[] input, int target) {
        HashMap<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            if (inputMap.get(input[i]) == null) {
                inputMap.put(input[i], 1);
            }
            else {
                int value = inputMap.get(input[i]);
                inputMap.replace(input[i], value+1);
            }
        }

        for (int i = 0; i < input.length; i++) {
            int value2 = target - input[i];
            if (value2 != input[i]) {
                if (inputMap.get(value2) != null)
                    return true;
            }
            else {
                int vcount = inputMap.get(value2);
                if (vcount > 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] inArr = { 1, 2, 3, 7, 9, 6, 3 };
        int target = 20;

        boolean status = FindIfValuesAdd2Target(inArr, target);
        System.out.println("2 inputs in the array add to " + target + " = " + status);
    }
}
