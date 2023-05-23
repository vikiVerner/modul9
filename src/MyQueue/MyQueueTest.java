package MyQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MyQueueTest {
    public static void main(String[] args) {
        //Queue<String> names = new ArrayDeque<>();
        MyQueue<String> names = new MyQueue<String>();
            names.add("John");
            names.add("Bill");
            names.add("Sasha");
        System.out.println("names = " + names);
        System.out.println("names.size() = " + names.size());
        names.poll();
        System.out.println("names after poll = " + names);
        names.clear();
        System.out.println("names = " + names);
    }
}
