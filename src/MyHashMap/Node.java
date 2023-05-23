package MyHashMap;

public class Node<K,V> {
    private V value;
    private K key;

    private Node<K,V> next;
    public K getKey(){
        return key;
    }
    public void setKey(K key){
        this.key = key;
    }

    public V getValue() {

        return value;
    }
    public void setValue(V value) {

        this.value = value;
    }
    public Node<K,V> getNext() {

        return next;
    }
    public void setNext( Node<K,V>  next) {

        this.next = next;
    }
}
