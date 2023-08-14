package api.exposed.VehiclesOperations;
import api.storage.operations.vehiclesOperations.VehiclesOperations;

public class VehicleOperations {
    public VehiclesOperations getOperations() {
        return new VehiclesOperations();
    }
}
