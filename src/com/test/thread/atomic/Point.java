package com.test.thread.atomic;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.StampedLock;

public class Point {

    private double x, y;

    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY){
        long stamp = sl.writeLock();

        try{
            x += deltaX;
            y += deltaY;
        }finally {
            sl.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin(){
        long stamp = sl.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        if (!sl.validate(stamp)){
            try {
                currentX = x;
                currentY = y;

            }finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY){
        long stamp = sl.readLock();
        try {
            while(x == 0.0 && y == 0.0){
                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0L){
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else{
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
