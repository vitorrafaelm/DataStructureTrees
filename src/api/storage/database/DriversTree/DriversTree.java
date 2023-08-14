package api.storage.database.DriversTree;

import api.storage.models.Drivers;

public class DriversTree {

    DriversNode root;

    public DriversTree() {
        this.setRoot(null);
    }

    public DriversNode getRoot() {
        return root;
    }

    public void setRoot(DriversNode root) {
        this.root = root;
    }

    public void order() {
        this.order(getRoot());
    }

    private void order(DriversNode node){

        if(node != null) {
            this.order(node.getLeft());
            System.out.println(node.getKey() + ": " + node.getDriver());
            this.order(node.getRight());
        }
    }

    private Integer height(DriversNode node) {
        if(node == null) return -1;
        return node.heightNode;

    }

    private Integer greater(Integer valueOne, Integer valueTwo) {
        return (valueOne > valueTwo) ? valueOne : valueTwo;

    }

    private Integer getBalancingFactor(DriversNode node) {
        if(node == null) return 0;
        return this.height(node.getLeft()) - this.height(node.getRight());
    }

    public void insert(Long k, Drivers driver) {
        this.root = this.insert(getRoot(), k, driver);
    }

    private DriversNode insert(DriversNode node, Long key, Drivers driver) {

        if(node == null) return new DriversNode(key, driver);

        if(node.compareTo(key) > 0) {
            node.left = this.insert(node.getLeft(), key, driver);
        } else if(node.compareTo(key) < 0) {
            node.right = this.insert(node.getRight(), key, driver);
        } else {
            return node;
        }

        node.heightNode = 1 + this.greater(this.height(node.getLeft()), this.height(node.getRight()));

        /*3. Obter FB */

        int fb = this.getBalancingFactor(node);
        int fbEsq = this.getBalancingFactor(node.getLeft());
        int fbDir = this.getBalancingFactor(node.getRight());

        if(fb > 1 && fbEsq >= 0) {
            return this.SimpleRotateRight(node);
        }

        if(fb > 1 && fbEsq < 0) {
            node.left = this.SimpleRotateLeft(node.left);
            return SimpleRotateRight(node);
        }

        if(fb < -1 && fbDir <= 0) {
            return this.SimpleRotateLeft(node);
        }

        if(fb < -1 && fbDir > 0) {
            node.right = this.SimpleRotateLeft(node.right);
            return SimpleRotateRight(node);
        }

        return node;
    }

    private DriversNode SimpleRotateLeft(DriversNode driver) {

        DriversNode driverRight = driver.getRight(); // y
        DriversNode driverLeft = driver.getLeft(); // z

        driverRight.setLeft(driver);
        driverLeft.setRight(driverLeft);

        driver.heightNode = 1 + this.greater(this.height(driver.getLeft()), this.height(driver.getRight()));
        driverRight.heightNode = 1 + this.greater(this.height(driverRight.getLeft()), this.height(driverRight.getRight()));

        return driverRight;
    }

    private DriversNode SimpleRotateRight(DriversNode driver) {

        DriversNode driverLeft = driver.getLeft();
        DriversNode driverLeftRight = driverLeft.getRight();

        // executa rotação

        driverLeft.setRight(driver);
        driver.setLeft(driverLeftRight);

        driver.heightNode = 1 + this.greater(this.height(driver.getLeft()), this.height(driver.getRight()));
        driverLeft.heightNode = 1 + this.greater(this.height(driverLeft.getLeft()), this.height(driverLeft.getRight()));

        return driverLeft;
    }
}
