package com.practice.dp;

public class DPFunctions {

    public int getFibonacci(int n){
        if (n < 2){
            return n;
        }
        return getFibonacci(n-1) + getFibonacci(n -2);
    }

    public int getFibonacciTopDown(int[] arr, int n){
        if (n < 2){
            return n;
        }
        if(arr[n] == 0){
            arr[n] = getFibonacciTopDown(arr, n -1) + getFibonacciTopDown(arr, n-2);
        }
        return arr[n];
    }

    public int getFibonacciBottomUp1(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for(int i =2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }


        public int getFibonacciBottomUp2(int n){
        int a = 0;
        int b = 1;
        int c;

        for(int i = 2; i <= n; i ++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 7;
        DPFunctions a = new DPFunctions();
        System.out.println(a.getFibonacci(n));

        int[] arr = new int[n+1];
        System.out.println(a.getFibonacciTopDown(arr, n));

        System.out.println(a.getFibonacciBottomUp1(n));

        System.out.println(a.getFibonacciBottomUp2(n));

    }
}
