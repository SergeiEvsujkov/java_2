package lesson3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        task1();
        task2();
        
    }


    private static void task1() {
        String[] wordsArray = {"стол", "стул", "табуретка", "окно", "стол", "холодильник", "стол", "микроволновка", "телевизор", "окно", "кастрюля"};
        System.out.println("Первоначальный массив слов: " + Arrays.toString(wordsArray));
        Set <String> wordsSet = new HashSet <> (Arrays.asList(wordsArray));
        System.out.println("Количество уникальных слов в массиве: " + wordsSet.size() + "\nУникальные слова массива: " + wordsSet +"\n");
    }

    private static void task2() {
        PhoneDirectory.add("Евсюков", "89134448987");
        PhoneDirectory.add("   ", "89134448433");
        PhoneDirectory.add("Иванов", "89134444455");
        PhoneDirectory.add("", "89134477870");
        PhoneDirectory.add("Иванов", "89139444466");
        PhoneDirectory.get("Иванов");
        PhoneDirectory.get("Евсюков");
        PhoneDirectory.get("Сидоров");
        PhoneDirectory.get("");

    }

}
