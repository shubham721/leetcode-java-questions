package com.shubham.goyal.coding.neetcode.dp.onedimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxProductSubArray {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1];
        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(maxProduct(nums));
    }


    private static int maxProduct2(int[] nums){
        int n = nums.length;
        int max, min, ans;
        max = nums[0];
        min = nums[0];
        ans = nums[0];

        for(int i=1; i<n; i++){
            int temp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            ans = Math.max(ans, Math.max(max, min));
        }

        return ans;
    }

    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int pos = 1;
        int neg = 1;

        for(int i=0; i<n; i++){
            if(nums[i]==0){
                pos=1;
                neg=1;
                ans = Math.max(ans, 0);
            }else if(nums[i]>0){
                pos = pos * nums[i];
                neg = neg * nums[i];
                ans = Math.max(ans, pos);
            }else if(nums[i] < 0){
                ans = Math.max(ans, neg*nums[i]);
                if(neg * nums[i] > 0){
                    int temp = pos;
                    pos = neg * nums[i];
                    neg = temp * nums[i];
                }else{
                    neg = pos * nums[i];
                    pos=1;
                }
            }
        }

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
