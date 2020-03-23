package com.cake.hical;

import java.util.*;

public class Meeting {

    private int start;
    private int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return start == meeting.start &&
                end == meeting.end;
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public int getEnd() {

        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStart() {

        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /*
     *Write a method mergeRanges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.

     **For example, given:

     *  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

     *  your method would return:

     *  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
     */
    public static List<Meeting> mergeMeetings(List<Meeting> meetings) {
        if (meetings == null ||meetings.size() <= 1){
            return meetings;
        }
        List<Meeting> merged = new ArrayList<>();

        Collections.sort(meetings, Comparator.comparingInt(Meeting::getStart));
        Meeting meet = meetings.get(0);
        for(int i = 1; i < meetings.size(); i++){
            Meeting next = meetings.get(i);
            if (meet.end >= next.start){
                meet.end = Math.max(meet.end, next.end);
            } else {
                merged.add(meet);
                meet = next;
            }
        }
        merged.add(meet);

        return merged;
    }

    private static List<Meeting> createMeetingList(int[] meetingStartEnds){
        List<Meeting> meetings = new ArrayList<>();
        if(meetingStartEnds.length % 2 != 0){
            return meetings;
        } else {
            for(int i = 0; i < meetingStartEnds.length -1; i+=2) {
                Meeting meeting = new Meeting(meetingStartEnds[i], meetingStartEnds[i+1]);
                meetings.add(meeting);
            }
        }
        return meetings;
    }

    private static void mergeMeetingsAndPint(List<Meeting> meetings){
        List<Meeting> merged = mergeMeetings(meetings);
        for (Meeting meeting : merged){
            System.out.println(meeting);
        }
        System.out.println(merged.size());

    }

    public static void main(String[] args) {
        int[] meetingtimes = {0,1,3,5,4,8,10,12,9,10};
        List<Meeting> meetings = createMeetingList(meetingtimes);

        mergeMeetingsAndPint(meetings);


        int[] meetingtimes2 = {1, 2, 2, 3};
        meetings = createMeetingList(meetingtimes2);
        mergeMeetingsAndPint(meetings);

        int[] meetingtimes3 = {1,5, 2,3};
        meetings = createMeetingList(meetingtimes3);
        mergeMeetingsAndPint(meetings);

//        Meeting(1, 10), Meeting(2, 6), Meeting(3, 5), Meeting(7, 9)
        int[] meetingTimes4 = {1, 10, 2, 6, 3, 5, 7 , 9};
        meetings = createMeetingList(meetingTimes4);
        mergeMeetingsAndPint(meetings);

    }
}
