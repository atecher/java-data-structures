package com.atecher.algorithms.leetcode;

/**
 * @description:
 * @author: hanhongwei
 * @date: 2019-05-28 16:47
 * @link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            int lastIndex=list.lastIndexOf(character);
            if (lastIndex>=0) {
                if (longest < list.length()) {
                    longest = list.length();
                }
                list = new StringBuilder(list.substring(list.lastIndexOf(character)+1));
            }
            list.append(character);
        }
        if (longest < list.length()) {
            longest = list.length();
        }
        return longest;
    }


    public static void main(String[] args) {
        String s = "abca";
        int i = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
