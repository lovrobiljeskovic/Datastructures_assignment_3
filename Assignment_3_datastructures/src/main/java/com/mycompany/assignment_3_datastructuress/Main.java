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
public class Main {
    public static void main(String[] args) {
       ArraySymbolTableT<String, Integer> table = new ArraySymbolTableT<>();
       table.add("blabala", 0);
       table.add("lul", 1);
       table.add("lul", 2);
        System.out.println(table.search("lul"));
        
    }
   
   
}
