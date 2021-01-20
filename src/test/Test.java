package test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author YC 03/25/2020
 */

public class Test {

    public void testRemove2(){
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        for (String string : strings) {
            strings.remove(string);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new HashSet[numCourses];
        for (Set set : graph) set = new HashSet<Integer>();
        for (int[] pair : prerequisites) {
            System.out.println(Arrays.toString(pair) + " " + pair[0] + " " + pair[1]);
            graph[pair[0]].add(pair[1]);
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int b = 1;
        int c = (a + b) >> 1;
        System.out.print((a & b) + ((a ^ b) >> 1));
    }

}

