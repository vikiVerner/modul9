package MyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("Alfa");
        list.add("Beta");
        list.add("Gamma");
        System.out.println("list.size() = " + list.size());
        System.out.println("list = " + list);
        list.get(1);
        list.remove(0);
        System.out.println("list = " + list);
        System.out.println("list.get(1) = " + list.get(1));
        list.clear();
        System.out.println("list = " + list);
    }
}
