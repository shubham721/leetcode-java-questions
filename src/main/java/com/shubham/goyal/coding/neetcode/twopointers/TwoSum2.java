package com.shubham.goyal.coding.neetcode.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSum2 {


    public static void main(String[] args) {

        FastScanner fastScanner = new FastScanner(System.in);

        int n = fastScanner.nextInt();

        int[] numbers = new int[n];

        for(int i=0; i<n; i++){
            numbers[i] = fastScanner.nextInt();
        }

        int target = fastScanner.nextInt();

        int[] result = twoSum(numbers, target);

        System.out.println(Arrays.stream(result).toArray().toString());

    }


    private static int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length-1;

        while(start < end){
            if(numbers[start] + numbers[end] > target){
                end--;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else{
                break;
            }
        }
        if(start >= end){
            start=-1;
            end=-1;
        }
        return new int[]{start+1, end+1};
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
