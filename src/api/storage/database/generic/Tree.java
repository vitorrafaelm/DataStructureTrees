package api.storage.database.generic;

import api.storage.models.Vehicles;

public class Tree<T> {
    Node<T> root;

    public Tree() {
        this.setRoot(null);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    // Path in Order
    public void order() {
        this.order(getRoot());
    }

    private void order(Node<T> node){
        if(node != null) {
            this.order(node.getLeft());
            System.out.println(node.getKey() + ": " + node.getValue());
            this.order(node.getRight());
        }
    }

    // Path in preOrder
    public void preOrder() {
        this.preOrder(getRoot());
    }

    private void preOrder(Node<T> node) {
        if(node != null) {
            System.out.println(node.getValue());
            this.preOrder(node.getLeft());
            this.preOrder(node.getRight());
        }
    }

    // Path in posOrder
    public void posOrder() {
        this.posOrder(getRoot());
    }

    private void posOrder(Node<T> node) {
        if(node != null) {
            this.posOrder(node.getLeft());
            this.posOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    // AVL Tree logic
    void updateHeight(Node<T> n) {
        n.heightNode = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node<T> n) {
        return n == null ? -1 : n.heightNode;
    }

    int getBalance(Node<T> n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    Node<T> rotateRight(Node<T> y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node<T> rotateLeft(Node<T> y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node<T> rebalance(Node<T> z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public void insert(Integer key, T node) {
        this.root = this.insert(getRoot(), key, node);
    }

    Node insert(Node node, int key, T value) {
        if (node == null) {
            return new Node(key, value);
        } else if (node.key > key) {
            node.left = insert(node.left, key, value);
        } else if (node.key < key) {
            node.right = insert(node.right, key, value);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    public void delete(int key) {
        delete(getRoot(), key);
    }

    Node delete(Node node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        return node.getRight() == null ? node : mostLeftChild(node.getLeft());
    }

    public Node<T> find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    // Count elements
    public Integer countNodes() {
        return this.countNodes(this.getRoot());
    }

    private Integer countNodes(Node node) {

        if(node == null)
            return 0;
        else
            return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public void update(Integer key, T valueToUpdate) {
        Node<T> nodeFound = this.find(key);
        nodeFound.setValue(valueToUpdate);
    }
}
