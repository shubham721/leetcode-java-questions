package com.shubham.goyal.coding.neetcode.dp.onedimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromSubstring {

    public static void main(String[] args){

        FastScanner scanner = new FastScanner(System.in);
        String str = scanner.next();
        System.out.println(longestPalindrome(str));
    }


    // Time complexity: O(n^2) and space complexity: O(n^2)
    // you can also solve in O(1) space complexity using the approach by revolving around the centers.
    private static String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = false;
            }
        }

        int max_length=1;

        int start=0, end=0;
        int count=n;

        for(int i=0; i<n; i++){
            //mark for a single character, palindrome is true./
            dp[i][i] = true;
            // limited this loop to i, since i loop is only running till n-1
            for(int j=0; j<i; j++){
                if(s.charAt(i) == s.charAt(j) && (i-j <=2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    int length = i-j+1;
                    count = count+1;
                    if(max_length < length){
                        max_length = length;
                        start=j;
                        end=i;
                    }
                }
            }
        }
        return s.substring(start, end+1);
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
