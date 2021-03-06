package TreesAndGraphs;

import Base.BaseExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Count Complete Tree Nodes
 * https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3071/
 *
 * Given a complete binary tree, count the number of nodes.
 *
 */

public class TotalNodesInTree implements BaseExecutor {

    class Node<T> {

        Node(T data) {
            this.data = data;
        }

        void setChildNodes(List<Node<T>> list) {
            this.childNodes = list;
        }

        T data;
        List<Node<T>> childNodes = new ArrayList<Node<T>>();
    }

    int count = 0;

    int countNodesBFS(Node root) {

        if(root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            count++;
            for(int i = 0; i <temp.childNodes.size(); i++) {
                queue.add((Node)temp.childNodes.get(i));
            }
        }

        return count;
    }

    int countNodesDFS(Node root) {

        if(root == null) {
            return 0;
        }

        int count = 0;

        for(int i = 0; i <root.childNodes.size(); i++) {
            count += countNodesDFS((Node)root.childNodes.get(i));
        }

        return 1 + count;
    }

    @Override
    public void execute() {

        // Construct the tree
        Node root = new Node(1);
        Node c11 = new Node(11);
        Node c12 = new Node(12);
        Node c13 = new Node(13);
        Node c21 = new Node(21);
        Node c22 = new Node(22);
        List<Node> l1 = new ArrayList<>();
        l1.add(c11);
        l1.add(c12);
        l1.add(c13);
        List<Node> l2 = new ArrayList<>();
        l2.add(c21);
        l2.add(c22);
        c11.setChildNodes(l2);
        root.setChildNodes(l1);

        countNodesBFS(root);
        countNodesDFS(root);
    }

    public static void main(String[] args) {

        new TotalNodesInTree().execute();

    }

}
