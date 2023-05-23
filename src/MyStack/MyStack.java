package MyStack;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MyStack<T> {
    private static final int INIT_SIZE = 8;
    private Object[] data;
    private int index;
    public MyStack()  {

        data = new Object[INIT_SIZE];
    }
    public void push(T value){
        resizeIfNeed();
        data[index] = value;
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
    public T peek(){
        if(index == 0){
            throw new NoSuchElementException("Stack is empty.");
        }
        return (T) data[0];
    }

    public T pop() {
        T firstElement = peek();
        remove(0);
        return firstElement;
        }

    public int size(){
        return index;
    }

    public void remove(int elementIndex){
        indexCheck(elementIndex);
        int i = index-elementIndex-1;
        int counter = 0;
        if(elementIndex>= index){
            throw new ArrayIndexOutOfBoundsException("Wrong index "+index);
        }
        if (i > 0) {
            for (int j = 0; j < index; j++) {
                if(j!=elementIndex) {
                data[counter] = data[j];
                counter++;
                }
                }

            }
        index--;
        data[index] = null;
        }

    public void indexCheck(int i){
        if(i<0 || i>=size()){
            throw new IndexOutOfBoundsException("Index should be in range of list length. List length = "+index++);
        }
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++) {
            result.add(data[i].toString());
        }

        return "[" + result + "]";
    }
    public void clear() {
        for(int i = index-1; i>-1; i--){
            remove(i);
        }
    }
}
