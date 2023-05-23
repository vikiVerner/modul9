package MyHashMap;

import java.util.StringJoiner;


public class MyHashMap<K,V> {
    int counter;
    private Node<K,V> firstElement;
    private Node<K,V> lastElement;

    public void put(K key, V value){
        Node<K,V> element = new Node<K,V>();
        element.setKey(key);
        element.setValue(value);
        if(firstElement==null){
            firstElement = element;
        }else {
            lastElement = firstElement;
            while (lastElement.getNext() != null) {
               if(lastElement.getKey()!= key||key.equals(lastElement.getKey())) {
                   lastElement = lastElement.getNext();
               }else{
                   throw new IllegalArgumentException("key already exist");
               }
            }
            lastElement.setNext(element);
        }
        counter++;
    }
    public int size(){
        return counter;
    }

    public V get(K key){
        Node<K,V> search = new Node<K, V>();
        search = firstElement;
        V value = null;
        for(int i=0; i<size(); i++){
            if(search.getKey()==key||key.equals(search.getKey())){
                value =  search.getValue();
            }else{
                search = search.getNext();
            }
        } return  value;
    }

    public void remove(K key){
        Node<K,V> search = new Node<K, V>();
        if(counter==0){
            throw new NullPointerException("No existing pairs");
        }
        if(counter == 1){
//            firstElement = null;
            firstElement.setKey(null);
            firstElement.setValue(null);
            counter--;
            return;
        }
        search = firstElement;
        for(int i=0; i<size(); i++){
            if(search.getKey()==key||key.equals(search.getKey())){
                search.setValue(null);
                search.setKey(null);
                counter--;
            }else{
                search = search.getNext();
            }
        }
    }
    public  void clear(){
        Node<K,V> nextElement = new Node<K,V>();
        nextElement = firstElement;
        for(int i=0; i<size(); i++) {
           remove(nextElement.getKey());
           nextElement = nextElement.getNext();
        }
    }


   @Override
   public String toString(){
       StringJoiner result = new StringJoiner(", ");
       Node<K,V> element = firstElement;
       boolean a = firstElement.getKey() == null||firstElement.getKey().equals(null);
       if(counter == 1){
           if(!a){
           return "{"+firstElement.getKey()+"="+ firstElement.getValue()+"}";
           }
           else{
               return "[]";
           }
       }else{
           if(!a) {
               result.add("{" + element.getKey() + "=" + element.getValue() + "}");
           }
       }
       while(element.getNext()!=null){
           element = element.getNext();
           boolean b = element.getKey() == null||(element.getKey()).equals(null);
           if(!b) {
               result.add("{" + element.getKey() + "=" + element.getValue() + "}");
           }
       }
           return "[" + result + "]";
       }
}
