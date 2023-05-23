package MyHashMap;

import java.util.HashMap;
import java.util.Map;

public class MyHashMapTest {
    public static void main(String[] args) {
       MyHashMap<String,Integer> m = new MyHashMap<String, Integer>();
        m.put("a",1);
        m.put("b",2);
        m.put("c",3);
        System.out.println("m = " + m);
        m.remove("b");
        System.out.println("m = " + m);
        System.out.println("m.get(\"b\") = " + m.get("b"));
        System.out.println("m.size() = " + m.size());
        m.clear();
        System.out.println("m.size() after clear = " + m.size());
        System.out.println("m = " + m);
    }
}
