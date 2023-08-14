package api.exposed.DriversOperations;

import api.storage.operations.driversOperations.DriversOperations;

public class DriverOperations {
    public DriversOperations getOperations() {
        return new DriversOperations();
    }
}
