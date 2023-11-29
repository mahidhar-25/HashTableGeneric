package com.bridgelabz.hashtable;

import java.util.ArrayList;
/*
@desc :

The HashTable class is a generic implementation of a hash table in Java.
It utilizes an array of linked lists to handle collisions and efficiently store key-value pairs.
Here's a description of the class:

Operations:

add:
        Adds a new key-value pair to the hash table. If the key already exists, it updates the existing value.
remove:
        Removes a key-value pair from the hash table based on the provided key.
printHashTable:
        Prints the entire hash table, including all linked lists.
getKeyMapValue:
        Retrieves the value associated with a given key.
updateKeyMapValue:
        Updates the value associated with a given key.

These methods together provide the basic functionalities of a hash table, including insertion, deletion,
 and retrieval of key-value pairs, with collision resolution handled through linked lists.
 */
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
        if(root.getKeyValue(key) != null){
            root.insertAtEnd(key , value);
        }else{
            root.updateNode(key , value);
        }

    }

    /*
    @desc: Removes a node from the hash table based on the provided key.
    @param: S - key to be removed
    @return: void
*/

    public void remove(S key){
        int index = getHashIndex(key);
        LinkedlistGeneric<S , T> root = hashArray.get(index);
        root.popByKey(key);
    }
    /*
        @desc: Prints the entire hash table, including all linked lists.
        @params : no params
        @return: void
    */
    public void printHashTable(){
        for(int i=0;i<MAX_HASH_SIZE;i++){
            System.out.println(hashArray.get(i));
            System.out.println();
        }
    }
    /*
        @desc: Retrieves the value associated with the provided key from the hash table.
        @param: S - key for which the value is to be retrieved
        @return: T - the value associated with the key
    */
    public T getKeyMapValue(S key){
        int index = getHashIndex(key);
        LinkedlistGeneric<S , T> root = hashArray.get(index);
        return root.getKeyValue(key);
    }
    /*
        @desc: Updates the value associated with the provided key in the hash table.
        @param: S - key for which the value is to be updated
                T - new value to be set
        @return: void
    */
    public void updateKeyMapValue(S key , T newValue){
        int index = getHashIndex(key);
        LinkedlistGeneric<S , T> root = hashArray.get(index);
        root.updateNode(key , newValue);
    }
}
