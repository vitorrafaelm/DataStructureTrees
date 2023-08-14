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
        vehicles.setReindeer("28471886960");
        vehicles.setLicensePlate("KRX2432");
        vehicles.setModelName("celta");

        Vehicles vehicles2 = new Vehicles();
        vehicles2.setDrivername(driver1.getName());
        vehicles2.setDriverCPF(driver1.getCPF());

        vehicles2.setCreatedVehicleDate("2022-06-18");
        vehicles2.setReindeer("28471886962");
        vehicles2.setLicensePlate("KRX2435");
        vehicles2.setModelName("celta");

        Vehicles vehicles3 = new Vehicles();
        vehicles3.setDrivername(driver1.getName());
        vehicles3.setDriverCPF(driver1.getCPF());

        vehicles3.setCreatedVehicleDate("2022-06-18");
        vehicles3.setReindeer("28471886959");
        vehicles3.setLicensePlate("KRX2430");
        vehicles3.setModelName("celta");

        driversProxy.search(driver1);
        vehiclesProxy.insert(vehicles);
        vehiclesProxy.insert(vehicles2);
        vehiclesProxy.insert(vehicles3);

        vehiclesProxy.search(vehicles);

        System.out.println(vehiclesProxy.findBy("28471886959").toString());
        vehiclesProxy.getItensQuantity();
    }
}
