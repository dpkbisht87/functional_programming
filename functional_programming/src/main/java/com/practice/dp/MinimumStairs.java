package com.practice.dp;

public class MinimumStairs {

    public int minJumpsRecursive(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2 || n == 3 ){
            return 1;
        }
        return  1 + Math.min(minJumpsRecursive(n-1), Math.min(minJumpsRecursive(n-2), minJumpsRecursive(n-3)));
    }

    public int minJumpsTopDown(int[] arr, int n){
        if( n == 0){
            return 0;
        }
        if(n == 1 || n == 2 || n == 3 ){
            return 1;
        }

        if(arr[n] == 0){
            arr[n] = 1 + Math.min(Math.min(minJumpsTopDown(arr, n-1), minJumpsTopDown(arr, n-2)), minJumpsTopDown(arr, n-3));
        }
        return arr[n];
    }

    public int minJumpsBottomUp(int n){
        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n; i ++){
            arr[i] = 1 + Math.min(arr[i -1], Math.min(arr[i-2],arr[i-3]));
        }
        return arr[n];
    }

    public int minJumpsBottomUpBetter(int n){
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;

        for(int i= 3; i <=n; i++){
            d = 1+ Math.min(Math.min(a, b), c);
            a = b;
            b = c;
            c = d;
        }
        return d;
    }

    public static void main(String[] args) {
        int n = 25;
        MinimumStairs minStairs = new MinimumStairs();
        System.out.println(minStairs.minJumpsRecursive(n));

        int[] arr = new int[n +1];
        System.out.println(minStairs.minJumpsTopDown(arr, n));

        System.out.println(minStairs.minJumpsBottomUp(n));
        System.out.println(minStairs.minJumpsBottomUpBetter(n));
    }
}
