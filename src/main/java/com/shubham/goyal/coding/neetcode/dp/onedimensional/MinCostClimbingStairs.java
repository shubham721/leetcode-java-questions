package com.shubham.goyal.coding.neetcode.dp.onedimensional;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner(System.in);

        int n = fastScanner.nextInt();
        int[] cost = new int[n];

        for(int i=0 ; i<n; i++){
            cost[i] = fastScanner.nextInt();
        }

        System.out.println(minCostClimbingStairs(cost));

    }

    private static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<n; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        dp[n] = Math.min(dp[n-1], dp[n-2]);

        return dp[n];
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
