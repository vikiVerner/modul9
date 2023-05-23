package MyArrayList;

import java.util.StringJoiner;

public class MyArrayList <T>{
        private static final int INIT_SIZE = 8;
        private Object[] data;
        private int index;

        public MyArrayList() {

            data = new Object[INIT_SIZE];
        }

        public void add(T value) {
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

        public T get(int i) {
            indexCheck(i);
            return (T) data[i];
        }
        public int size() {

            return index;
        }
        public void remove(int elementIndex){
            indexCheck(elementIndex);
            Object[] newData = new Object[index-1];
            int counter = 0;
            if(elementIndex!= index-1){
            for(int i=0; i< index; i++){
                if (i!=elementIndex){
                    newData[counter] = data[i];
                    counter++;
                }
            }
            }
            index--;
            data[index] = null;
            data = newData;
        }

        public void clear(){
            for(int i = index-1; i>-1; i--){
                remove(i);
            }

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

    }
