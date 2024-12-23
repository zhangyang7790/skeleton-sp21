package deque;

public class LinkedListDeque<T> {
    
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;
    
    public LinkedListDeque() {
        sentinel = new Node(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }
     
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node current = sentinel.next;
        while(current != sentinel) {
            System.out.print(current.item + "");
            current = current.next;
        }
        System.out.println();
    }
    // Think about the picture of the node remove picture on the paper.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size--;
        return firstNode.item;
    }

    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        Node lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        size--;
        return lastNode.item;
    }

    public T get(int index) {
        if(index < 0 || index >= size){
            return null;
        }
            Node current = sentinel.next;
            for(int i = 0; i < index; i++) {
               current = current.next;
            }
            return current.item;
        }
        /**  I am not sure about if i need add the getRecursive method, same as the get method, but
         use recursion */
    }




  
