package models.blockPath;

import javafx.animation.SequentialTransition;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.Queue;

import static models.blockPath.Grid.colorNode;

public class BFS {

    private MyNode[][] nodes;
    private MyNode startNode;
    private MyNode finishNode;
    private SequentialTransition stran;
    private boolean horizontals;
    public static int duration = 1;

    public BFS(MyNode[][] _nodes, MyNode _startNode, MyNode _finishNode, boolean _horizontals) {
        this.horizontals = _horizontals;
        this.nodes = _nodes;
        this.startNode = _startNode;
        this.finishNode = _finishNode;
        this.stran = new SequentialTransition();

        begin();
        markShortestPath();
    }

    private void begin() {
        Queue<MyNode> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            MyNode current = queue.poll();

            if (current == finishNode) {
                // Path found
                markShortestPath();
                return;
            }

            colorNode(current, startNode, finishNode, duration, stran, Color.BLUE);

            for (MyNode neighbor : getNeighbors(current)) {
                if (!neighbor.isVisited() && !neighbor.isWall()) {
                    neighbor.setVisited(true);
                    neighbor.setParentNode(current);
                    queue.add(neighbor);
                }
            }
        }
    }


    private void markShortestPath() {
        MyNode current = finishNode;

        while (current != null && current != startNode) {
            colorNode(current, startNode, finishNode, duration, stran, Color.GREEN);
            MyNode parent = current.getParentNode();  // Updated to use getParentNode()

            // Add a null check to avoid potential NullPointerException
            if (parent != null) {
                current = parent;
            } else {
                // Handle the case where the parent is null
                break;
            }
        }
    }

    private Iterable<MyNode> getNeighbors(MyNode node) {
        LinkedList<MyNode> neighbors = new LinkedList<>();
        int row = node.getRow();
        int col = node.getCol();

        if (row > 0 && !nodes[row - 1][col].isVisited() && !nodes[row - 1][col].isWall()) {
            neighbors.add(nodes[row - 1][col]);
        }
        if (row < nodes.length - 1 && !nodes[row + 1][col].isVisited() && !nodes[row + 1][col].isWall()) {
            neighbors.add(nodes[row + 1][col]);
        }
        if (col > 0 && !nodes[row][col - 1].isVisited() && !nodes[row][col - 1].isWall()) {
            neighbors.add(nodes[row][col - 1]);
        }
        if (col < nodes[0].length - 1 && !nodes[row][col + 1].isVisited() && !nodes[row][col + 1].isWall()) {
            neighbors.add(nodes[row][col + 1]);
        }

        if (horizontals) {
            if (row > 0 && col > 0 && !nodes[row - 1][col - 1].isVisited() && !nodes[row - 1][col - 1].isWall()) {
                neighbors.add(nodes[row - 1][col - 1]);
            }
            if (row > 0 && col < nodes[0].length - 1 && !nodes[row - 1][col + 1].isVisited() && !nodes[row - 1][col + 1].isWall()) {
                neighbors.add(nodes[row - 1][col + 1]);
            }
            if (row < nodes.length - 1 && col > 0 && !nodes[row + 1][col - 1].isVisited() && !nodes[row + 1][col - 1].isWall()) {
                neighbors.add(nodes[row + 1][col - 1]);
            }
            if (row < nodes.length - 1 && col < nodes[0].length - 1 && !nodes[row + 1][col + 1].isVisited() && !nodes[row + 1][col + 1].isWall()) {
                neighbors.add(nodes[row + 1][col + 1]);
            }
        }

        return neighbors;
    }
}
