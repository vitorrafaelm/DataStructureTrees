package protocol.proxy.Drivers;

import api.exposed.DriversOperations.DriverOperations;
import api.storage.models.Drivers;
import api.storage.operations.driversOperations.DriversOperations;
import protocol.interfaces.ProxyInterface;

public class DriversProxy implements ProxyInterface<Drivers> {
    DriversOperations driverOperations = new DriverOperations().getOperations();

    @Override
    public void search(Drivers node) {
        driverOperations.getTree();
    }

    @Override
    public Drivers delete(Drivers node) {
        return null;
    }

    @Override
    public Drivers list(Drivers node) {
        return null;
    }

    @Override
    public Drivers update(Drivers node) {
        return null;
    }

    @Override
    public void insert(Drivers node) {
        driverOperations.insertElement(node);
    }

    @Override
    public void getItensQuantity() {

    }
}
