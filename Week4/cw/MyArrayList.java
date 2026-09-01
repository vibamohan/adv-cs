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

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }

        return (E) list[index];
    }

    public void set(E val, int index) {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size "  + size);
        }
        list[index] = val;
    }


    public int size() {
        return size;
    }

    private void resize() {
        Object[] newList = new Object[(int) (list.length * LOAD_FACTOR)];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }
}


