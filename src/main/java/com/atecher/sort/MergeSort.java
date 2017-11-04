package com.atecher.sort;

import java.util.Arrays;

/**
 * 合并排序
 * 合并排序依赖于合并操作，即将两个已经排序的序列合并成一个序列，具体的过程如下：
 * 1 申请空间，使其大小为两个已经排序序列之和，然后将待排序数组复制到该数组中。
 * 2 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3 比较复制数组中两个指针所指向的元素，选择相对小的元素放入到原始待排序数组中，并移动指针到下一位置
 * 4 重复步骤3直到某一指针达到序列尾
 * 5 将另一序列剩下的所有元素直接复制到原始数组末尾
 */
public class MergeSort {

    private static int[] aux; // 用于排序的辅助数组

    private static void merge(int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //把元素拷贝到辅助数组中
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        //然后按照规则将数据从辅助数组中拷贝回原始的array中
        for (int k = lo; k <= hi; k++) {
            //如果左边元素没了， 直接将右边的剩余元素都合并到到原数组中
            if (i > mid) {
                array[k] = aux[j++];
            }//如果右边元素没有了，直接将所有左边剩余元素都合并到原数组中
            else if (j > hi) {
                array[k] = aux[i++];
            }//如果左边右边小，则将左边的元素拷贝到原数组中
            else if (aux[i] < aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    public static void sort(int[] array) {
        aux = new int[array.length]; // 仅分配一次
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) return; //如果下标大于上标，则返回
        int mid = lo + (hi - lo) / 2;//平分数组
        sort(array, lo, mid);//循环对左侧元素排序
        sort(array, mid + 1, hi);//循环对右侧元素排序
        merge(array, lo, mid, hi);//对左右排好的序列进行合并
    }

    private static int CUTOFF = 7;//采用插入排序的阈值

    private static void sort2(int[] array, int lo, int hi) {
        if (lo >= hi) return; //如果下标大于上标，则返回
        if (hi <= lo + CUTOFF - 1) SelectionSort.selectionSort(array, lo, hi);
        int mid = lo + (hi - lo) / 2;//平分数组
        sort2(array, lo, mid);//循环对左侧元素排序
        sort2(array, mid + 1, hi);//循环对右侧元素排序
        merge(array, lo, mid, hi);//对左右排好的序列进行合并
    }

    private static void sort3(int[] array, int lo, int hi) {
        if (lo >= hi) return; //如果下标大于上标，则返回
        if (hi <= lo + CUTOFF - 1) SelectionSort.selectionSort(array, lo, hi);
        int mid = lo + (hi - lo) / 2;//平分数组
        sort3(array, lo, mid);//循环对左侧元素排序
        sort3(array, mid + 1, hi);//循环对右侧元素排序
        if (array[mid] <= array[mid + 1]) return;
        merge(array, lo, mid, hi);//对左右排好的序列进行合并
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7};
        System.out.println("Before SelectionSort:");
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println("After SelectionSort:");
        System.out.println(Arrays.toString(array));
    }
}
