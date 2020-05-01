package com.backtrack;

import java.util.*;

public class Maze {

    public static List<Integer> solveMaze(List<List<Integer>> maze, int start, int finish){
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        solveMaze(maze, start, finish, visited, path);
        path.add(0, start);
        return path;
    }

    private static boolean solveMaze(List<List<Integer>> maze, int start, int finish, Set<Integer> visited, List<Integer> path) {

        if(start == finish){
            return true;
        }

        visited.add(start);

        List<Integer> ends = maze.get(start);
        for(int i=0; i<ends.size(); i++){
            int current = ends.get(i);
            if(!visited.contains(current)) {
                if(solveMaze(maze, current, finish, visited, path)){
                    path.add(0, current);
                    return true;
                }
            }

        }

        return false;
    }

    private static void dfs(List<List<Integer>> maze, int start, Set<Integer> visited, List<Integer> path){

        visited.add(start);
        List<Integer> ends = maze.get(start);
        for(int i=1; i<ends.size(); i++){

            if(!visited.contains((ends.get(i)))){
                dfs(maze, ends.get(i), visited, path);

            }
            path.add(0, start);
        }

    }

    public static List<List<Integer>> allPaths(List<List<Integer>> maze){
        //given a maze -return all possible paths
        List<List<Integer>> paths = new ArrayList<>();
        for(int i=0; i<maze.size(); i++){
            List<Integer> path = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            dfs(maze, maze.get(i).get(0), visited, path);

            paths.add(path);
        }

        return paths;
    }

    public static List<Integer> longestPath(List<List<Integer>> maze){
        List<List<Integer>> paths = allPaths(maze);
        int max = -1;
        int maxIndex = -1;

        for(int i=0; i< paths.size(); i++){
            List<Integer> path = paths.get(i);
            max = Math.max(path.size(), max);
            if(max == path.size()){
                maxIndex = i;
            }
        }

        return paths.get(maxIndex);
    }


    public static void main(String[] args) {

        List<List<Integer>> maze = new ArrayList<>();

        maze.add(Arrays.asList(new Integer[] {0,1,3}));
        maze.add(Arrays.asList(new Integer[] {1, 0, 2}));
        maze.add(Arrays.asList(new Integer[]{2, 1}));
        maze.add(Arrays.asList(new Integer[]{3, 0, 4, 6}));
        maze.add(Arrays.asList(new Integer[]{4, 3, 5, 7}));
        maze.add(Arrays.asList(new Integer[]{5, 4}));
        maze.add(Arrays.asList(new Integer[]{6, 3}));
        maze.add(Arrays.asList(new Integer[]{7, 4, 8}));
        maze.add(Arrays.asList(new Integer[]{8, 7}));

        List<Integer> path = solveMaze(maze, 0, 8);

        path.stream().forEach(System.out::println);

        List<Integer> longestPath = longestPath(maze);
        longestPath.stream().forEach(System.out::println);


    }
}
