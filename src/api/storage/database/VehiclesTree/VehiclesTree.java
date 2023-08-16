package api.storage.database.VehiclesTree;
import api.storage.models.Vehicles;

public class VehiclesTree {
    VehiclesNode root;

    public VehiclesTree() {
        this.setRoot(null);
    }

    public VehiclesNode getRoot() {
        return root;
    }

    public void setRoot(VehiclesNode root) {
        this.root = root;
    }

    public void order() {
        this.order(getRoot());
    }

    private void order(VehiclesNode node){
        if(node != null) {
            this.order(node.getLeft());
            System.out.println(node.getKey() + ": " + node.getVehicle().toString());
            this.order(node.getRight());
        }
    }

    public void preOrdem() {
        this.preOrdem(getRoot());
    }

    private void preOrdem(VehiclesNode node) {
        if(node != null) {
            System.out.println(node.getVehicle());
            this.preOrdem(node.left);
            this.preOrdem(node.right);
        }
    }

    public void posOrdem() {
        this.posOrdem(getRoot());
    }

    private void posOrdem(VehiclesNode node) {

        if(node != null) {
            this.posOrdem(node.left);
            this.posOrdem(node.right);
            System.out.println(node.getVehicle());
        }

    }

    public VehiclesNode search(Long k) {
        return this.search(getRoot(), k);
    }

    private VehiclesNode search(VehiclesNode r, Long k) {
        if(r == null)
            return null;

        else if(k < r.getKey())
            return this.search(r.getLeft(), k);

        else if(k > r.getKey())
            return this.search(r.getRight(), k);
        else
            return r;
    }

    public VehiclesNode update(Long k, Vehicles vehicle) {
        return this.update(getRoot(), k, vehicle);
    }

    private VehiclesNode update(VehiclesNode r, Long k, Vehicles vehicle) {
        if (r == null) {
            return null;
        } else if(k < r.getKey()) {
            return this.search(r.getLeft(), k);
        } else if(k > r.getKey()) {
            return this.search(r.getRight(), k);
        } else {
            System.out.println("ENTROU AQUI");
            Vehicles current = r.getVehicle();
            current.setModelName(vehicle.getModelName());
            current.setLicensePlate(vehicle.getLicensePlate());
            current.setDriverCPF(vehicle.getDriverCPF());
            current.setDrivername(vehicle.getDrivername());

            r.setVehicle(current);
            return r;
        }

    }

    public Integer countNodes() {
        return this.countNodes(this.getRoot());
    }

    private Integer countNodes(VehiclesNode r) {

        if(r == null)
            return 0;
        else
            return 1 + countNodes(r.left) + countNodes(r.right);

    }

    private Integer height(VehiclesNode node) {
        if(node == null) return -1;
        return node.heightNode;

    }

    private Integer greater(Integer valueOne, Integer valueTwo) {
        return (valueOne > valueTwo) ? valueOne : valueTwo;

    }

    private Integer getBalancingFactor(VehiclesNode node) {
        if(node == null) return 0;
        return this.height(node.getLeft()) - this.height(node.getRight());
    }

    public void insert(Long k, Vehicles vehicles) {
        this.root = this.insert(getRoot(), k, vehicles);
    }

    private VehiclesNode insert(VehiclesNode node, Long key, Vehicles vehicles) {
        if(node == null) return new VehiclesNode(key, vehicles);

        if(node.compareTo(key) > 0) {
            node.left = this.insert(node.getLeft(), key, vehicles);
        } else if(node.compareTo(key) < 0) {
            node.right = this.insert(node.getRight(), key, vehicles);
        } else {
            return node;
        }

        node.heightNode = 1 + this.greater(this.height(node.getLeft()), this.height(node.getRight()));

        return rebalance(node);
    }

    public void delete(Long k) {
        this.root = this.delete(getRoot(), k);
    }

    private VehiclesNode delete(VehiclesNode node, Long key) {
        if (node == null) {
            return node;
        } else if (node.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else if (node.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                VehiclesNode mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }



    private VehiclesNode mostLeftChild(VehiclesNode node) {
        return node.getRight() == null ? node : mostLeftChild(node.getLeft());
    }

    int getBalance(VehiclesNode n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    VehiclesNode rebalance(VehiclesNode node) {
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (height(node.left.left) > height(node.left.right))
                node = rotateRight(node);
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    VehiclesNode rotateRight(VehiclesNode y) {
        VehiclesNode x = y.left;

        if(x == null) return x;

        VehiclesNode z = x.right;
        x.right = y;
        y.left = z;
        return x;
    }

    VehiclesNode rotateLeft(VehiclesNode y) {
        VehiclesNode x = y.right;
        if(x == null) return x;
        VehiclesNode z = x.left != null ? x.left : null;
        x.left = y;
        y.right = z;
        return x;
    }

    private VehiclesNode SimpleRotateLeft(VehiclesNode driver) {

        VehiclesNode vehicleRight = driver.getRight(); // y
        VehiclesNode vehicleLeft = driver.getLeft(); // z

        vehicleRight.setLeft(driver);
        vehicleLeft.setRight(vehicleLeft);

        driver.heightNode = 1 + this.greater(this.height(driver.getLeft()), this.height(driver.getRight()));
        vehicleRight.heightNode = 1 + this.greater(this.height(vehicleRight.getLeft()), this.height(vehicleRight.getRight()));

        return vehicleRight;
    }

    private VehiclesNode SimpleRotateRight(VehiclesNode driver) {

        VehiclesNode vehicleLeft = driver.getLeft();
        VehiclesNode vehicleLeftRight = vehicleLeft.getRight();

        // executa rotação

        vehicleLeft.setRight(driver);
        driver.setLeft(vehicleLeftRight);

        driver.heightNode = 1 + this.greater(this.height(driver.getLeft()), this.height(driver.getRight()));
        vehicleLeft.heightNode = 1 + this.greater(this.height(vehicleLeft.getLeft()), this.height(vehicleLeft.getRight()));

        return vehicleLeft;
    }

}
