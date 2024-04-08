package com.shubham.goyal.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total profit if only one job can be scheduled at a time.
 */

/***
 * Shyam has given a list of jobs. If he is doing a job then he needs to complete it before the deadline. Every job has its associated income with the job.
 * It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. Maximize the total income that shyam can earn.
 *
 * a, 2, 100
 *
 * b, 1, 19
 *
 * c, 2, 27
 *
 * d, 1, 25
 *
 * e, 3, 15
 */
public class JobSequencingProblem {


    public static void main(String[] args) {

        List<Job> arr = new ArrayList<Job>();
        arr.add(new Job("a", 2, 100));
        arr.add(new Job("b", 1, 19));
        arr.add(new Job("c", 2, 27));
        arr.add(new Job("d", 1, 25));
        arr.add(new Job("e", 3, 15));

        System.out.println(maxProfit2(arr));

    }


    private static int maxProfit(List<Job> jobList){

        int totalProfit = 0;

        int maxDeadline = jobList.stream().mapToInt(job -> job.deadline).max().orElseThrow();

        int[] arr = new int[maxDeadline];

        Collections.sort(jobList, (job1, job2) -> job2.profit - job1.profit);

        int size = jobList.size();

        for(int i=0; i<size; i++){

            int currentJobDl = jobList.get(i).deadline - 1;

            int j = currentJobDl;

            while(j>=0 && arr[j]!=0){
                j--;
            }

            if(j>=0){
                arr[j]=1;
                totalProfit += jobList.get(i).profit;
            }

        }

        return totalProfit;

    }


    private static int maxProfit2(List<Job> jobList){


        int totalProfit = 0;

        Collections.sort(jobList, (job1, job2) -> job2.deadline - job1.deadline);

        int slots;

        int size = jobList.size();

        PriorityQueue<Job> priorityQueue = new PriorityQueue<>((job1, job2) -> job2.profit - job1.profit);

        for(int i=0; i<size ; i++){

            if(i==size-1){
                slots = jobList.get(i).deadline;
            }else{
                slots = jobList.get(i).deadline - jobList.get(i+1).deadline;
            }

            priorityQueue.add(jobList.get(i));

            while (slots>0 && priorityQueue.size() > 0){

                int profit = priorityQueue.remove().profit;

                totalProfit = totalProfit + profit;

                slots--;

            }

        }

        return totalProfit;

    }





    static class Job{

        private String id;

        private int deadline;

        private int profit;

        public Job(String id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

    }


    static class Scanner{

        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public Scanner(InputStream in){
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next(){
            try {
                if(tokenizer == null || !tokenizer.hasMoreTokens()){
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                return tokenizer.nextToken();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        public String nextLine(){
            try {
                if(tokenizer == null || !tokenizer.hasMoreTokens()){
                    return reader.readLine();
                }
                return tokenizer.nextToken("\n");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        private Long nextLong(){
            return Long.parseLong(next());
        }

    }

}
