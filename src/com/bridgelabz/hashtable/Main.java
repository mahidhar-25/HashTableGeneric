package com.bridgelabz.hashtable;

/*
@desc : this class is a main application running program for hashtable
 */
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
        String paragraph = "Paranoids are not paranoid " +
                "because they are paranoid but " +
                "because they keep putting themselves " +
                "deliberately into paranoid avoidable " +
                "situations " + "Paranoids are not paranoid " +
                "because they are paranoid but " +
                "because they keep putting themselves " +
                "deliberately into paranoid avoidable " +
                "situations ";

        //usecase 1 ,2
        findFrequencyOfWords(paragraph , newHashTable);
        System.out.println(newHashTable);
        System.out.println();
        System.out.println();

        //usecase 3 it has been deleted
        newHashTable.remove("avoidable");

        System.out.println(newHashTable);
    }
}
