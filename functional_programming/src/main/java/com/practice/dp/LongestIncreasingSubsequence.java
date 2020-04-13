package com.practice.dp;

import java.sql.Time;

public class LongestIncreasingSubsequence {

    public static int lisLength(int[] a){
        int lis[] = new int[a.length];
        for(int i = 0; i < a.length; i++){
            lis[i] = 1;
        }

        int maxSubsequenceLength = 1;

        for(int i = 1; i < a.length; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j] && 1 + lis[j] > lis[i]){
                    lis[i] = 1 + lis[j];
                    System.out.println(a[i]);
                    maxSubsequenceLength = Math.max(lis[i], maxSubsequenceLength);
                }
            }
        }
        return maxSubsequenceLength;
    }
    public static void main(String[] args) {
        int a[] = { 7, 1, 4, 8, 11, 2, 14, 3 };
        System.out.println(LongestIncreasingSubsequence.lisLength(a));

    }

}

/*
Time complexity: O(n square)
Space complexity: O(n)*/
