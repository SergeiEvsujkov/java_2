package lesson3;

import java.util.*;

public class PhoneDirectory {

    private static HashMap <String, HashSet> phoneDir = new HashMap<>();

    public static void add(String name, String phone) {

        HashSet <String> phoneList = new HashSet<>();

        if (phoneDir.get(name) != null) {
            if (!name.isBlank()) {
                phoneList = phoneDir.get(name);
            } else {
                phoneList = phoneDir.get("");
            }
        }
        phoneList.add(phone);
        if (!name.isBlank()) {
            phoneDir.put(name, phoneList);
        } else {
            phoneDir.put("", phoneList);
        }
    }

    public static void get(String name) {
        if (phoneDir.get(name) != null) {
            if (!name.isBlank()) {
                System.out.println("Фамилия: " + name + ", телефон " + phoneDir.get(name));
            } else {
                System.out.println("Анонимные телефоны: " + phoneDir.get(""));
            }
        } else {
            System.out.println("Фамилии " + name + " нет в списке");
        }
    }


}
