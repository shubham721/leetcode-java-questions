package com.shubham.goyal.coding.neetcode.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {


    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();

        int[] height = new int[n];

        for(int i=0; i<n; i++){
            height[i] = scanner.nextInt();
        }
        int ans = maxArea(height);

        System.out.println(ans);

    }


    private static int maxArea(int[] height) {

        int n = height.length;

        int start = 0;
        int end = n-1;

        int max_area = -1;

        while(start < end){
            int containerHeight = Math.min(height[start], height[end]);
            int width = end-start;
            max_area = Math.max(max_area, containerHeight*width);

            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }

        }
        return max_area;

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
