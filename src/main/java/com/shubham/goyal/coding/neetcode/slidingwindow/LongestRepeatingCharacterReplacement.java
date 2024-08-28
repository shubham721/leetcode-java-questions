package com.shubham.goyal.coding.neetcode.slidingwindow;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        FastScanner scanner = new FastScanner(System.in);

        String s = scanner.next();

        int n = scanner.nextInt();

        System.out.println(characterReplacement(s, n));

    }


    // you can also solve this by a different approach. where in a particular window of i -> j, you found out the maximum
    // frequency of the character and the total characters. If the diff is greater than k, then you try to shrink the window.
    private static int characterReplacement(String s, int k) {

        int n = s.length();


        Set<Character> charSet = new HashSet<>();

        for(int i=0; i<n; i++){
            charSet.add(s.charAt(i));
        }

        int ans = 1;

        for (Character character : charSet) {
            int start = 0;
            int index = 0;
            int temp = k;
            while (index < n){
                if(s.charAt(index) != character){
                    if(temp==0){
                        while(s.charAt(start) == character && start < index){
                            start++;
                        }
                        start++;
                        index++;
                    }else{
                        temp--;
                        index++;
                    }
                }else {
                    index++;
                }
                ans = Math.max(ans, index-start);
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
