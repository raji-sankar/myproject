package com.test.td.task2;
/*
An interval is a pair (A, B) of integers such that A <= B. Two intervals (A,B) and (C,D) overlap if there
exists an integer L such that A <= L <= B and C <= L <= D. Intervals that do not overlap are called
disjoint. The union of intervals (A,B) and (C,D) is defined as:
1. either a single interval (min(A,C), max(B, D)) when (A,B) and (C,D) overlap, or
2. intervals (A,B) and (C, D) when they are disjoint

Taking the union of tow intervals is a commutative and associative operation is it can be extended to an
arbitrary number of intervals.

For example, consider the following 8 interval:
(1, 5), (12, 15), (42, 44), (70, 72), (36, 36), (-4, 2),
(43, 69), (15, 24)

(1, 5) U (-4, 2) = (-4, 5)
(12, 15) U (15, 24) = (12, 24)
(42, 44) U (43, 69) = (42, 69)

Union of all eight (-4, 5), (12, 24), (36, 36), (42, 69), (70, 72)

Given 2 arrays A and B consisting of N elements each, returns a pairwise disjoint intervals constituting the union
of N intervals described by arrays A and B. The K-th interval where K is an integer within the range [0..(N-1)] is
defined as (A(K), B(K)).
A = {1, 12, 42, 70, 36, -4, 43, 15}
B = {5, 15, 44, 72, 36, 2, 69, 24}

The function should return 5, because the union has 5 disjoint intervals.

Assume that
1. N is an integer within the range [0..100,000]
2. each elment of arrays A,B is an integer within the range [-1,000,000,000..1,000,000,000]

Complexity:
1.expected worst-case time complexity is O(N*log(N))
2. expected worst-case space complexity is O(N)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    class Interval{
        int begin;
        int end;

        public Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + begin +
                    ", " + end +
                    ')';
        }
    }

    class IntervalSorter implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.begin - o2.begin ;
        }
    }

    public List<Interval> unionTwoIntervals(Interval interval1, Interval interval2){
        List<Interval> union = new ArrayList<>();
        if ((interval1.begin <= interval2.begin)  && (interval1.end >= interval2.end)){
            Interval newInterval = new Interval(interval1.begin, interval2.end);
            union.add(newInterval);
        } else if (((interval1.begin > interval2.begin)  && (interval1.end <= interval2.end))){
            Interval newInterval = new Interval(interval2.begin, interval1.end);
            union.add(newInterval);

        } else {
            union.add(interval1);
            union.add(interval2);
        }

        return union;
    }

    public void unionIntervals(List<Interval> intervals, Interval interval2){
        Interval interval1 = intervals.get(intervals.size()-1);
        if ((interval1.begin <= interval2.begin)  && (interval1.end <= interval2.end)  && (interval2.begin <= interval1.end)) {
            Interval newInterval = new Interval(interval1.begin, interval2.end);
            intervals.remove(interval1);
            intervals.add(newInterval);
        } else if ( (interval1.begin <= interval2.begin) &&(interval1.end > interval2.end))   {
            //do nothing

        } else {

            intervals.add(interval2);
        }

    }

    public int not_performant_solution(int[] A, int[] B) {

        if (A.length == 0){
            return -1;
        }

        if(A.length != B.length){
            return -1;
        }

        //1. Construct the intervals
        Interval[] intervals = new Interval[A.length];

        for(int i=0; i < A.length; i++){
            intervals[i] = new Interval(A[i], B[i]);
        }

        //2. Sort the arrays based on interval.begin
        Arrays.sort(intervals, new IntervalSorter());

        //3. Union the intervals
        List<Interval> union = new ArrayList<>();
        union.add(intervals[0]);

        for (int i=1; i < intervals.length; i++){
            unionIntervals(union, intervals[i]);
        }
        return union.size();
    }


    public int solution(int[] A, int[] B) {

        if (A.length == 0){
            return -1;
        }

        if(A.length != B.length){
            return -1;
        }

        //1. Construct the intervals
        Interval[] intervals = new Interval[A.length];

        for(int i=0; i < A.length; i++){
            intervals[i] = new Interval(A[i], B[i]);
        }

        //2. Sort the arrays based on interval.begin
        Arrays.sort(intervals, new IntervalSorter());
        System.out.println(Arrays.toString(intervals));

        //3. Union the intervals
        List<Interval> union = new ArrayList<>();
        int begin = intervals[0].begin;
        int end = intervals[0].end;



        for (int i=1; i < intervals.length; i++){
            Interval current = intervals[i];


            if(current.begin <= end){
                end = Math.max(current.end, end);
            } else {
                union.add(new Interval(begin, end));
                begin = current.begin;
                end = current.end;
            }
        }

        union.add(new Interval(begin, end));
        System.out.println(union);
        return union.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1, 12, 42, 70, 36, -4, 43, 15}, new int[]{5, 15, 44, 72, 36, 2, 69, 24} ));
        System.out.println(sol.solution(new int[] {1, 2, 5}, new int[]{5, 3, 10} ));
    }

}
