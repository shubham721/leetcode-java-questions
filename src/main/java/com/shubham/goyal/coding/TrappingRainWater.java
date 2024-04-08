package com.shubham.goyal.coding;

import java.io.*;
import java.util.StringTokenizer;


/***
 * https://leetcode.com/problems/trapping-rain-water/description/?source=submission-ac
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 */

public class TrappingRainWater {

    public static void main(String[] args) {

        FastScanner fastScanner = new FastScanner(System.in);

        int size = fastScanner.nextInt();

        int[] heights = new int[size];

        for(int i=0; i< size; i++){
            int nextHeight = fastScanner.nextInt();
            heights[i] = nextHeight;
        }

        System.out.println(trap2(heights));
    }


    // complexity
    // Time Complexity -> O(N)
    // Space complexity -> O(N)
    private static int trap(int[] height) {

        int totalTrap = 0;

        int size = height.length;

        int[] leftMax = new int[size];

        int[] rightMax = new int[size];

        leftMax[0] = height[0];

        for(int i=1; i<size; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[size-1] = height[size-1];

        for(int i=size-2 ; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for(int i=1; i<size-1 ; i++){
            int maxPossibleStored = Math.min(leftMax[i-1], rightMax[i+1]);
            if(maxPossibleStored > height[i]){
                totalTrap = totalTrap + (maxPossibleStored - height[i]);
            }
        }

        return totalTrap;
    }

    // This is a two pointer approach, where we keep track of max heights from left and right side. Idea is that if left side
    // height is less than right side, then we need to move forward from left side since the water would be spilled over from
    // the left side for forwarding indices.
    private static int trap2(int[] height) {

        int totalTrap = 0;

        int size = height.length;

        int leftMax = height[0];
        int rightMax = height[size-1];

        int leftPos = 1;

        int rightPos = size-2;

        while (leftPos <= rightPos){

            if(leftMax >= rightMax){
                totalTrap = totalTrap + Math.max(rightMax - height[rightPos], 0);
                rightMax = Math.max(rightMax, height[rightPos]);
                rightPos--;
            }else{
                totalTrap = totalTrap + Math.max(leftMax - height[leftPos], 0);
                leftMax = Math.max(leftMax, height[leftPos]);
                leftPos++;
            }

//            System.out.println(leftPos + " " + rightPos + " " + totalTrap);
        }

        return totalTrap;
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
