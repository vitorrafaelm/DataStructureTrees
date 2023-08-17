package api.storage.operations.vehiclesOperations;

import api.storage.database.generic.Node;
import api.storage.database.generic.Tree;
import api.storage.models.Vehicles;
import api.storage.operations.interfaces.GeneralInterface;

public class VehiclesOperations implements GeneralInterface<Vehicles> {
    Tree<Vehicles> vehiclesTree = new Tree<>();

    @Override
    public void getTreeOrder() {
        vehiclesTree.order();
    }

    @Override
    public void getTreePreOrder() {
        vehiclesTree.preOrder();
    }

    @Override
    public void getTreePosOrder() {
        vehiclesTree.posOrder();
    }

    @Override
    public Node<Vehicles> findElement(Integer key) {
        return vehiclesTree.find(key);
    }

    @Override
    public void DeleteElement(Integer key) {
        vehiclesTree.delete(key);
    }

    @Override
    public void insertElement(Vehicles value) {
        vehiclesTree.insert( Integer.parseInt(value.getReindeer()), value);
    }

    @Override
    public int getQuantity() {
        return vehiclesTree.countNodes();
    }

    @Override
    public void updateVehicleInformations(Integer key, Vehicles valueToUpdate) {
        vehiclesTree.update(key, valueToUpdate);
    }
}
