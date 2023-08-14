package api.storage.database.VehiclesTree;

import api.storage.database.DriversTree.DriversNode;
import api.storage.models.Vehicles;

public class VehiclesNode {

    Integer heightNode;
    Long key;
    Vehicles vehicle;
    VehiclesNode left, right;

    public VehiclesNode(Long key, Vehicles vehicle) {
        this.setKey(key);
        this.setVehicle(vehicle);
        this.setHeightNode(0);
        this.setLeft(null);
        this.setRight(null);
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Integer getHeightNode() {
        return heightNode;
    }

    public void setHeightNode(Integer heightNode) {
        this.heightNode = heightNode;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public VehiclesNode getLeft() {
        return left;
    }

    public void setLeft(VehiclesNode left) {
        this.left = left;
    }

    public VehiclesNode getRight() {
        return right;
    }

    public void setRight(VehiclesNode right) {
        this.right = right;
    }

    public int compareTo(Long valueToCompare) {
        if(this.getKey() < valueToCompare) {
            return -1;
        }

        if(this.getKey() > valueToCompare) {
            return 1;
        }

        return 0;
    }
}
