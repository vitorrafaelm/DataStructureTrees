package api.storage.operations.interfaces;

import api.storage.database.generic.Node;

public interface GeneralInterface<T> {

    void getTreeOrder();
    void getTreePreOrder();
    void getTreePosOrder();
    Node<T> findElement(Integer key);
    void DeleteElement(Integer key);
    void insertElement(T value);
    int getQuantity();
    void updateVehicleInformations(Integer key, T valueToUpdate);
}
