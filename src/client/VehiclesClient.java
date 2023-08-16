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
        driver1.setCPF("70463477430");
        driver1.setName("Vitor");

        driversFacade.insert(driver1);
        driversFacade.listOrder();

        String uuid1 = null;
        String uuid2 = null;
        String uuid3 = null;
        String uuid4 = null;
        String uuid5 = null;


        for (int i = 1; i <= 30; i++) {
            Long randomNumber = Math.abs(gerador.nextLong());
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

        System.out.println("Primeiras 5 consultas ---------------------------------");
        System.out.println(vehiclesFacade.findBy(uuid1).toString());
        System.out.println(vehiclesFacade.findBy(uuid2).toString());
        System.out.println(vehiclesFacade.findBy(uuid3).toString());
        System.out.println(vehiclesFacade.findBy(uuid4).toString());
        System.out.println(vehiclesFacade.findBy(uuid5).toString());

        System.out.println("Listagem em ordem -------------------------------------");
        vehiclesFacade.listOrder();

        System.out.println("Primeiro Cadastro -------------------------------------");
        Long randomNumber = Math.abs(gerador.nextLong());
        UUID idOne = UUID.randomUUID();
        System.out.println(randomNumber + "print do id deletado");
        Vehicles vehicles = new Vehicles();
        vehicles.setDrivername(driver1.getName());
        vehicles.setDriverCPF(driver1.getCPF());
        vehicles.setCreatedVehicleDate("2022-06-18");

        vehicles.setReindeer(randomNumber.toString());
        vehicles.setLicensePlate((idOne.toString()).substring(0, 3) + "2432");
        vehicles.setModelName("celta 1.0 " + randomNumber);

        vehiclesFacade.insert(vehicles);

        System.out.println("Listagem em ordem após primeiro cadastro -------------------------------------");
        vehiclesFacade.listOrder();

        System.out.println("Primeira deleção -------------------------------------");
        vehiclesFacade.delete(vehicles);

        System.out.println("Listagem em ordem após primeira deleção -------------------------------------");
        vehiclesFacade.listOrder();
    }
}
