package api.storage.database.generic;

import api.storage.database.VehiclesTree.VehiclesNode;
import api.storage.models.Vehicles;

public class Node<T> {

    Integer key, heightNode;
    T value;
    Node<T> left, right;

    public Node(Integer key, T vehicle) {
        this.key = key;
        this.value = vehicle;
        this.setHeightNode(0);
        this.setLeft(null);
        this.setRight(null);
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getHeightNode() {
        return heightNode;
    }

    public void setHeightNode(Integer heightNode) {
        this.heightNode = heightNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
