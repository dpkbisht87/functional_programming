package com.practice.dp;


import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MaxSumIncreasingSubsequence {

    public static int maxSumOfIncreasingSubsequence(int[] a){
        int mis[] = new int[a.length];

//        for (int i = 0; i < a.length; i++){
//            mis[i] = a[i];
//        }

        mis = a.clone();

        int maxIncreasingSequenceSum = a[0];

        for(int i = 1; i < a.length; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j] && a[i] + mis[j] > mis[i]){
                    mis[i] = a[i] + mis[j];
                    maxIncreasingSequenceSum = Math.max(maxIncreasingSequenceSum, mis[i]);

                }
            }
        }
        int max = 0;
        for(int i = 0; i < a.length; i++){
            if(max < mis[i]){
                max = mis[i];
            }
        }
        OptionalInt optional =  Arrays.stream(mis).max();
        System.out.println(optional.isPresent());
        System.out.println(max);
        return maxIncreasingSequenceSum;
     }

    public static void main(String[] args) {
        int a[] = { 7, 1, 4, 8, 11, 2, 14, 3 };
        System.out.println(MaxSumIncreasingSubsequence.maxSumOfIncreasingSubsequence(a));

    }

}
