package com.test.thread.taskgang;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SearchResults {

    public class Result{
        public int index;

        public Result(int index){
            this.index = index;
        }
    }

    public long threadId;
    public String word;
    public long cycle;
    public String inputData;
    protected List<Result> results;
    public AtomicLong atomicLong;

    public SearchResults(){
        results = null;
    }

    public SearchResults(long threadId, long cycle, String word, String inputData){
        this.threadId = threadId;
        this.cycle = cycle;
        this.word = word;
        this.inputData = inputData;
    }

    @Override
    public String toString() {
        return "[" + threadId + "|" + cycle + "] " + word + " at " + inputData;
    }
}
