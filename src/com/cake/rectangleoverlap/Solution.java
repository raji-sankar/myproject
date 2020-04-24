package com.cake.rectangleoverlap;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


        @Override
        public String toString() {
            return String.format("(left: %d, bottom: %d, width: %d, height: %d)",
                    leftX, bottomY, width, height);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Rectangle)) {
                return false;
            }
            final Rectangle r = (Rectangle) o;
            return leftX == r.leftX && bottomY == r.bottomY
                    && width == r.width && height == r.height;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + leftX;
            result = result * 31 + bottomY;
            result = result * 31 + width;
            result = result * 31 + height;
            return result;
        }
    }

    public static class XOverlap{
        private int startPoint;
        private int width;

        public XOverlap(int startPoint, int width){
            this.startPoint = startPoint;
            this.width = width;
        }

        public int getStartPoint(){
            return startPoint;
        }

        public int getWidth(){
            return width;
        }
    }

    public static class YOverlap{
        private int startPoint;
        private int height;

        public YOverlap(int startPoint, int height){
            this.startPoint = startPoint;
            this.height = height;
        }

        public int getStartPoint(){
            return startPoint;
        }

        public int getHeight(){
            return height;
        }
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {



        XOverlap xOverlap = findXOverlap(rect1.leftX, rect1.width, rect2.leftX, rect2.width);
        YOverlap yOverlap = findYOverlap(rect1.bottomY, rect1.height, rect2.bottomY, rect2.height);

        if(xOverlap.width == 0 || yOverlap.height == 0){
            return new Rectangle(0,0,0,0);
        }
        return new Rectangle(xOverlap.startPoint, yOverlap.startPoint, xOverlap.width, yOverlap.height);
    }

    public static XOverlap findXOverlap(int x1, int width1, int x2, int width2){

        int highestStartPoint = Math.max(x1, x2);
        int lowestEndPoint = Math.min(x1+width1,  x2+ width2);
        if(highestStartPoint >= lowestEndPoint){
            return new XOverlap(0,0);
        }

        int overlapWidth = lowestEndPoint - highestStartPoint;
        return new XOverlap(highestStartPoint, overlapWidth);
    }

    public static YOverlap findYOverlap(int y1, int height1, int y2, int height2){
        int highestStartPoint = Math.max(y1, y2);
        int lowestEndPoint = Math.min(y1+height1, y2+height2);

        if(highestStartPoint >= lowestEndPoint){
            return new YOverlap(0,0);
        }

        int overlapHeight = lowestEndPoint - highestStartPoint;
        return new YOverlap(highestStartPoint, overlapHeight);
    }



    // tests

    @Test
    public void overlapAlongBothAxesTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 6, 3), new Rectangle(5, 2, 3, 6));
        final Rectangle expected = new Rectangle (5, 2, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void oneRectangleInsideAnotherTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 6, 6), new Rectangle(3, 3, 2, 2));
        final Rectangle expected = new Rectangle(3, 3, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void bothRectanglesTheSameTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(2, 2, 4, 4), new Rectangle(2, 2, 4, 4));
        final Rectangle expected = new Rectangle(2, 2, 4, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void touchOnHorizontalEdgeTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 2, 3, 4), new Rectangle(2, 6, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void touchOnVerticalEdgeTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 2, 3, 4), new Rectangle(4, 3, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void touchAtCornerTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 2, 2), new Rectangle(3, 3, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void noOverlapTest() {
        final Rectangle actual = findRectangularOverlap(
                new Rectangle(1, 1, 2, 2), new Rectangle(4, 6, 3, 6));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
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
