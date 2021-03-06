package algorithmsUtils;

import java.util.EmptyStackException;

/**
 * Created by Nimrod Golan on 12/09/2016.
 */
public class MyStackClass<T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        MyStackClass myStackClass = new MyStackClass();
        myStackClass.push(1);
        myStackClass.push(2);
        myStackClass.push(3);
        myStackClass.pop();
        Object peek = myStackClass.peek();
        int q = 0;
    }
}
