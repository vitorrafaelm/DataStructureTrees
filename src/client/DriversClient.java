package client;

import api.storage.models.Drivers;
import protocol.proxy.Drivers.DriversProxy;

import java.util.Random;

public class DriversClient {



    public static void main(String[] args) {
        DriversProxy driversProxy = new DriversProxy();

        Drivers driver1 = new Drivers();
        driver1.setCPF("70463477430");
        driver1.setName("Vitor");

        Drivers driver2 = new Drivers();
        driver2.setCPF("70463477431");
        driver2.setName("Vitor Daniel");

        Drivers driver3 = new Drivers();
        driver3.setCPF("70463477429");
        driver3.setName("Vitor Daniel Rafael");

        driversProxy.insert(driver1);
        driversProxy.insert(driver2);
        driversProxy.insert(driver3);

        driversProxy.search(driver1);

    }
}
