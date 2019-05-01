package com.test.thread.taskgang;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public abstract class TaskGang<E> implements Runnable{

    private volatile List<E> input = null;

    private Executor executor = null;

    private final AtomicLong currentCycle = new AtomicLong(0);


    protected List<E> getInput(){
        return input;
    }

    protected List<E> setInput(List<E> input){
        this.input = input;
        return  getInput();
    }

    protected void setExecutor(Executor executor){
        this.executor = executor;
    }

    protected Executor getExecutor(){
        return executor;
    }

    protected abstract List<E> getNextInput();

    protected void initiateHook(int inputSize){
        //No op
    }

    protected abstract void initiateTaskGang(int inputSize);

    protected boolean advanceTaskToNextCycle(){
        return false;
    }

    protected abstract void awaitTasksDone();

    protected void taskDone(int index) throws IndexOutOfBoundsException{
        //No op
    }

    protected abstract boolean processInput(E inputData);


    @Override
    public void run() {
        if(setInput(getNextInput()) != null){
            initiateTaskGang(getInput().size());

            awaitTasksDone();
        }
    }

    protected Runnable makeTask(final int index){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    E element = getInput().get(index);

                    if (processInput(element)){
                        taskDone(index);
                    } else {
                        return;
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
