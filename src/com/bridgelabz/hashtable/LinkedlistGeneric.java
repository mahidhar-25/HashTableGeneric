

package com.bridgelabz.hashtable;

/*

@desc :
MyMapNode Class:

A generic inner class MyMapNode<S , T represents a MyMapNode in the linked list.
Each MyMapNode contains data of type T and a reference to the next MyMapNode.
Insertion Methods:

insertAtEnd(T val): Inserts a new element with the specified value at the end of the linked list.
insertByPosition(T val, int position): Inserts a new element with the specified value at the specified position in the linked list.
insertAtBegin(T val): Inserts a new element with the specified value at the beginning of the linked list.
insertByOrder(T data): Inserts a new element with the specified data in ascending order.
Deletion Methods:

pop(): Deletes the first element of the linked list.
popLast(): Deletes the last element of the linked list.
popByKey(T key): Deletes the element with the specified key from the linked list.
Search Method:

search(T val): Traverses the linked list to find and return the MyMapNode with the given data value.
Other Methods:

insertAfterMyMapNode(MyMapNode<T> MyMapNode, T data): Inserts a new MyMapNode with the given data after the specified MyMapNode.
printList(): Traverses and prints each element in the linked list.
size(): Returns the size (number of elements) in the linked list.
Main Method:

The main method demonstrates the usage of the generic linked list with various use cases, including insertion at different positions, deletion, searching, and ordered insertion.
 */
public class LinkedlistGeneric<S extends Comparable<S> , T extends Comparable<T>  > {

    MyMapNode<S , T> head;

    public LinkedlistGeneric() {
        this.head = null;
    }
//initialization of a MyMapNode

    @Override
    public String toString() {
        return "LinkedlistGeneric{" +
                "head=" + head +
                "}\n";
    }


/*

 @desc : Inserts a new element with the specified value at the end of the linked list of given type T.

 @param val The value to be inserted of type T.

 @return No explicit return value.

 */

    public void insertAtEnd(S key , T val){
        MyMapNode<S , T> latestMyMapNode = new MyMapNode<S , T>(key , val);
        latestMyMapNode.next = null;
        if(head == null){
            head = latestMyMapNode;
        }else{
            MyMapNode<S , T> last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = latestMyMapNode;
        }
    }

    /*

 @desc : Inserts a new element with the specified value at the position specified of the linked list of given type T.

 @param val The value to be inserted of type T.
 @param position the position to be inserted of type integer

 @return No explicit return value.

 */
    public  void insertByPosition(S key , T val , int position){
        MyMapNode<S , T> latestMyMapNode = new MyMapNode<S , T>(key , val);
        MyMapNode<S , T> nextMyMapNode = null;
        latestMyMapNode.next = null;

        if(head == null){
            head = latestMyMapNode;
        }else if(position==0){
            MyMapNode<S , T> temp = head;
            head = latestMyMapNode;
            latestMyMapNode.next = temp;
        }else{
            MyMapNode<S , T> last = head;
            int counter=1;
            while(last.next != null){
                if(counter == position){
                    nextMyMapNode = last.next;
                    break;
                }
                counter++;
                last = last.next;
            }
            if(position > counter){
                System.out.println("your entered position " + position + " is more than the linked list size");
                System.out.println("So we are adding at last");
            }
            last.next = latestMyMapNode;
            latestMyMapNode.next = nextMyMapNode;
        }
    }

    /*

 @desc : Inserts a new element with the specified value at the beginning of the linked list of given type T.

 @param val The value to be inserted of type T.

 @return No explicit return value.

 */

    public void insertAtBegin(S key , T val){
        MyMapNode<S , T> latestMyMapNode = new MyMapNode<S , T>(key , val);
        latestMyMapNode.next = null;
        if(head == null){
            head = latestMyMapNode;
        }else{
            MyMapNode<S , T> last = head;
            head = latestMyMapNode;
            head.next = last;
        }
    }

    /*
     @desc :  Inserts a MyMapNode with the specified data in ascending order in the linked list.
     This method compares the data of the current MyMapNode with the given data and inserts the new MyMapNode at the appropriate position.

      @param data The data to be inserted.
      @return : no return
     */
    public void insertByOrder(S key , T data) {
        MyMapNode<S , T> latestMyMapNode = new MyMapNode<S , T>(key , data);
        latestMyMapNode.next = null;

        if (head == null) {
            head = latestMyMapNode;
        } else {
            MyMapNode<S , T> currMyMapNode = head;
            MyMapNode<S , T> prev = null;

            // Traverse the list to find the appropriate position for insertion
            while (currMyMapNode != null && currMyMapNode.value.compareTo(data) < 0) {
                prev = currMyMapNode;
                currMyMapNode = currMyMapNode.next;
            }

            // Insert the new MyMapNode at the correct position
            if (prev == null) {
                latestMyMapNode.next = head;
                head = latestMyMapNode;
            } else {
                latestMyMapNode.next = currMyMapNode;
                prev.next = latestMyMapNode;
            }
        }
    }
       /*

 @desc : delete the first element if it is not null.

 @param : no params.

 @return : returns the deleted value.

 */

