/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_3_datastructuress;

import java.util.List;

/**
 *
 * @author lovro
 * @param <T>
 */
public class FlexibleArray<T> {

   
    public T[] arrayOfT=(T[]) new Object[10] ;
    int size = 0;
    
    public T get(int index) {
        return arrayOfT[index];
    }

    public void set(int index, T element) {
        arrayOfT[index] = element;
    }

    public void add(T element) {
        if (size >= arrayOfT.length) {
            T[] bigger = (T[]) new Object[arrayOfT.length * 2];
            System.arraycopy(arrayOfT, 0, bigger, 0, arrayOfT.length);
            arrayOfT = bigger;
        }
        arrayOfT[size] = element;
        size++;
    }

    public int size() {
      return size;
    }

}
