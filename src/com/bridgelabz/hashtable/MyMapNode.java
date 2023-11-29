package com.bridgelabz.hashtable;
/*
@desc : Class node is a generic class it contains and data and a next pointer of type T which we initialize

 */
    public class MyMapNode<S , T>{
        T value;
        S key;

    @Override
    public String toString() {
        return "(" +
                "value=" + value +
                ", key=" + key +
                ") ---- > " + "" + next ;
    }

    MyMapNode<S , T> next;
        /*
        @desc : constructor initializing node with value d of type T(object)
        @param - T(Type object primitive) - data
        @return : no return
         */
        MyMapNode(S key , T value){
            this.value = value;
            this.key = key;
            next = null;
        }
    }
