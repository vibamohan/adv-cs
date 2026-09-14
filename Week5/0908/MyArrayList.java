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

        list[size++] = element;

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


