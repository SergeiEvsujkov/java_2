package lesson3;

import java.util.*;

public class PhoneDirectory {

    private static HashMap <String, HashSet> phoneDir = new HashMap<>();

    public static void add(String name, String phone) {

        HashSet <String> phoneList = new HashSet<>();
        if (phoneDir.get(name) != null) {
            phoneList = phoneDir.get(name);
        }
        phoneList.add(phone);
        phoneDir.put(name, phoneList);
    }

    public static void get(String name) {
        if (phoneDir.get(name) != null) {
            System.out.println("Фамилия: " + name + ", телефон " + phoneDir.get(name));
        } else {
            System.out.println("Фамилии " + name + " нет в списке");
        }
    }


}
