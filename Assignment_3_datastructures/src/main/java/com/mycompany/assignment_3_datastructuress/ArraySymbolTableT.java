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
public class ArraySymbolTableT<Key, Value> {

    FlexibleArray<Key> keys = new FlexibleArray<>();
    FlexibleArray<Value> values = new FlexibleArray<>();

    public Value search(Key key) {
        int index = searchIndex(key);
        if (index != -1) {
            return values.get(index);

        } else {
            return null;
        }

    }

    public void add(Key key, Value value) {
        int index = searchIndex(key);
        if (index != -1) {
            values.set(index, value);
        }else {
          keys.add(key);
          values.add(value);
        }
    }

    private int searchIndex(Key key) {
        for (int i = 0; i < keys.size(); i++) {
            if (key.equals(keys.get(i))) {
                return i;
            }
        }
        return -1;
    }
    
}
