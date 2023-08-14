package api.storage.operations.interfaces;

public interface GeneralInterface<T> {

    void getTree();
    void getTreePreOrder();
    void getTreePosOrder();
    void findElement();
    void DeleteElement();
    void insertElement(T Node);
    void getQuantity();
    void listAll();
}
