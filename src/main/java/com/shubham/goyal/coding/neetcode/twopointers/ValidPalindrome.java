package com.shubham.goyal.coding.neetcode.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);

        System.out.println(isPalindrome(scanner.nextLine()));


    }

    private static boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length()-1;

        while(start < end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            if(!((startChar>='a' && startChar <= 'z') || (startChar >= 'A' && startChar  <= 'Z') || (startChar >= '0' && startChar <= '9'))){
                start ++;
                continue;
            }

            if(!((endChar>='a' && endChar <= 'z') || (endChar >= 'A' && endChar  <= 'Z') || (endChar >= '0' && endChar <= '9'))){
                end--;
                continue;
            }

            if(startChar<= '9' && endChar <= '9' && Math.abs(startChar-endChar)!=0){
                return false;
            }

            if(Math.abs(startChar - endChar)!=0 && Math.abs(startChar - endChar) != 32){
                return false;
            }

            start++; end--;
        }

        return true;
    }

    static class FastScanner {
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
