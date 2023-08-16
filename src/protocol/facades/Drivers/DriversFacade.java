package protocol.facades.Drivers;

import api.exposed.DriversOperations.DriverOperations;
import api.storage.models.Drivers;
import api.storage.operations.driversOperations.DriversOperations;
import protocol.interfaces.FacadeInterface;

public class DriversFacade implements FacadeInterface<Drivers> {
    DriversOperations driverOperations = new DriverOperations().getOperations();

    @Override
    public void listOrder() {
        driverOperations.getTree();
    }

    @Override
    public void listPreOrder() {
        driverOperations.getTreePreOrder();
    }

    @Override
    public void listPosOrder() {
        driverOperations.getTreePosOrder();
    }

    @Override
    public void delete(Drivers node) {

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
        System.out.println(driverOperations.getQuantity());
    }

    @Override
    public Drivers findBy(String value) {
        return driverOperations.findElement(value);
    }
}
