public class MyArrayList<E> {
    private Object[] list;
    private int size;

    private static final int STARTING_CAPACITY = 10;
    private static final double LOAD_FACTOR = 1.5;

    public MyArrayList() {
        list = new Object[STARTING_CAPACITY];
    }

    public boolean add(E element) {
        if (size == list.length) {
            resize();
        }

        list[size++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) list[index];
    }

    public void set(int index, E element) {
        checkIndex(index);
        list[index] = element;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(list[i]);
        }
        return result.append("]").toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
    }

    private void resize() {
        Object[] newList = new Object[(int) (list.length * LOAD_FACTOR)];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }
}
