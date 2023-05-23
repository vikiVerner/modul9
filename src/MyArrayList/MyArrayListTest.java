package MyArrayList;

import java.util.ArrayList;

public class MyArrayListTest {

        public static void main(String[] args) {
            MyArrayList<String> list = new MyArrayList<String>();
            list.add("a");
            list.add("b");
            list.add("c");

            System.out.println("list = " + list);
            System.out.println("list.size() = " + list.size());
            System.out.println("list.get(0) = " + list.get(1));
            list.remove(1);
            System.out.println("list = " + list);
            list.clear();
            System.out.println("list = " + list);
        }
    }

