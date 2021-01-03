package lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException (int i, int j) {
        System.out.println("\nЯчейку массива (" + i + ", " + j + ") невозможно преобразовать к целому типу!");
    }
}
