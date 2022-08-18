package Chuong10_collection;

public class Node<T> {
    T value;

    Node<T> next;

    Node(T v){
        value = v;
    }

    Node(T v, Node<T> n){
        value = v;
        next = n;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
