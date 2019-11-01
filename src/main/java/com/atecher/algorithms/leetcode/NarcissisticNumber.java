package com.atecher.algorithms.leetcode;

/**
 * @Author: hanhongwei
 * @Description:
 * @Date: Created on 2018/4/25
 */
public class NarcissisticNumber {

    /**
     * 打印出所有的“水仙花数”
     * 所谓水仙花数是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 水仙花数 ，因为153=1的三次方＋5的三次方＋3的三次方。
     * 1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
     * @param args
     */
    public static void main(String args[]) {
        Math mymath = new Math();
        for (int i = 100; i <= 999; i++) {
            if (mymath.narcissisticNumber(i) == true) {
                System.out.println(i);
            }
        }
    }
    static class Math {
        public boolean narcissisticNumber(int x) {

//            int len=0,tmp=x;
//            while (tmp>0){
//                tmp/=10;
//                len++;
//            }
//            int[] array=new int[len];
//            tmp=x;
//            for(int i=0;i<len;i++){
//
//            }

            int i = 0, j = 0, k = 0;
            i = x / 100;
            j = (x % 100) / 10;
            k = x % 10;
            return x == i * i * i + j * j * j + k * k * k;
        }
    }
}


