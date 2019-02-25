/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_3_datastructuress;

import java.util.function.Consumer;

/**
 *
 * @author lovro
 */
public class Main {
    public static void main(String[] args) {
        String[] words = getWords();
        LinkedSymbolTableT<String, Integer> linked = new LinkedSymbolTableT<>();
        ArraySymbolTableT<String, Integer> array = new ArraySymbolTableT<>();
        HashSymbolTableT<String, Integer> hash = new HashSymbolTableT<>(words.length);
        BalancedTreeSymbolTable<String, Integer> tree = new BalancedTreeSymbolTable<>();
        time((v) -> {
            for (String word : words) {
                Integer count = linked.search(word);
                if (count != null) count++;
                else count = 1;
                linked.add(word, count);
            }
        });

        time((v) -> {
            for (String word : words) {
                Integer count = array.search(word);
                if (count != null) count++;
                else count = 1;
                array.add(word, count);
            }
        });

        time((v) -> {
            for (String word : words) {
                Integer count = hash.search(word);
                if (count != null) count++;
                else count = 1;
                hash.add(word, count);
            }
        });

        time((v) -> {
            for (String word : words) {
                Integer count = tree.search(word);
                if (count != null) count++;
                else count = 1;
                tree.add(word, count);
            }
        });
        
    }

    private static void time(Consumer<Void> method) {
        long millis = System.currentTimeMillis();
        System.out.println("Begin");
        method.accept(null);
        System.out.println("Duration " + (System.currentTimeMillis() - millis) + " MS");
    }
   
    private static String[] getWords() {
        try (WordFileReader in = new WordFileReader("/mnt/shared/CphBusiness/algo/Assignment_2/Assignment_3_datastructures/Shakespeare_Complete_Works_shorter.txt")) {
            return in.readAll().split(" ");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
   
}
