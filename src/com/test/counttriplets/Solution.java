package com.test.counttriplets;

/*
You are given an array and you need to find number of tripets of indices (i, j, k) such that the elements at those
indices are in geometric progression for a given common ratio r and i < j <k.

For example,arr = [1, 4, 16, 64] . If  r = 4, we have [1, 4, 16]  and [4, 16, 64] at indices (0, 1, 2) and (1, 2, 3).

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric
progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio.
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are (0, 1, 3) and (0, 2, 3)

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index (0, 1,2), (0, 1, 3), (1, 2, 4), (1, 3, 4) , (2, 4, 5)  and (3, 4, 5).

Sample Input 2

5 5
1 5 5 25 125
Sample Output 2

4
Explanation 2

The triplets satisfying are index (0, 1, 3), (0, 2, 3), (1, 3, 4), (2, 3, 4).
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {

    static boolean isOneOrMultiple(long x, long r){
        if (x == 1) return true;
        return x % r == 0;

    }
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        Map<Long, List<Long>> longPostions = new HashMap<>();
        List<Long> progression = new ArrayList<>();


        for (int i=0; i< arr.size(); i++){
            Long currentValue = arr.get(i);
            List<Long> values = longPostions.get(arr.get(i));
            if (values == null){
                values =  new ArrayList<>();
                longPostions.put(currentValue, values);
            }
            values.add((long)i);

            if (isOneOrMultiple(currentValue, r)){
                if (progression.indexOf(currentValue) < 0 &&
                        ( progression.size() == 0 ||
                                progression.get(progression.size() -1) * r == currentValue)) {
                    progression.add(currentValue);
                }
            }
        }

        int count = 0;
        // special case
        if (progression.size() == 1 && r == 1){
            count = longPostions.get(progression.get(0)).size();
        }

        for (int i = 0; i < progression.size()-2; i++){
            List<Long> triplet = progression.subList(i, i+3);
            count += longPostions.get(triplet.get(0)).size() * longPostions.get(triplet.get(1)).size()
                    * longPostions.get(triplet.get(2)).size();
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        System.out.println(System.getenv("OUTPUT_PATH"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);
        System.out.println(ans);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



