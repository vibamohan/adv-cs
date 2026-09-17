public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
        next = null;
    }

    public E get() {
        return data;
    }

    public Node<E> next() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setData(E data) {
        this.data = data;
    }
}