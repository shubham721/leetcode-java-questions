package com.shubham.goyal.coding.neetcode.dp.onedimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        List<String> words = new ArrayList<>();
        for(int i=0; i<n; i++){
            words.add(scanner.next());
        }
        System.out.println(wordBreak(s, words));
    }

    // It can also be done through recursion where we consider each possibility of adding the word in the dictionary and
    // recurse again for remaining substring in the string s.
    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
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
