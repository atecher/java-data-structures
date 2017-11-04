package com.atecher.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 快速排序的基本思想如下：
 * 1.  对数组进行随机化。
 * 2.  从数列中取出一个数作为中轴数(pivot)。
 * 3.  将比这个数大的数放到它的右边，小于或等于它的数放到它的左边。
 * 4.  再对左右区间重复第三步，直到各区间只有一个数。
 */
public class QuickSort {

    /**
     * 快速排序中的划分过程
     *
     * @param array 待划分的数组
     * @param lo    最左侧位置
     * @param hi    最右侧位置
     * @return 中间元素位置
     */
    private static int partition(int[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            //从左至右扫描，如果碰到比基准元素array[lo]小，则该元素已经位于正确的分区，i自增，继续比较i+1；
            //否则，退出循环，准备交换
            while (array[++i] < array[lo]) {
                //如果扫描到了最右端，退出循环
                if (i == hi) break;
            }

            //从右自左扫描，如果碰到比基准元素array[lo]大，则该元素已经位于正确的分区，j自减，继续比较j-1
            //否则，退出循环，准备交换
            while (array[--j] > array[lo]) {
                //如果扫描到了最左端，退出循环
                if (j == lo) break;
            }

            //如果相遇，退出循环
            if (i >= j) break;

            //交换左a[i],a[j]右两个元素，交换完后他们都位于正确的分区
            swap(array, i, j);
        }
        //经过相遇后，最后一次a[i]和a[j]的交换
        //a[j]比a[lo]小，a[i]比a[lo]大，所以将基准元素与a[j]交换
        swap(array, lo, j);
        //返回扫描相遇的位置点
        return j;
    }

    private static void swap(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }


    /*//基本方式
    private static void sort(int[] array, int lo, int hi) {
        //如果子序列为1，则直接返回
        if (lo >= hi) return;
        //划分，划分完成之后，分为左右序列，左边所有元素小于array[index]，右边所有元素大于array[index]
        int index = partition(array, lo, hi);

        //对左右子序列进行排序完成之后，整个序列就有序了
        //对左边序列进行递归排序
        sort(array, lo, index - 1);
        //对右边序列进行递归排序
        sort(array, index + 1, hi);
    }*/


    private static int CUTTOFF = 10;
/*
    //当划分到较小的子序列时，通常可以使用插入排序替代快速排序
    private static void sort(int[] array, int lo, int hi) {
        //如果子序列为1，则直接返回
        if (lo >= hi) return;
        //对于小序列，直接采用插入排序替代
        if (hi - lo <= CUTTOFF - 1) {
            InsertionSort.insertionSort(array, lo, hi);
            return;
        }
        //划分，划分完成之后，分为左右序列，左边所有元素小于array[index]，右边所有元素大于array[index]
        int index = partition(array, lo, hi);

        //对左右子序列进行排序完成之后，整个序列就有序了

        //对左边序列进行递归排序
        sort(array, lo, index - 1);
        //对右边序列进行递归排序
        sort(array, index + 1, hi);
    }*/

/*    //采用三平均分区法对快速排序的改进如下
    private static void sort(int[] array, int lo, int hi) {
        //对于小序列，直接采用插入排序替代
        if (hi - lo <= CUTTOFF - 1) {
            //Sort<int>.InsertionSort(array, lo, hi);
            return;
        }
        //采用三平均分区法查找中轴
        int m = medianOf3(array, lo, lo + (hi - lo) / 2, hi);
        swap(array, lo, m);
        //划分，划分完成之后，分为左右序列，左边所有元素小于array[index]，右边所有元素大于array[index]
        int index = partition(array, lo, hi);

        //对左右子序列进行排序完成之后，整个序列就有序了

        //对左边序列进行递归排序
        sort(array, lo, index - 1);
        //对右边序列进行递归排序
        sort(array, index + 1, hi);
    }*/
/*

    //使用Dijkstra的三分区快速排序代码
    private static void sort(int[] array, int lo, int hi) {
        //对于小序列，直接采用插入排序替代
        if (hi - lo <= CUTTOFF - 1) {
            InsertionSort.insertionSort(array, lo, hi);
            return;
        }
        //三分区
        int lt = lo, i = lo + 1, gt = hi;
        int v = array[lo];
        while (i <= gt) {
            int cmp = array[i] - v;
            if (cmp < 0) swap(array, lt++, i++);
            else if (cmp > 0) swap(array, i, gt--);
            else i++;
        }

        //对左边序列进行递归排序
        sort(array, lo, lt - 1);
        //对右边序列进行递归排序
        sort(array, gt + 1, hi);
    }

*/

    /**
     * 查找三个元素中位于中间的那个元素
     *
     * @param array
     * @param lo
     * @param center
     * @param hi
     * @return
     */
    private static int medianOf3(int[] array, int lo, int center, int hi) {
        return (less(array[lo], array[center]) ?
                (less(array[center], array[hi]) ? center : less(array[lo], array[hi]) ? hi : lo) :
                (less(array[hi], array[center]) ? center : less(array[hi], array[lo]) ? hi : lo));
    }

    private static boolean less(int t1, int t2) {
        return t1 < t2;
    }

    //采用 Bentley&D. McIlroy 三分区快速排序的算法改进
    private static void sort(int[] array, int lo, int hi) {
        //对于小序列，直接采用插入排序替代
        if (hi - lo <= CUTTOFF - 1) {
            InsertionSort.insertionSort(array, lo, hi);
            return;
        }
        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi + 1;
        int p = lo, q = hi + 1;
        int v = array[lo];
        while (true) {
            while (less(array[++i], v))
                if (i == hi) break;
            while (less(v, array[--j]))
                if (j == lo) break;

            // pointers cross
            if (i == j && array[i] == v)
                swap(array, ++p, i);
            if (i >= j) break;

            swap(array, i, j);
            if (array[i] == v) swap(array, ++p, i);
            if (array[j] == v) swap(array, --q, j);
        }

        //将相等的元素交换到中间
        i = j + 1;
        for (int k = lo; k <= p; k++) swap(array, k, j--);
        for (int k = hi; k >= q; k--) swap(array, k, i++);

        sort(array, lo, j);
        sort(array, i, hi);
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
