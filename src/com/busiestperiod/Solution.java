package com.busiestperiod;

/**
 * Busiest Time in The Mall
 * The Westfield Mall management is trying to figure out what the busiest moment at the mall was last year. You’re given data extracted from the mall’s door detectors. Each data point is represented as an integer array whose size is 3. The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and whether the visitors entered or exited the mall (0 for exit and 1 for entrance), respectively. Here’s an example of a data point: [ 1440084737, 4, 0 ].
 *
 * Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
 *
 * Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return the earliest one.
 *
 * Assume that the array data is sorted in an ascending order by the timestamp. Explain your solution and analyze its time and space complexities.
 *
 * Example:
 *
 * input:  data = [ [1487799425, 14, 1],
 *                  [1487799425, 4,  0],
 *                  [1487799425, 2,  0],
 *                  [1487800378, 10, 1],
 *                  [1487801478, 18, 0],
 *                  [1487801478, 18, 1],
 *                  [1487901013, 1,  0],
 *                  [1487901211, 7,  1],
 *                  [1487901211, 7,  0] ]
 *
 * output: 1487800378 # since the increase in the number of people
 *                    # in the mall is the highest at that point
 * Constraints:
 *
 * [time limit] 5000ms
 *
 * [input] array.array.integer data
 *
 * 1 ≤ data.length ≤ 100
 * [output] integer
 */

public class Solution {

    static int findBusiestPeriod(int[][] data) {
        // your code goes here
        //[[1,5,0],[2,10,1],[2,0,12]]

        //
        //[[1487799425,21,0->exit],[1487799427,22,1->enter],[1487901318,7,0]]
        int busiestTime = data[0][0];
        int count = 0;
        int prevCount = 0;
        int current = 0;
        for(int i=0; i<data.length; i++){
            if (current != data[i][0]){
                busiestTime = count > prevCount ? current : busiestTime;
                current = data[i][0];
                prevCount = Math.max(count, prevCount);
            }
            if(data[i][2] == 0){
                count -= data[i][1];
            } else {
                count += data[i][1];
            }
        }
        busiestTime = count > prevCount ? current : busiestTime;

        return busiestTime;
    }

    public static void main(String[] args) {

        int[][] data = new int[3][3];
        data[0] = new int[]{1487799425,21,0};
        data[1] = new int[]{1487799427,22,1};
        data[2] = new int[]{1487901318,7,0};

        System.out.println(findBusiestPeriod(data));


    }

}
