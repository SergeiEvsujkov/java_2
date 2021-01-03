package lesson2;

import java.util.Random;

public class Main {
    public static Random random = new Random();
    public static final int SIZE_ARRAY = 4; // для проверки надо изменить размер массива

    public static void main(String[] args) {
        String[][] array = new String[SIZE_ARRAY][SIZE_ARRAY];
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Integer.toString(random.nextInt(10));
            }
        }

        array[2][2] = "r"; // здесь мы меняем число на букву для проверки вызова исключения преобразования

        for (String[] strings : array) {
            System.out.println();
            for (int j = 0; j < array.length; j++) {
                System.out.print(strings[j] + " ");
            }
        }

        try {
            System.out.println("\nСумма элементов массива = " + sumOfArrayElements(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }


    }

    public static int sumOfArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw  new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {

                try {
                    sum += Integer.parseInt(array[i][j]); // ловим исключение преобразования
                } catch (Exception e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }
}
