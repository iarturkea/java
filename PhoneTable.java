import java.util.ArrayList;
import java.util.HashMap;

public class PhoneTable {
    private final HashMap<String, ArrayList<String>> records = new HashMap<>();

    public String get(String name) {
        ArrayList<String> phoneList = records.get(name);
        if (phoneList == null) return "Нет такой фмилии в справочнике";
        return name + ": " + phoneList;
    }

    public void add(String name, String phoneNum) {
        if (!records.containsKey(name)) {
            records.put(name, new ArrayList<>());
        }
        records.get(name).add(phoneNum);
    }
}

