package api.storage.models;

public class Vehicles {

    String licensePlate;
    String reindeer;
    String modelName;
    String createdVehicleDate;
    String Drivername;
    String DriverCPF;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getReindeer() {
        return reindeer;
    }

    public void setReindeer(String reindeer) {
        this.reindeer = reindeer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCreatedVehicleDate() {
        return createdVehicleDate;
    }

    public void setCreatedVehicleDate(String createdVehicleDate) {
        this.createdVehicleDate = createdVehicleDate;
    }

    public String getDrivername() {
        return Drivername;
    }

    public void setDrivername(String drivername) {
        Drivername = drivername;
    }

    public String getDriverCPF() {
        return DriverCPF;
    }

    public void setDriverCPF(String driverCPF) {
        DriverCPF = driverCPF;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "licensePlate='" + licensePlate + '\'' +
                ", reindeer='" + reindeer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", createdVehicleDate='" + createdVehicleDate + '\'' +
                '}';
    }
}
