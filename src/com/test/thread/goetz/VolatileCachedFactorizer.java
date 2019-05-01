package com.test.thread.goetz;

public class VolatileCachedFactorizer {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    public void service(String request, String response){

    }
}
