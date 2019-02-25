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
public class HashSymbolTableT<Key, Value> {

    
    ArraySymbolTableT<Key, Value>[] data;

    
   public HashSymbolTableT(int size) {
        this.data = new ArraySymbolTableT[size];
    }
   
    public Value search(Key key) {
        int index = searchIndex(key);
        ArraySymbolTableT<Key, Value> values = data[index];
        if (values != null) {
            return values.search(key);
        }
        return null;
    }
   
   public void add(Key key, Value value) {
        int index = searchIndex(key);
        ArraySymbolTableT<Key, Value> values = data[index];
        if(values == null) {
           data[index] = values = new ArraySymbolTableT<Key, Value>(); 
        }
        values.add(key, value);
    }

    private int searchIndex(Key key) {
        return Math.abs(key.hashCode()) % data.length;

    }

    public void print() {
        for (ArraySymbolTableT<Key, Value> oneData : data) {
            oneData.print();
        }
    }
}