    public T pop(){
        T data = null;
        if(head != null){
            data = (T) head.value;
            head = head.next;

        }
        return data;
    }

/*
 @desc : delete the last element if it is not null.

 @param : no params.

 @return : returns the deleted value.

 */

    public T popLast(){
        T data = null;
        if(head != null){
            MyMapNode<S , T> last = head;
            MyMapNode<S , T> curr = last;
            while(last.next != null){
                curr = last;
                last = last.next;

            }
            if(last == curr){
                data = last.value;
            }
            if(curr.next != null) {
                data = curr.next.value;
            }
            curr.next = null;
        }
        return data;
    }

    /*
     @desc : delete the  element based on the key given if it is not null.

     @param : no params.

     @return : returns the deleted value.

     */
    public T popByKey( S key){
        T data = null;
        MyMapNode<S , T> currMyMapNode = head, prev = null;

        if (currMyMapNode != null && key.equals(currMyMapNode.key)) {
            data = (T)head.value;
            head = currMyMapNode.next;
        }
        while (currMyMapNode != null && !key.equals(currMyMapNode.key)) {
            prev = currMyMapNode;
            currMyMapNode = currMyMapNode.next;
        }

        if (currMyMapNode != null) {
            data = (T)currMyMapNode.value;
           if( prev != null)
               prev.next = currMyMapNode.next;
        }

        if (currMyMapNode == null) {
            System.out.println(key + " not found");
        }
        return data;

    }

    /*

    @desc :  This method traverses the linked list and find the MyMapNode with given data key.

    @param :  Type T , val.

    @return :  It returns a MyMapNode.
*/
    public MyMapNode<S , T> search(T val){
        MyMapNode<S , T> currMyMapNode = head;
        while ( currMyMapNode != null && currMyMapNode.value != val) {
            currMyMapNode = currMyMapNode.next;
        }
        return currMyMapNode;
    }
    /*

    @desc :  This method traverses the linked list and find the MyMapNode with given data key.

    @param :  Type T , val.

    @return : T - value.
*/
    public T getKeyValue(S key){
        T value = null;
        MyMapNode<S , T> currMyMapNode = head;
        while ( currMyMapNode != null && !key.equals(currMyMapNode.key)) {
            currMyMapNode = currMyMapNode.next;
        }
        if(currMyMapNode != null){
            value = currMyMapNode.value;
        }
        return value;
    }

    /*

   @desc :  This method traverses the linked list and find the MyMapNode with given data key.

   @param :  Type T , val.
             Type S , key

   @return : void
*/
    public void updateNode(S key , T value){
        MyMapNode<S , T> currMyMapNode = head;
        while ( currMyMapNode != null && !key.equals(currMyMapNode.key)) {
            currMyMapNode = currMyMapNode.next;
        }
        if(currMyMapNode != null){
            currMyMapNode.value = value;
        }else{
            insertAtEnd(key , value);
        }
    }


    /*
    @desc :  Inserts a new MyMapNode with the given data after the specified MyMapNode.
    @param MyMapNode The MyMapNode after which the new MyMapNode will be inserted.
    @param data The data to be inserted into the new MyMapNode.
    @return void
     */
     public void insertAfterMyMapNode(MyMapNode<S , T> myMapNode , S key , T data){
         MyMapNode<S , T> latestMyMapNode = new MyMapNode<S , T>(key , data);
         latestMyMapNode.next = null;
        if(myMapNode != null){
            MyMapNode<S , T> currMyMapNode = head;
            while (currMyMapNode != myMapNode) {
                currMyMapNode = currMyMapNode.next;
            }
            latestMyMapNode.next = currMyMapNode.next;
            currMyMapNode.next = latestMyMapNode;
        }
     }
    /*
        @desc :  This method traverses the linked list and prints each element.
        @param :  None.
        @return :  No explicit return value.
 */
    public void printList()
    {
        MyMapNode<S , T> currMyMapNode = head;
        System.out.print("LinkedList: ");
        while (currMyMapNode != null) {
            System.out.print(currMyMapNode.value + " ");
            currMyMapNode = currMyMapNode.next;
        }
        System.out.println();
    }

    /*
    @desc : it gives the size of the linkes list
    @param : no params
    @return : returns an integer
     */
    public int size(){
        int count =0;
        MyMapNode<S , T> currMyMapNode = head;
        while (currMyMapNode != null) {
            count++;
            currMyMapNode = currMyMapNode.next;
        }
        return count;
    }


}

