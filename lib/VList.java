public interface VList<E> {
    E get(int index);
    boolean add(E element);
    void add(int index, E element);
    E remove(int index);
    boolean remove(E element);
    int size();
}