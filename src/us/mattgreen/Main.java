package us.mattgreen;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();


    public static void main(String[] args) {

        String line;
        String[] words;
        Object wordFound;

        while ((line = indata.fileReadLine()) != null) {
            line = line.replace(".", "")
                    .replace(";", "").replace(":", "")
                    .replace("'", "").replace("\"", "")
                    .replace("-", "").replace("!", "")
                    .replace("#", "").replace("(", "")
                    .replace(")", "").replace("?", "")
                    .replace("_", " ").replace("?", "")
                    .toLowerCase().trim();

            words = line.split(",");

            for (String s : words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }

        }

        Integer[] a = new Integer[map.values().size()];
        int maxValue = getMaxValue(map.values().toArray(a));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println("---------------------------");
                System.out.println("Word used the most: " + entry.getKey() + " " + entry.getValue());
                System.out.println("---------------------------");
            }
            //word used once
            else if (entry.getValue() == 1) {
                System.out.println("== 1: " + entry.getKey() + " " + entry.getValue());
            }


            else {
                System.out.println(" word > 2: " + entry.getKey() + entry.getValue());
            }
        }
    }

    public static int getMaxValue(Integer[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}
    
