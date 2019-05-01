package com.test.thread.goetz;

import java.util.HashMap;
import java.util.Map;

public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized void setLocations(String id, int x, int y){
        MutablePoint loc = locations.get(id);
        if (loc == null){
            throw new IllegalArgumentException("No such id " + id);
        }
        loc.x = x;
        loc.y = y;
    }

    private static Map<String,MutablePoint> deepCopy(Map<String,MutablePoint> locations) {
        Map<String, MutablePoint> result = new HashMap<>();

        for(String key: locations.keySet()){
            result.put(key, new MutablePoint(locations.get(key)));
        }

        return result;
    }
}
