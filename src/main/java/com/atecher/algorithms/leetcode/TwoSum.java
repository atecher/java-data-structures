package com.atecher.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: hanhongwei
 * @date: 2019-05-27 23:28
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if(map.containsKey(sub)&&i!=map.get(sub)){
                return new int[]{i,map.get(sub)};
            }
        }
        return null;
    }
}
