package geekbang.fundamental;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author YC (shell845)
 * @date 19/1/2021 11:43 AM
 */

public class PlayGround {
    PlayGround() {
        System.out.println("PlayGround class constructor");
    }

    {
        System.out.println("PlayGround 123");
    }

    static {
        System.out.println("static PlayGround 123");
    }

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

    static {
        System.out.println("static 123");
    }

    class InnerClass {
        {
            System.out.println("InnerClass 123");
        }
         InnerClass(){System.out.println("InnerClass constructor");}
    }

    static class StaticInnerClass {
         StaticInnerClass(){System.out.println("StaticInnerClass constructor");}
    }

    void changeInteger(Integer i) {

    }

    public <E> void show_3(E t){
        System.out.println(t.toString());
    }

    public static <T> void main(String args[]) throws NoSuchMethodException {
//        System.out.println("start main");
//        PlayGround outerClass = new PlayGround();
//        InnerClass innerClass = outerClass.new InnerClass();
//        InnerClass innerClass2 = new PlayGround().new InnerClass();
//        StaticInnerClass staticInnerClass = new StaticInnerClass();

//        Integer a = 5;
//        Class<?> clazz = Integer.class;
//        System.out.println("getClass " + clazz.getClass());
//        Method[] methods = clazz.getMethods();
//        Method method = clazz.getMethod("equals", Object.class);
//        for (Method m : methods) System.out.println(m);
//        System.out.println("method " + method);

        Number[] elements = new Integer[3];
        // elements[0] = 3.1; run time error
        elements[1] = 1;

        ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();

        char[] arr = new char[128];
        Arrays.fill(arr, 'a');
        char c = 'a';
        c++;
        for (Object o : Arrays.asList("hello".toCharArray())) System.out.print(o + " ");
        //Set<Character> set = new HashSet<Character>("hello".toCharArray());
        System.out.println("".equals(""));

    }


    public static void main(Integer i) {
        Parent parent = new Child();
        System.out.println(parent.song);
        parent.sing();
        parent.sing("a song");
        parent.staticSing();
        parent.staticSing("2 songs");
        System.out.println(parent.ball.num);
    }
}
