package api.storage.operations.vehiclesOperations;

import api.storage.database.VehiclesTree.VehiclesTree;
import api.storage.models.Vehicles;
import api.storage.operations.interfaces.GeneralInterface;

public class VehiclesOperations implements GeneralInterface<Vehicles> {
    VehiclesTree vehiclesTree = new VehiclesTree();

    @Override
    public void getTree() {
        vehiclesTree.order();
    }

    @Override
    public void getTreePreOrder() {

    }

    @Override
    public void getTreePosOrder() {

    }

    @Override
    public Vehicles findElement(String value) {
        return vehiclesTree.search(Long.parseLong(value)).getVehicle();
    }

    @Override
    public void DeleteElement() {

    }

    @Override
    public void insertElement(Vehicles Node) {
        vehiclesTree.insert(Long.parseLong(Node.getReindeer()), Node);
    }

    @Override
    public int getQuantity() {
        return vehiclesTree.countNodes();
    }

    @Override
    public void listAll() {

    }
}
