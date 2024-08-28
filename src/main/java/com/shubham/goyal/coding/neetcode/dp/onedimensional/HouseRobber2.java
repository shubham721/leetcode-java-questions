package com.shubham.goyal.coding.neetcode.dp.onedimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobber2 {

    public static void main(String[] args){
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] profit = new int[n];

        for(int i=0 ; i<n; i++){
            profit[i] = scanner.nextInt();
        }

        System.out.println(rob(profit));
    }

    private static int rob(int[] nums){

        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        int ans = -1;
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<n-1; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        ans = Math.max(ans, dp[n-2]);

        dp[0] = -50000;
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], Math.max(nums[i] + dp[i-2], nums[i]));
        }

        ans = Math.max(ans, dp[n-1]);

        return ans;

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
