public class SLList<E> {
    private Node<E> head;
    private int size;

    public SLList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current.get();
    }

    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (current.get().equals(o)) {
                return true;
            }
            current = current.next();
        }
        return false;
    }

    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(newNode);
        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next();
            }
            newNode.setNext(current.next());
            current.setNext(newNode);
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        E removed;
        if (index == 0) {
            removed = head.get();
            head = head.next();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next();
            }
            Node<E> target = current.next();
            removed = target.get();
            current.setNext(target.next());
        }
        size--;
        return removed;
    }

    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.get().equals(o)) {
            head = head.next();
            size--;
            return true;
        }
        Node<E> current = head;
        while (current.next() != null) {
            if (current.next().get().equals(o)) {
                current.setNext(current.next().next());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        E old = current.get();
        current.setData(element);
        return old;
    }

    public void scramble() {
        if (head == null) {
            return;
        }
        for (int i = size - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            E temp = get(i);
            set(i, get(j));
            set(j, temp);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.get());
            if (current.next() != null) {
                sb.append(", ");
            }
            current = current.next();
        }
        sb.append("]");
        return sb.toString();
    }
}