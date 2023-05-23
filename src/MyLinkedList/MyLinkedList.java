package MyLinkedList;

import java.util.LinkedList;
import java.util.StringJoiner;

    public class MyLinkedList<T> {
        private Node<T> head;
        private Node<T> last;

        public void add(T item) {
           Node<T> node = new Node<T>();
            node.setValue(item);

            if (head == null) {
                head = node;
            } else {
               // Node<T> last = head;
                last = head;
                while (last.getNext() != null) {
                    last = last.getNext();
                }

                last.setNext(node);
            }
        }

        public int size() {
            if (head == null) {
                return 0;
            }

            int count = 1;
            Node<T> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
                count++;
            }

            return count;
        }

        public T get(int index) {
            indexCheck(index);
            if (head == null) {
                throw new IndexOutOfBoundsException("List is empty");
            }

            Node<T> search = head;
            for (int i = 0; i < index; i++) {
                search = search.getNext();

                if (search == null) {
                    throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
                }
            }

            return search.getValue();
        }

        public void clear(){
            for (Node<T> emptyNode = head; emptyNode != null; ) {
               Node<T> next = emptyNode.getNext();
                emptyNode.setValue(null);
                emptyNode.setNext(null);
                emptyNode = next;
            }
            head = null;//last?size?
        }
    public T remove(int index) {
           indexCheck(index);
        return removeElement(index);
    }

    T removeElement(int index) {
        Node<T> search = head;
        for (int i = 0; i < index; i++) {
            search = search.getNext();

            if (search == null) {
                throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size());
            }
        }
        final T element = search.getValue();
        final Node<T> next = search.getNext();
        final Node<T> prev = search.getPrev();

        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            search.setPrev(null);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
            search.setNext(null);
        }

        search.setValue(null);
        return element;
    }
    public void indexCheck(int i){
        if(i<0 || i>=size()){
            throw new IndexOutOfBoundsException("Index should be in range of list length.");
        }
    }
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < size(); i++) {
            result.add(get(i).toString());
        }
        return "[" + result + "]";
    }

}
