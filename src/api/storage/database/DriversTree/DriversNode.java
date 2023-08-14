package api.storage.database.DriversTree;

import api.storage.models.Drivers;

public class DriversNode implements Comparable<Long> {
    Integer heightNode;
    Long key;
    Drivers driver;
    DriversNode left, right;

    public DriversNode(Long key, Drivers driver) {
        this.setKey(key);
        this.setDriver(driver);
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

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }

    public DriversNode getLeft() {
        return left;
    }

    public void setLeft(DriversNode left) {
        this.left = left;
    }

    public DriversNode getRight() {
        return right;
    }

    public void setRight(DriversNode right) {
        this.right = right;
    }

    @Override
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
