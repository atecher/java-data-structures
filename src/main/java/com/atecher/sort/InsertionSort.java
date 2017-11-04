package com.atecher.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 插入排序也是一种比较直观的排序方式。可以以我们平常打扑克牌为例来说明，假设我们那在手上的牌都是排好序的，那么插入排序可以理解为我们每一次将摸到的牌，和手中的牌从左到右依次进行对比，如果找到合适的位置则直接插入。具体的步骤为：
 *  1 从第一个元素开始，该元素可以认为已经被排序
 *  2 取出下一个元素，在已经排序的元素序列中从后向前扫描
 *  3 如果该元素小于前面的元素（已排序），则依次与前面元素进行比较如果小于则交换，直到找到大于该元素的就则停止；
 *  4 如果该元素大于前面的元素（已排序），则重复步骤2
 *  5 重复步骤2~4 直到所有元素都排好序 。
 *
 */
public class InsertionSort {

    /**
     * 插入排序
     * @param array
     */
    public static void insertionSort(int[] array){
        int n = array.length;
        //从第二个元素开始
        for (int i = 1; i < n; i++){
            //从第i个元素开始，一次和前面已经排好序的i-1个元素比较，如果小于，则交换
            for (int j = i; j > 0; j--){
                if (array[j]< array[j - 1]){
                    swap(array, j, j - 1);
                }
                else//如果大于，则不用继续往前比较了，因为前面的元素已经排好序，比较大的大就是教大的了。
                    break;
            }
        }
    }

    public static void insertionSort(int[] array,int lo,int hi){
        //从第二个元素开始
        for (int i = lo+1; i <= hi; i++){
            //从第i个元素开始，一次和前面已经排好序的i-1个元素比较，如果小于，则交换
            for (int j = i; j > lo; j--){
                if (array[j]< array[j - 1]){
                    swap(array, j, j - 1);
                }
                else//如果大于，则不用继续往前比较了，因为前面的元素已经排好序，比较大的大就是教大的了。
                    break;
            }
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
        insertionSort(array);
        System.out.println("After SelectionSort:");
        System.out.println(Arrays.toString(array));
    }
}
