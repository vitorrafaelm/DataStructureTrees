package protocol.facades.Vehicles;

import api.exposed.VehiclesOperations.VehicleOperations;
import api.storage.models.Vehicles;
import api.storage.operations.vehiclesOperations.VehiclesOperations;
import protocol.interfaces.FacadeInterface;

public class VehiclesFacade implements FacadeInterface<Vehicles> {

    VehiclesOperations vehicleOperations = new VehicleOperations().getOperations();

    @Override
    public void listOrder() {
        vehicleOperations.getTree();
    }

    @Override
    public void listPreOrder() {
        vehicleOperations.getTreePreOrder();
    }

    @Override
    public void listPosOrder() {
        vehicleOperations.getTreePosOrder();
    }

    @Override
    public void delete(Vehicles node) {
        vehicleOperations.DeleteElement(node.getReindeer());
    }

    @Override
    public Vehicles update(Vehicles node) {
        vehicleOperations.updateVehicleInformations(node.getReindeer(), node);
        return null;
    }

    @Override
    public void insert(Vehicles node) {
        vehicleOperations.insertElement(node);
    }
    @Override
    public void getItensQuantity() {
        System.out.println(vehicleOperations.getQuantity());
    }
    @Override
    public Vehicles findBy(String value) {
        return vehicleOperations.findElement(value);
    }
}
