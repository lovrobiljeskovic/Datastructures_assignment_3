/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_3_datastructuress;

/**
 *
 * @author lovro
 */
public class LinkedSymbolTableT<Key, Value> {
    private Node first;
    
    private class Node {
        Key key;
        Value value;
        Node next;
    }
    
    public void add(Key key, Value value) {
        Node n = searchNode(key);
        if (n != null) {
            n.value = value;
        } else {
            n = new Node();
            n.key = key;
            n.value = value;
            n.next = first;
            first = n;
        }
        
        
    }
    
    public Value search(Key key) {
       Node n = searchNode(key);
       if(n != null) {
           return n.value;
       } else {
           return null;
       }
    }
    
    private Node searchNode(Key key) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                return x;
            }
        }
        return null;
    }

    public void print() {
        for(Node x = first; x != null; x = x.next) {
            System.out.println(x.key + "=" + x.value);
        }
    }
    
}
