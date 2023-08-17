package api.storage.operations.driversOperations;

import api.storage.database.DriversTree.DriversTree;
import api.storage.database.generic.Node;
import api.storage.database.generic.Tree;
import api.storage.models.Drivers;
import api.storage.operations.interfaces.GeneralInterface;

import java.util.Optional;

public class DriversOperations implements GeneralInterface<Drivers> {

    Tree driversTree = new Tree<Drivers>();

    @Override
    public void getTreeOrder() {
        driversTree.order();
    }

    @Override
    public void getTreePreOrder() {
        driversTree.preOrder();
    }

    @Override
    public void getTreePosOrder() {
        driversTree.posOrder();
    }

    @Override
    public Node<Drivers> findElement(Integer key) {
        return driversTree.find(key);
    }

    @Override
    public void DeleteElement(Integer key) {
        driversTree.delete(key);
    }

    @Override
    public void insertElement(Drivers value) {
        driversTree.insert(Integer.parseInt(value.getCPF()), value);
    }

    @Override
    public int getQuantity() {
        return driversTree.countNodes();
    }

    @Override
    public void updateVehicleInformations(Integer key, Drivers valueToUpdate) {
        driversTree.update(key, valueToUpdate);
    }
}
