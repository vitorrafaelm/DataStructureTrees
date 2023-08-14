package protocol.proxy.Vehicles;

import api.exposed.VehiclesOperations.VehicleOperations;
import api.storage.database.VehiclesTree.VehiclesNode;
import api.storage.models.Vehicles;
import api.storage.operations.vehiclesOperations.VehiclesOperations;
import protocol.interfaces.ProxyInterface;

public class VehiclesProxy implements ProxyInterface<Vehicles> {

    VehiclesOperations vehicleOperations = new VehicleOperations().getOperations();

    @Override
    public void search(Vehicles node) {
        vehicleOperations.getTree();
    }

    @Override
    public Vehicles delete(Vehicles node) {
        return null;
    }

    @Override
    public Vehicles list(Vehicles node) {
        return null;
    }

    @Override
    public Vehicles update(Vehicles node) {
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
