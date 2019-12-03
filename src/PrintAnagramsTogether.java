import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;

public class PrintAnagramsTogether {

    public static String sortString(String inString) {
        String inLowerString = inString.toLowerCase();
        char[] inChars = inLowerString.toCharArray();
        Arrays.sort(inChars);
        return new String(inChars);
    }

    public static void main(String[] args) {
        String[] inArgs = {"cat", "dog", "tac", "god", "act"};
        HashMap<String, String> anaKeyValues = new HashMap<String, String>();
        for (int i = 0; i < inArgs.length; i++) {
            String anaValue = inArgs[i];
            String anaSortValue = sortString(anaValue);
            if (anaKeyValues.containsKey(anaSortValue)) {
                String mapValue = anaKeyValues.get(anaSortValue);
                mapValue += " " + anaValue;
                anaKeyValues.put(anaSortValue, mapValue);
            }
            else {
                anaKeyValues.put(anaSortValue, anaValue);
            }
        }

        Iterator<String> keyIter = anaKeyValues.keySet().iterator();
        while (keyIter.hasNext()) {
            System.out.print(anaKeyValues.get(keyIter.next()) + " ");
        }
        /*for (String inValue: anaKeyValues.keySet()) {
            System.out.print(anaKeyValues.get(inValue) + " ");
        }*/
        System.out.println();
    }
}
