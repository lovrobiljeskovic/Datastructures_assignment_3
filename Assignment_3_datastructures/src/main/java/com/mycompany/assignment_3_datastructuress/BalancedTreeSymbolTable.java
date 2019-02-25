package com.mycompany.assignment_3_datastructuress;

/**
 * BalancedTreeSymbolTable
 */
public class BalancedTreeSymbolTable<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node {
        private Node parent;
        private Node left;
        private Node middle;
        private Node right;

        private Key keyLeft;
        private Key keyRight;

        private Value value1;
        private Value value2;

        public String toString() {
            return String.format("[left=%s,right=%s,value1=%s,value2=%s,left=%s,middle=%s,right=%s]", keyLeft,keyRight,  value1, value2, left,middle,right); 
        }
    }

    public BalancedTreeSymbolTable() {
    }

    public void print() {
        printNode(root);
    }

    private void printNode(Node n) {
        if (n.keyLeft == null && n.keyRight == null) return;

        System.out.println(n.keyLeft + "=" + n.value1);
        if (n.keyRight != null) {
            System.out.println(n.keyRight + "=" + n.value2);
        }
        if (n.left != null) printNode(n.left);
        if (n.middle != null) printNode(n.middle);
        if (n.right != null) printNode(n.right);
    }
    
    public Value search(Key key) {
        if (root == null) return null;
        Node node = findNode(key);
        ////System.out.println("Search(" + key + ") node: "+  node);
        if (node.keyLeft.equals(key)) return node.value1;
        else if (node.keyRight != null && node.keyRight.equals(key)) return node.value2;
        else return null;
    }

    public void add(Key key, Value value) {
        if (root == null) {
            root = new Node();
            root.keyLeft = key;
            root.value1 = value;
            return;
        }
        //System.out.println("add(" + key + "," + value + ")");
        //print();
        Node node = findNode(key);
        insert(node, key, value);
    }


    private Node insert(Node node, Key key, Value value) {
        //System.out.println("insert(" + key + ", " + value + ") into " + node);
        if (node.keyLeft.equals(key)) {
            node.value1 =value;
            return null; 
        } 
        else if (node.keyRight != null && node.keyRight.equals(key)) {
            node.value2 = value;
            return null;
        }
        // If this is 2 node, no problem
        if (node.keyRight == null) {
            //System.out.println("keyRight is null");
            if (key.compareTo(node.keyLeft) < 0) {
                node.keyRight = node.keyLeft;
                node.value2 = node.value1;
                node.keyLeft = key;
                node.value1 = value;
            } else {
                node.keyRight = key;
                node.value2 = value;
            }
            return node;
        } 

        // this is a 4-node

        Key middleKey = key;
        Value middleValue = value;
        Node newNode = new Node();
        // new key is the smallest, old left would be in the middle
        if (key.compareTo(node.keyLeft) < 0) {
            //System.out.println("newKey is the smallest");
            // old right into new node
            newNode.keyLeft = node.keyRight;
            newNode.value1 = node.value2;

            middleKey = node.keyLeft;
            middleValue = node.value1;

            // node becomes new left node
            node.keyLeft = key;
            node.value1 = value;
            node.keyRight = null;
        }
        // new key is in the middle, so it remains in the middle
        else if (key.compareTo(node.keyRight) < 0) {
            //System.out.println("newKey is in the middle");
            newNode.keyLeft = node.keyRight;
            newNode.value1 = node.value2;
            node.keyRight = null;
        }
        // new key is the largest, old right would be in the middle
        else {
            //System.out.println("newKey is the largest");
            middleKey = node.keyRight;
            middleValue = node.value2;
            // new value becomes new node
            newNode.keyLeft = key;
            newNode.value1 = value;
            // old node becomes left
            node.keyRight = null;
        }
        
        // If we are at the root
        if (node.parent == null) {
            //System.out.println("Increasing tree depth");
            root = new Node();
            root.keyLeft = middleKey;
            root.value1 = middleValue;

            root.left = node;
            root.right = newNode;

            node.parent = root;
            newNode.parent = root;
            //System.out.println("new nodes;left=" + node + "right=" + newNode);
            return node;
        }  
        // node is already a 3 node, move middle up
        else {
            //System.out.println("Moving middle up");
            Node parent = insert(node.parent, middleKey, middleValue);

            if (node == node.parent.left) {
                node.parent.left = node;
                node.parent.middle = newNode;
            }
            else if (node == node.parent.right) {
                node.parent.middle = node;
                node.parent.right = newNode;
            }

            newNode.parent = parent;
            node.parent = parent; // redundant 
            return node.parent;
        }
    }

    /*
     * Finds the node containing the key
     * If key was not found returns the closest node
     * This should NEVER return null
     */
    private Node findNode(Key key) {
        Node n = root;
        while (n != null) {
            if (key.compareTo(n.keyLeft) == 0) {
                return n;
            }
            if (n.keyRight != null && key.compareTo(n.keyRight) == 0) {
                return n;
            }
            // go left
            if (n.left != null && key.compareTo(n.keyLeft) < 0) {
                n = n.left;
            }
            // go middle
            else if (n.middle != null && key.compareTo(n.keyRight) < 0) {
                n = n.middle;
            }
            // go right
            else if (n.right != null) {
                n = n.right;
            } else {
                return n;
            }
        }
        return null;
    }

}