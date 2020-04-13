package com.practice.dp;

public class NthStair {

    public int waysToNthStairRecursive(int n){
        if(n == 0  || n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return  waysToNthStairRecursive(n -1) + waysToNthStairRecursive(n -2) + waysToNthStairRecursive(n - 3);
    }

    public int waysToNthStairTopDown(int[] arr, int n){
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        if(arr[n] == 0){
            return arr[n] = waysToNthStairTopDown(arr, n-1) + waysToNthStairTopDown(arr, n-2)  + waysToNthStairTopDown(arr, n-3);
        }
        return arr[n];
    }

    public int waysToNthStairBottomUp(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for(int i =3; i <=n; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        return arr[n];
    }

    public int waysToNthStairBottomUpOptimized(int n){
        int a = 1;
        int b = 1;
        int c = 2;
        int d = 0;

        for (int i = 3; i <= n; i ++){
            d = a+b+c;
            a = b;
            b = c;
            c = d;
        }
        return d;


    }


    public static void main(String[] args) {
        NthStair nthStair = new NthStair();
        int n = 5;
        System.out.println(nthStair.waysToNthStairRecursive(n));

        int[] arr = new int[n + 1];
        System.out.println(nthStair.waysToNthStairTopDown(arr, n));

        System.out.println(nthStair.waysToNthStairBottomUp(n));
        System.out.println(nthStair.waysToNthStairBottomUpOptimized(n));

    }
}
