package models;

public class BinarySearchTree {

    private class Node extends Vertex {
        private int key;
        private Node left, right;

        public Node(int _value, Double _x, Double _y) {
            super(_x, _y);
            this.key = _value;
            this.left = this.right = null;
        }
    }

    private Node root;
    private Double x;
    private Double y;

    public BinarySearchTree(Double _x, Double _y) {
        this.x = _x;
        this.y = _y;
        this.root = null;
    }

    public void insert(int _value) {
        this.root = insertVal(this.root, _value);
    }

    private Node insertVal(Node _root, int _value) {
        if (_root == null) {
            _root = new Node(_value, this.x, this.y);
            return _root;
        }

        if (_value < _root.key) {
            _root.left = insertVal(_root.left, _value);
        } else if (_value > _root.key) {
            _root.right = insertVal(_root.right, _value);
        }
        return _root;
    }

    public void inorderTraversal() {
        if (root != null) {
            inorderTraversal(root);
        } else {
            System.out.println("Tree is empty");
        }
    }

    private void inorderTraversal(Node _root) {
        if (_root != null) {
            inorderTraversal(_root.left);
            System.out.print(_root.key + " ");
            inorderTraversal(_root.right);
        }
    }
}
