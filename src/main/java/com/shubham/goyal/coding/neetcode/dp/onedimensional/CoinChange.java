package com.shubham.goyal.coding.neetcode.dp.onedimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinChange {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = scanner.nextInt();
        }

        int amount = scanner.nextInt();

        System.out.println(coinChange2(coins, amount));

    }

    private static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = helper(coins, dp, amount);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    private static int coinChange2(int[] coins, int amount){
        int n = coins.length;
        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0]=0;

        for(int i=1; i<=amount; i++){
            for(int j=0; j<n; j++){
               if(i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE){
                   dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    private  static int helper(int[] coins, int[] dp, int remainingSum){

        int n = coins.length;

        if(remainingSum == 0){
            return 0;
        }

        if(dp[remainingSum] != Integer.MAX_VALUE){
            return dp[remainingSum];
        }

        for(int i=0; i<n; i++){
            if(remainingSum >= coins[i]){
                int result = helper(coins, dp, remainingSum - coins[i]);
                if(result!=Integer.MAX_VALUE){
                    dp[remainingSum] = Math.min(dp[remainingSum], result+1);
                }
            }
        }

        return dp[remainingSum];
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
