package com.bridgelabz.hashtable;

import java.util.ArrayList;

public class HashTable<S extends Comparable<S> , T extends Comparable<T>  >{
    public static int MAX_HASH_SIZE = 10;
    public ArrayList<LinkedlistGeneric<S , T>> hashArray;

    /*
    @desc : constructor initializes an array of size max hash size variable
    @param : no param
    @return : no return;
     */

    HashTable(){
        hashArray = new ArrayList<>(MAX_HASH_SIZE);
        for (int i = 0; i < MAX_HASH_SIZE; i++) {
            hashArray.add(new LinkedlistGeneric<>());
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "hashArray=" + hashArray +
                "}\n";
    }

    /*
        @desc : it gives a hash index or hash value with in the range given by user
        @param : S - key
        @return : int - return hash index
         */
    public int getHashIndex(S key){
        int hashValue = key.hashCode();
        return Math.abs(hashValue % 10);
    }

    /*
    @desc : this method add a new node into our hash table using linkedlist
    @param : S - key
             T - value
     @return : void
     */
    public void add(S key , T value){
        int index = getHashIndex(key);
        LinkedlistGeneric<S , T> root = hashArray.get(index);
        root.insertAtEnd(key , value);
    }

    public void printHashTable(){
        for(int i=0;i<MAX_HASH_SIZE;i++){
            System.out.println(hashArray.get(i));
            System.out.println();
        }
    }

    public T getKeyMapValue(S key){
        int index = getHashIndex(key);
        LinkedlistGeneric<S , T> root = hashArray.get(index);
        return root.getKeyValue(key);
    }

    public void updateKeyMapValue(S key , T newValue){
        int index = getHashIndex(key);
        LinkedlistGeneric<S , T> root = hashArray.get(index);
        root.updateNode(key , newValue);
    }
}
