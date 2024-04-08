package com.shubham.goyal.coding;


/***
 * There are a list of tasks available for shyam to do. Shyam needs to book maximum profit by completing as much task as possible.
 *
 * you need to find maximum profit subset of tasks such that no two tasks overlap with each other.
 *
 *
 * Input: Number of tasks = 4
 *
 * Task Details: {Start time, End Time, Profit}
 *
 * Task 1 {1, 2, 50}
 *
 * Task 2 {3, 5, 20}
 *
 * Task 3 {6, 19, 100}
 *
 * Task 4 {2, 100, 200}
 *
 *
 * Output:
 *
 * maximum profit is 200.
 *
 * we can get the maximum profit by doing tasks 1 and 4.
 * https://www.geeksforgeeks.org/weighted-job-scheduling/
 */
public class WeightedJobScheduling {

    static class Job
    {
        int start, finish, profit;
        Job(int start, int finish, int profit)
        {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }


    static int findMaxProfitRec(Job arr[], int n)
    {
        return 0;
    }


    public static void main(String[] args) {

    }
}


