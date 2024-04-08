package com.shubham.goyal.coding.neetcode.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindrome2 {

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);

        System.out.println(isPalindromeAfterRemovingOneChar(scanner.nextLine()));
    }

    private static boolean isPalindrome(String s, int low, int high){
        int start =low;
        int end = high;
        while(start < end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeAfterRemovingOneChar(String s) {

        int start = 0;
        int end = s.length()-1;

        while(start < end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else if(isPalindrome(s, start+1, end)){
                return true;
            }else if(isPalindrome(s, start, end-1)){
                return true;
            }else {
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
