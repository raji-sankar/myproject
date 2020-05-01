package com.leet.minarea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x){
                return x - o.x;
            } else {
                return y - o.y;
            }

        }
    }
    public int minAreaRect(int[][] points) {

        List<Point> pointz = new ArrayList<>();
        for(int[] p: points){
            Point point = new Point(p[0], p[1]);
            pointz.add(point);
        }

        pointz.sort(null);

        List<List<Point>> rectangles = new ArrayList<>();

        generateRectangles(0, pointz, new ArrayList<>(), rectangles);

        int min = Integer.MAX_VALUE;

        for(List<Point> rectangle: rectangles){
            Point p1 = rectangle.get(0);
            Point p2 = rectangle.get(1);
            Point p3 = rectangle.get(2);
            Point p4 = rectangle.get(3);
            int area = (p3.x - p1.x) * (p2.y - p1.y);
            min = Math.min(min, area);
        }

        return min;
    }

    private boolean isARectangle(List<Point> polygon){
        if (polygon.size() != 4){
            return false;
        }
        List<Point> rect = new ArrayList<>(polygon);
        rect.sort(null);
        Point p1 = rect.get(0);
        Point p2 = rect.get(1);
        Point p3 = rect.get(2);
        Point p4 = rect.get(3);

        return (p1.x == p2.x && p1.y == p3.y && p2.y == p4.y && p3.x == p4.x);

    }

    //generate subsets of 4 points each
    private void generateRectangles(int index, List<Point> points, List<Point> current, List<List<Point>> rectangles){
        if(isARectangle(current)){
            rectangles.add(new ArrayList<>(current));
        }

        for(int i= index; i < points.size(); i++){
            current.add(points.get(i));
            generateRectangles(i+1, points, current, rectangles);
            current.remove(current.size() -1);
        }

    }

    public static void main(String[] args) {
//        int points[][] = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        int points[][] = {{26737,17514},{22235,25740},{3813,25740},{26737,7819},{29299,28174},{26737,8831},{22235,17514},{22236,28174},{35250,7819},{22236,8831},{29299,19727},{3813,17514},{22236,7819},{22235,1333},{35250,19727},{35250,28174},{22236,19727},{3813,19727},{35250,8831},{3813,8831},{35250,25740},{3813,28174},{29299,25740},{3813,1333},{29299,8831},{36784,7819},{36784,8831},{22235,28174},{3813,7819},{26737,1333},{29299,1333},{29299,7819},{36784,25740}};
        System.out.println(points.length);
        Solution sol = new Solution();
        System.out.println(sol.minAreaRect(points));
    }
}
