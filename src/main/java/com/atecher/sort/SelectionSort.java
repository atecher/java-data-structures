package com.atecher.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序很简单，他的步骤如下:
 * 从左至右遍历，找到最小(大)的元素，然后与第一个元素交换。
 * 从剩余未排序元素中继续寻找最小（大）元素，然后与第二个元素进行交换。
 * 以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {


    /**
     * 选择排序
     * @param array
     */
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            //从第i+1个元素开始，找最小值
            for (int j = i + 1; j < n; j++) {
                if (array[min] > array[j])
                    min = j;
            }
            //找到之后和第i个元素交换
            swap(array, i, min);
        }
    }

    public static void selectionSort(int[] array,int lo,int hi) {
        for (int i = lo; i <= hi; i++) {
            int min = i;
            //从第i+1个元素开始，找最小值
            for (int j = i + 1; j <= hi; j++) {
                if (array[min] > array[j])
                    min = j;
            }
            //找到之后和第i个元素交换
            swap(array, i, min);
        }
    }
    /**
     * 元素交换
     * @param array
     * @param i
     * @param min
     */
    private static void swap(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7};
        System.out.println("Before SelectionSort:");
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println("After SelectionSort:");
        System.out.println(Arrays.toString(array));
    }
}
