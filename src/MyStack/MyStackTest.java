package MyStack;

import java.util.Stack;

public class MyStackTest {

    public static void main(String[] args) {
        MyStack <String> s = new MyStack<String>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");

        System.out.println("s = " + s);
        System.out.println("s.pop() = " + s.pop());
        System.out.println("s.peek() = " + s.peek());
        System.out.println("s = " + s);
        System.out.println("s.size() = " + s.size());
        s.remove(0);
        System.out.println("s = " + s);
        s.clear();
        System.out.println("s = " + s);

    }

}
