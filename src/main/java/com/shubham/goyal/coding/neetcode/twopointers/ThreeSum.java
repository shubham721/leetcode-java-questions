package com.shubham.goyal.coding.neetcode.twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public static void main(String[] args) {


        FastScanner fastScanner = new FastScanner(System.in);

        int n = fastScanner.nextInt();

        int[] numbers = new int[n];

        for(int i=0; i<n; i++){
            numbers[i] = fastScanner.nextInt();
        }

        List<List<Integer>> results = threeSum(numbers);

        System.out.println(results.toArray());

    }



    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int length = nums.length-1;

        List<List<Integer>> results = new ArrayList<>();

        for(int i=0 ; i<length-1; i++){

            int j= i+1;
            int k= length;

            while( j< k){
                int sum = nums[i] + nums[j] + nums[k];
                if( sum == 0){
                    results.add(Arrays.asList(nums[i], nums[j],  nums[k]));
                    while(j+1<k && nums[j+1] == nums[j]){
                        j++;
                    }
                    while(k-1 > j && nums[k-1] == nums[k]){
                        k--;
                    }
                    j++; k--;
                }else if(sum > 0 ){
                    k--;
                }else{
                    j++;
                }
            }

            while(i<length-2 && nums[i+1] == nums[i]){
                i++;
            }

        }

        return results;

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
