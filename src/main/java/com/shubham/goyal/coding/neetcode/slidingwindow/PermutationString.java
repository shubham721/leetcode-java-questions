package com.shubham.goyal.coding.neetcode.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationString {


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);

        String s1 = scanner.next();
        String s2 = scanner.next();

        System.out.println(checkInclusion(s1, s2));

    }

    // we calculate frequency of every character in string s1. Then for each window in S2, we calculate the frequency of the
    // characters and see if it matches the same to s2. Rather then computing the frequency of window from scratch, we utilise the concept of
    // sliding window to do it in O(n) time.
    // Time complexity: O(26*n) = O(n)
    private static boolean checkInclusion(String s1, String s2) {

        int[] s1Array = new int[26];

        Arrays.fill(s1Array, 0);

        int l1 = s1.length();

        for (Character cr : s1.toCharArray()){
            s1Array[cr - 'a']++;
        }

        int l2 = s2.length();

        if(l2 < l1){
            return false;
        }

        int start = 0;
        int end = l1-1;

        int[] s2Array = new int[26];

        for(int i=0; i<l1; i++){
            s2Array[s2.charAt(i) - 'a']++;
        }

        while (end < l2){
            if(compatible(s1Array, s2Array)){
                return true;
            }
            s2Array[s2.charAt(start) - 'a']--;
            start++;
            end++;
            if(end < l2) {
                s2Array[s2.charAt(end) - 'a']++;
            }
        }

        return false;

    }

    private static boolean compatible(int[] s1, int[] s2){
        for(int i=0; i<26; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
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
