package strings;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatedCharacter {

    public static char firstNonRepeatedCharacter(String str) {
        char[] charArray = str.toCharArray();
        List<Character> list = new ArrayList<>();
        boolean repeated = false;
        for (int i = 0; i < charArray.length; i++) {
            repeated = false;
            if (list.contains(charArray[i])) {
                continue;
            }
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    repeated = true;
                    list.add(charArray[i]);
                    break;
                }
            }

            if (!repeated) {
                return charArray[i];
            }
        }
        System.out.println(list);
        return '_';
    }

    public static void main(String[] args) {
        String test  = "hheello";
        System.out.println(firstNonRepeatedCharacter(test));

    }
}
