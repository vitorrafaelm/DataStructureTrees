package protocol.interfaces;

public interface ProxyInterface<T> {
    void search(T node);
    T delete(T node);
    T list(T node);
    T update(T node);
    void insert(T node);
    void getItensQuantity();

    T findBy(String value);
}
