package com.atecher.algorithms.leetcode;

/**
 * @description:
 * @author: hanhongwei
 * @date: 2019-05-27 22:53
 * @link: https://leetcode-cn.com/problems/add-binary/
 */
public class AddBinary {
//    public String addBinary(String a, String b) {
//        long aInt = Long.parseLong(a, 2);
//        long bInt= Integer.parseInt(b,2);
//        return Long.toBinaryString(add(aInt,bInt));
//    }
//
//    private  long add(long x, long y) {
//        if (y == 0) return x;
//        long sum, carry;
//        sum = x ^ y;
//        carry = (x & y) << 1;
//        return add(sum, carry);
//    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder(Math.max(a.length(),b.length())+1);
        while(i >=0 || j >=0){
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = m + n + carry;
            carry = sum / 2;
            sb.insert(0, String.valueOf(sum % 2));
            i--;
            j--;
        }
        if(carry != 0) sb.insert(0, '1');
        return sb.toString();
    }





    public static void main(String[] args) {
        String a="0011",b="0101";
        String s = new AddBinary().addBinary(a, b);
        System.out.println(s);
    }
}
