package geekbang.fundamental;

import java.util.*;

/**
 * @author YC (shell845)
 * @date 19/1/2021 11:43 AM
 */

public class PlayGround {
     public static class Ball {
         int num;
         Ball(int n) {num = n;}
    }

    static class Parent {
        String song = "Parent";
        Ball ball = new Ball(5);

        public void sing() {
            System.out.println("Parent sings " + song + " and wins " + ball.num + " balls");
        }

        public void sing(String song) {
            System.out.println("Parent sings " + song);
        }

        public static void staticSing() {
            System.out.println("Parent static song ");
        }

        public static void staticSing(String song) {
            System.out.println("Parent static song " + song);
        }
    }

    static class Child extends Parent {
        String song = "Child";
        Ball ball = new Ball(10);

        @Override
        public void sing() {
            System.out.println("Child sings " + song + " and wins " + ball.num + " balls");
        }

        public void sing(String song) {
            System.out.println("Child sings " + song);
        }

        public static void staticSing() {
            System.out.println("Child static song");
        }

        public static void staticSing(String song) {
            System.out.println("Child static song " + song);
        }
    }

    public static void main(String args[]) {
         System.out.println("Test main overload");
    }


    public static void main(Integer i) {
        Parent parent = new Child();
        System.out.println(parent.song);
        parent.sing();
        parent.sing("a song");
        parent.staticSing();
        parent.staticSing("2 songs");
        System.out.println(parent.ball.num);


        Object o = "abc";
        String s = (String) o;
        System.out.println(s);
        System.out.println(o instanceof String);
        System.out.println(o.hashCode());


    }
}
