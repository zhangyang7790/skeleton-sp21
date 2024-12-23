package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        front = 0;
        back = 0;
    }
     public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        size++;
    }

 
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[back] = item;
        back = (back + 1) % items.length;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[front];
        items[front] = null; 
        front = (front + 1) % items.length;
        size--;
        resizeIfNecessary();
        return item;
    }

    
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        back = (back - 1 + items.length) % items.length;
        T item = items[back];
        items[back] = null; 
        size--;
        resizeIfNecessary();
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(front + index) % items.length];
    }

  
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(front + i) % items.length];
        }
        items = newItems;
        front = 0;
        back = size;
    }

 
    private void resizeIfNecessary() {
        if (items.length >= 16 && size < items.length / 4) {
            resize(items.length / 2);
        }
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(front + i) % items.length]);
            System.out.print("->");
        }
        System.out.println();
    }
}
