package lesson2;

public class MyArraySizeException extends Exception {
    public MyArraySizeException () {
        System.out.println("\nРазмер массива отличается от 4*4!!!");
    }
}
