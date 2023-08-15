package protocol.interfaces;

public interface FacadeInterface<T> {
    void listOrder();
    void listPreOrder();
    void listPosOrder();
    void delete(T node);
    T update(T node);
    void insert(T node);
    void getItensQuantity();

    T findBy(String value);
}
