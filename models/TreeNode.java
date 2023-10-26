package models;

public class TreeNode extends Vertex {

    private TreeNode leftChild;
    private TreeNode rightChild;
    private TreeNode parent;
    private double value;

    public TreeNode(Double _value, Double _x, Double _y, TreeNode _leftChild, TreeNode _rightChild, TreeNode _parent) {
        super(_x, _y);
        this.value = _value;
        this.leftChild = _leftChild;
        this.rightChild = _rightChild;
        this.parent = _parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParentNode() {
        return parent;
    }

    public void setParentNode(TreeNode parent) {
        this.parent = parent;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
