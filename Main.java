import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MultiHashtable;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String partOne =  "Создать массив с набором слов слов должны встречаться повторяющиеся Найти и вывести список уникальных слов из которых состоит массив дубликаты не считаем";
        partOne = partOne.toLowerCase(Locale.ROOT);

        ArrayList<String> arrPartOne = new ArrayList<>();
        int t=0;

        for (int i = 0; i < partOne.length(); i++) {
            if (Character.isWhitespace(partOne.charAt(i))){
                arrPartOne.add(partOne.substring(t,i));
                t=i+1;
            }

        }

        HashMap <String, Integer> hm = new HashMap<>();

        for (String word : arrPartOne) {
            if (hm.containsKey(word)) {
                hm.put(word, hm.get(word)+1);
            } else {
                hm.put(word, 1);
            }
        }


        for (Map.Entry<String, Integer> o : hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }

        PhoneTable nskPone = new PhoneTable();

        nskPone.add("Kretinin", "3360924");
        nskPone.add("Kretinin", "89039037806");

        System.out.println(nskPone.get("Kretinin"));
        System.out.println(nskPone.get("Solov`yev"));
    }
}
