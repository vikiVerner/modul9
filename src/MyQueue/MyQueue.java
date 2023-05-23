package MyQueue;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyQueue <T>{
    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int index;
    public MyQueue()  {

        data = new Object[INIT_SIZE];
    }

    public void add(T value){
        resizeIfNeed();
        for (int i = index; i > 0 ; i--) {
            data[i] = data[i-1];
        }
        data[0] = value;
        index++;

    }
    private void resizeIfNeed() {
        if (index == data.length) {

            System.out.println("Resize happened, index: " + index + ", data.length: " + data.length);
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public int size(){
        return index;
    }
    public T peek(){ // first added element
        if(index == 0){
            throw new NoSuchElementException("Stack is empty.");
        }
        return (T) data[index-1];

    }
    public void clear(){
        for (int i = 0; i < index; i++) {
            data[i] = null;
        }
        index= 0;
    }
    public T poll() { // return and delete first added element
        T firstElement = peek();
        index--;
        data[index] = null;
        return firstElement;
    }
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }

        return "[" + result + "]";
    }
}
