package api.storage.operations.driversOperations;

import api.storage.database.DriversTree.DriversTree;
import api.storage.models.Drivers;
import api.storage.operations.interfaces.GeneralInterface;

import java.util.Optional;

public class DriversOperations implements GeneralInterface<Drivers> {

    DriversTree drivers = new DriversTree();

    @Override
    public void getTree() {
        drivers.order();
    }

    @Override
    public void getTreePreOrder() {

    }

    @Override
    public void getTreePosOrder() {

    }

    @Override
    public Drivers findElement(String value) {
        return null;
    }

    @Override
    public void DeleteElement() {

    }

    @Override
    public void insertElement(Drivers Node) {
        drivers.insert(Long.parseLong(Node.getCPF()), Node);
    }

    @Override
    public int getQuantity() {
        return 1;
    }

    @Override
    public void listAll() {

    }
}
