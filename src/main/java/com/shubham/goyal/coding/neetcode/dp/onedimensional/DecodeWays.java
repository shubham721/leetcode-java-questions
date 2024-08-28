package com.shubham.goyal.coding.neetcode.dp.onedimensional;

public class DecodeWays {

    public static void main(String[] args) {

    }


    private static int numDecodings(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                dp[i][j]=-1;
            }
        }
        return helper(dp, s, 0, n, 0);
    }

    private static int helper(int[][] dp, String s, int curr, int n, int shouldContinue){

        if(curr == n ){
            if(shouldContinue==0)
                return 1;
            else
                return 0;
        }

        if(dp[curr][shouldContinue]!=-1)
        {
            return dp[curr][shouldContinue];
        }

        if(s.charAt(curr) == '0' && shouldContinue==0){
            return 0;
        }

        int c = (int) s.charAt(curr)-'0';

        int ans;

        if(shouldContinue==1){
            int prev = (int) s.charAt(curr-1) - '0';
            int afterAddition = prev*10 + c;
            if(afterAddition > 26){
                return 0;
            }
            ans =helper(dp, s, curr+1, n, 0);
        }else{
            ans = helper(dp, s, curr+1, n, 0) + helper(dp, s, curr+1, n, 1);
        }

        dp[curr][shouldContinue]=ans;

        return ans;
    }

    private static int helper2(String s){
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        /***
         * Setting dp[0] = 1 and dp[1] = 1 serves as the base cases for the dynamic programming approach. Here's why:
         *
         *     dp[0] = 1: This is necessary because an empty string can be decoded in one way,
         *     which is to not decode anything. It serves as the base case for the recursion: if the string is empty,
         *     there is one way to decode it (i.e., no decoding).
         *
         *     dp[1] = 1: This is needed because if the string has only one character,
         *     it can be decoded in one way if it is not '0' (since '0' cannot be mapped to any letter).
         *     If the first character is '0', then it cannot be decoded, so there are zero ways to decode it.
         *     Therefore, dp[1] is set to 1 initially, assuming the first character is not '0', and it will be
         *     adjusted if necessary during the iteration.
         *
         * dp[n] is the solution for till nth character in the string.
         */
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }


}
