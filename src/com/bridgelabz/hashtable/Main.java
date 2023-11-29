package com.bridgelabz.hashtable;

public class Main {

    /*
    @desc : this finds the frequency of words and updates the hash table accordingly
    @params :  HashTable<String, Integer>  - hashtable
    @return : void
     */
    public static void findFrequencyOfWords(String paragraph, HashTable<String, Integer> newHashTable){
        String[] words = paragraph.split(" ");
        for (String word : words) {
           Integer value =  newHashTable.getKeyMapValue(word);
           if(value == null){
               newHashTable.add(word , 1);
           }else{
               newHashTable.updateKeyMapValue(word , value+1);
           }
        }
    }

    public static void main(String[] args) {
        System.out.println("!!! welcome to hash table program !!! ");
        HashTable<String , Integer> newHashTable = new HashTable<>();
        String paragraph = "In a quaint quaint village the sun rose in a quaint sky casting quaint shadows on quaint houses The" +
                " villagers quaint in their daily routine greeted each other with quaint smiles Quaint flowers adorned quaint " +
                "gardens and the air echoed with quaint laughter Quaint simplicity defined every quaint aspect of their quaint " +
                "existence";

        findFrequencyOfWords(paragraph , newHashTable);
        System.out.println(newHashTable);
    }
}
