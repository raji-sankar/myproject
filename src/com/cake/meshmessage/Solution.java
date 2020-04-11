package com.cake.meshmessage;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users
        // bfs to find the shortest path
        //use a Set to keep track of nodes visited

        if(graph.get(startNode) == null || graph.get(endNode) == null){
            throw new IllegalArgumentException("Start/end node is not valid");
        }

        List<String> path = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Map<String, String> parents = new HashMap<>();
        seen.add(startNode);
        Deque<String> queue = new ArrayDeque<>();
        queue.push(startNode);
        while(!queue.isEmpty()){
            String v = queue.pop();
            if(v.equals(endNode)){
                findPath(startNode, endNode, parents, path);
                return path.toArray(new String[0]);
            }
            for(String u : graph.get(v)){
                if(!seen.contains(u)){
                    queue.push(u);
                    seen.add(u);
                    parents.put(u, v);
                }
            }
        }

        return null;

    }

    private static void findPath(String startNode, String endNode, Map<String, String> parents, List<String> path){
        if(startNode.equals(endNode)){
            path.add(startNode);
            return;
        }else {
            String newEndNode = parents.get(endNode);
            findPath(startNode, newEndNode, parents, path);
            path.add(endNode);
        }

    }



    private static Map<String, String[]> getNetwork() {
        return new HashMap<String, String[]>() { {
            put("a", new String[] {"b", "c", "d"});
            put("b", new String[] {"a", "d"});
            put("c", new String[] {"a", "e"});
            put("d", new String[] {"a", "b"});
            put("e", new String[] {"c"});
            put("f", new String[] {"g"});
            put("g", new String[] {"f"});
        }};
    }





    // tests

    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        getPath(getNetwork(), "a", "h");
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
