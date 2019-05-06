package com.leet.medianfinder;

import java.util.Collections;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num){
        if (minHeap.size() == 0 || num < maxHeap.peek()){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        rebalance();

    }

    private void rebalance(){
        PriorityQueue<Integer> biggerHeap = minHeap.size() >= maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> smallerHeap = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;
        if (biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public double findMedian(){

        if (minHeap.size() == maxHeap.size()){
            return (double)(minHeap.peek() +  maxHeap.peek())/2;
        } else if(minHeap.size() > maxHeap.size()){
            return (double)minHeap.peek();
        } else {
            return (double)maxHeap.peek();
        }

    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
    }
}
