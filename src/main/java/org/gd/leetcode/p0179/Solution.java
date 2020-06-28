package org.gd.leetcode.p0179;

import java.util.Arrays;
import java.util.Comparator;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/largest-number/
 */
// TODO: unit test
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.SORT)
class Solution {

    private static final Comparator<String> STRING_COMPARATOR = (a, b) -> (b + a).compareTo(a + b);

    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0)
            return "";

        if (nums.length == 1)
            return "" + nums[0];

        String[] strings = new String[nums.length];
        int capacity = 0;
        for (int i = 0; i < nums.length; i++) {
            String numString = "" + nums[i];
            strings[i] = "" + numString;
            capacity += numString.length();
        }

        Arrays.sort(strings, STRING_COMPARATOR);

        if (strings[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder(capacity);
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }

        return sb.toString();
    }
}

/*

class Solution {
    public String largestNumber(int[] nums) {
        List<String>  arr = new ArrayList<>();
        for(int num: nums){
            arr.add(String.valueOf(num));
        }
        Collections.sort(arr, new Comparator<>(){
           public int compare(String a, String b) {
               int len1 = a.length();
               int len2 = b.length();
               int res= 0;
               for(int i=0;i<len1*len2;i++){
                   res = a.charAt(i%len1) - b.charAt(i%len2);
                   if(res!=0) break;
               }
               return res*-1;
               // String s1 = a + b;
               // String s2 = b + a;
               // return s2.compareTo(s1);
           }
        });
        // System.out.println(arr);
        if(arr.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String num: arr){
            sb.append(num);
        }
        return sb.toString();
    }
}

*/