public class MyArrayList<E> {
    private Object[] list;
    private int size;

    private final int STARTING_CAPACITY = 10;
    private final double LOAD_FACTOR = 1.5;

    public MyArrayList() {
        list = new Object[STARTING_CAPACITY];
        size = 0;
    }

    public boolean add(E element) {
        if (size == list.length) {
            resize();
        }

        list[size] = element;
        size++;

        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }

        if (size == list.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }

        return (E) list[index];
    }

    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index " + index + " is out of bounds for size " + size
            );
        }
        list[index] = val;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }

        E removed = (E) list[index];

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;

        return removed;
    }

    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            result += list[i];
            if (i < size - 1) {
                result += ", ";
            }
        }

        return result + "]";
    }

    private void resize() {
        Object[] newList = new Object[(int) (list.length * LOAD_FACTOR)];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }
}


