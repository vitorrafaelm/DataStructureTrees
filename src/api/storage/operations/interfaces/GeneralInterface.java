package api.storage.operations.interfaces;

public interface GeneralInterface<T> {

    void getTree();
    void getTreePreOrder();
    void getTreePosOrder();
    T findElement(String value);
    void DeleteElement();
    void insertElement(T Node);
    int getQuantity();
    void listAll();
}
