package api.storage.operations.vehiclesOperations;

import api.storage.database.VehiclesTree.VehiclesNode;
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
        vehiclesTree.preOrdem();
    }

    @Override
    public void getTreePosOrder() {
        vehiclesTree.posOrdem();
    }

    @Override
    public Vehicles findElement(String value) {
        VehiclesNode vehicleNode =  vehiclesTree.search(Long.parseLong(value));

        if(vehicleNode != null) {
            return vehicleNode.getVehicle();
        }

        return null;
    }

    @Override
    public void DeleteElement(String key) {
        vehiclesTree.delete(Long.parseLong(key));
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
    public void updateVehicleInformations(String key, Vehicles item) {
        vehiclesTree.update(Long.parseLong(key), item);
    }
}
