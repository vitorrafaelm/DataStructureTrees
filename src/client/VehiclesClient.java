package client;

import api.storage.models.Drivers;
import api.storage.models.Vehicles;
import protocol.proxy.Drivers.DriversProxy;
import protocol.proxy.Vehicles.VehiclesProxy;

public class VehiclesClient {

    public static void main(String[] args) {
        VehiclesProxy vehiclesProxy = new VehiclesProxy();
        DriversProxy driversProxy = new DriversProxy();

        Drivers driver1 = new Drivers();
        driver1.setCPF("70463477430");
        driver1.setName("Vitor");

        Vehicles vehicles = new Vehicles();
        vehicles.setDrivername(driver1.getName());
        vehicles.setDriverCPF(driver1.getCPF());

        vehicles.setCreatedVehicleDate("2022-06-18");
        vehicles.setReindeer("28471886963");
        vehicles.setLicensePlate("KRX2432");
        vehicles.setModelName("celta");

        driversProxy.search(driver1);
        vehiclesProxy.insert(vehicles);

        vehiclesProxy.search(vehicles);
    }
}
