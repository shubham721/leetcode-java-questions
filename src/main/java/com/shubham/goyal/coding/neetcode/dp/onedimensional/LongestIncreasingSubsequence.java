package com.shubham.goyal.coding.neetcode.dp.onedimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();

        }
        System.out.println(lengthOfTLSOptimized(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 1;
        }
        int[] dp = new int[n];
        int maxi=1;
        Arrays.fill(dp, 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxi = Math.max(dp[i], maxi);
                }
            }
        }
        return maxi;
    }


    // solved in O(Nlogn) https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    private static int lengthOfTLSOptimized(int[] nums){
        int n = nums.length;
        if(n==1){
            return 1;
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);

        for(int i=1; i<n; i++){
            if(nums[i] > arr.get(arr.size()-1)){
                arr.add(nums[i]);
            }else{
                int index = Collections.binarySearch(arr, nums[i]);
                if(index<0){
                    // in case the key is not find in binary search, the collection method returns a (-insertionPoint-1)
                    index=-(index+1);
                }
                arr.set(index, nums[i]);
            }
        }

        return arr.size();
    }

    private static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken("\n");
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
