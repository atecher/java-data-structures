package com.atecher.algorithms.leetcode;

/**
 * @description:
 * @author: hanhongwei
 * @date: 2019-05-28 10:19
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }else if(strs.length==1){
            return strs[0];
        }
        int length = getShortestLength(strs);
        if(length==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <length ; i++) {
            Character ch=null;
            boolean jumpout=false;
            for (String str : strs) {
                if(ch==null){
                    ch=str.charAt(i);
                }else if(str.charAt(i)!=ch){
                    jumpout=true;
                    break;
                }
            }
            if(jumpout){
                break;
            }else{
                sb.append(ch);
            }
        }
        if(sb.length()==0){
            return "";
        }
        return sb.toString();
    }

    /**
     * 找到数组中最短的字符串
     * @param strs
     * @return
     */
    private int getShortestLength(String[] strs){
        int shortest = -1;
        for(String s : strs){
            int sLength = s.length();
            if(shortest == -1){
                shortest = sLength;
            }
            if(sLength < shortest){
                shortest = sLength;
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        String[] ss=new String[] {"","aflow","flight"};
        String s = new LongestCommonPrefix().longestCommonPrefix(ss);
        System.out.println(s);
    }
}
