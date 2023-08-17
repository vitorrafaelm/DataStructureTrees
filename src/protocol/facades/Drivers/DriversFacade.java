package protocol.facades.Drivers;

import api.exposed.DriversOperations.DriverOperations;
import api.storage.models.Drivers;
import api.storage.operations.driversOperations.DriversOperations;
import protocol.interfaces.FacadeInterface;

import java.net.Inet4Address;

public class DriversFacade implements FacadeInterface<Drivers> {
    DriversOperations driverOperations = new DriverOperations().getOperations();

    @Override
    public void listOrder() {
        driverOperations.getTreePosOrder();
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
        driverOperations.DeleteElement(Integer.parseInt(node.getCPF()));
    }

    @Override
    public Drivers update(Drivers node) {
        driverOperations.updateVehicleInformations(Integer.parseInt(node.getCPF()), node);
        return null;
    }

    @Override
    public void insert(Drivers node) {
        driverOperations.insertElement(node);
    }

    @Override
    public void getItensQuantity() {
        driverOperations.getQuantity();
    }

    @Override
    public void findBy(String value) {
        driverOperations.findElement(Integer.parseInt(value));
    }
}
