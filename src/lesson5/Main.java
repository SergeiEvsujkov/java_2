package lesson5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        firstAction();

        try {
            secondAction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void firstAction() {
        final int SIZE = 10000000;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long startAction = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finishAction = System.currentTimeMillis();
        long timeAction = finishAction - startAction;
        System.out.println(Arrays.toString(arr));
        System.out.println("Время выполнения: " + timeAction);
    }

    public static void secondAction() throws InterruptedException {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        Arrays.fill(arr, 1);

        long startAction = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();


        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        long finishAction = System.currentTimeMillis();
        long timeAction = finishAction - startAction;

        System.out.println(Arrays.toString(arr));
        System.out.println("Время выполнения: " + timeAction);


    }
}
