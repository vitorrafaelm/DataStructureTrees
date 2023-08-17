package client;

import api.storage.models.Drivers;
import api.storage.models.Vehicles;
import protocol.facades.Drivers.DriversFacade;
import protocol.facades.Vehicles.VehiclesFacade;

import java.util.Random;
import java.util.UUID;

public class VehiclesClient {

    public static void main(String[] args) {
        Random gerador = new Random();
        VehiclesFacade vehiclesFacade = new VehiclesFacade();
        DriversFacade driversFacade = new DriversFacade();

        Drivers driver1 = new Drivers();
        driver1.setCPF("704634");
        driver1.setName("Vitor");

        driversFacade.insert(driver1);
        driversFacade.listOrder();

        String uuid1 = null;
        String uuid2 = null;
        String uuid3 = null;
        String uuid4 = null;
        String uuid5 = null;


        for (Integer i = 1; i <= 50; i++) {
            Integer randomNumber = Math.abs(gerador.nextInt());
            UUID idOne = UUID.randomUUID();

            if(i == 2) uuid1 = randomNumber.toString();
            if(i == 3) uuid2 = randomNumber.toString();
            if(i == 4) uuid3 = randomNumber.toString();
            if(i == 5) uuid4 = randomNumber.toString();
            if(i == 6) uuid5 = randomNumber.toString();

            Vehicles vehicles = new Vehicles();
            vehicles.setDrivername(driver1.getName());
            vehicles.setDriverCPF(driver1.getCPF());
            vehicles.setCreatedVehicleDate("2022-06-18");

            vehicles.setReindeer(randomNumber.toString());
            vehicles.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
            vehicles.setModelName("celta 1.0 " + randomNumber);

            vehiclesFacade.insert(vehicles);
        }

        System.out.println("5 searches ---------------------------------");
        vehiclesFacade.findBy(uuid1.toString());
        vehiclesFacade.findBy(uuid2.toString());
        vehiclesFacade.findBy(uuid3.toString());
        vehiclesFacade.findBy(uuid4.toString());
        vehiclesFacade.findBy(uuid5.toString());

        System.out.println("List in Order -------------------------------------");
        vehiclesFacade.listOrder();

        System.out.println("Insert first register and get Quantity and List -------------------------------------");
        Integer randomNumber = Math.abs(gerador.nextInt());
        UUID idOne = UUID.randomUUID();

        vehiclesFacade.getItensQuantity();

        Vehicles vehicles = new Vehicles();
        vehicles.setDrivername(driver1.getName());
        vehicles.setDriverCPF(driver1.getCPF());
        vehicles.setCreatedVehicleDate("2022-06-18");

        vehicles.setReindeer(randomNumber.toString());
        vehicles.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
        vehicles.setModelName("celta 1.0 " + randomNumber);

        vehiclesFacade.insert(vehicles);
        vehiclesFacade.getItensQuantity();
        vehiclesFacade.listOrder();

        System.out.println("Insert second register and get Quantity and List -------------------------------------");
        randomNumber = Math.abs(gerador.nextInt());
        idOne = UUID.randomUUID();

        vehiclesFacade.getItensQuantity();

        Vehicles vehicles2 = new Vehicles();
        vehicles2.setDrivername(driver1.getName());
        vehicles2.setDriverCPF(driver1.getCPF());
        vehicles2.setCreatedVehicleDate("2022-06-18");

        vehicles2.setReindeer(randomNumber.toString());
        vehicles2.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
        vehicles2.setModelName("celta 1.0 " + randomNumber);

        vehiclesFacade.insert(vehicles2);
        vehiclesFacade.getItensQuantity();
        vehiclesFacade.listOrder();

        System.out.println("Update and list value updated -------------------------------------");
        vehiclesFacade.findBy(randomNumber.toString());
        Integer randomNumberToUpdate = Math.abs(gerador.nextInt());
        UUID idOneToUpdate = UUID.randomUUID();

        vehicles2.setCreatedVehicleDate("2022-06-30");

        vehicles2.setLicensePlate((idOneToUpdate.toString()).substring(0, 3) + "2432");
        vehicles2.setModelName("celta 1.0 " + randomNumberToUpdate);
        vehiclesFacade.update(vehicles2);

        System.out.println("Value after update ------------------------------------------------");
        vehiclesFacade.findBy(randomNumber.toString());

        System.out.println("First remove and list -------------------------------------");
        vehiclesFacade.delete(vehicles);
        vehiclesFacade.getItensQuantity();
        vehiclesFacade.listOrder();

        System.out.println("Second remove and list -------------------------------------");
        vehiclesFacade.delete(vehicles2);
        vehiclesFacade.listOrder();
        vehiclesFacade.getItensQuantity();

    }
}
