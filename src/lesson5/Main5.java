package lesson5;


import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        methodOneThread();
        methodTwoThreads();
    }

    public static void methodOneThread(){
        final int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        };
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void methodTwoThreads(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        };
        long a = System.currentTimeMillis();
        float[] leftHalf = new float[h];
        float[] rightHalf = new float[h];
        System.arraycopy(arr, 0, leftHalf, 0, h);
        System.arraycopy(arr, h, rightHalf, 0, h);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                leftHalf[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
//        System.out.println(Arrays.toString(leftHalf));
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                rightHalf[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();

        float[] mergedArray = new float[size];
        System.arraycopy(leftHalf, 0, mergedArray, 0, h);
        System.arraycopy(rightHalf, 0, mergedArray, h, h);
//        System.out.println(Arrays.toString(mergedArray));
        System.out.println(System.currentTimeMillis() - a);
    }
}

