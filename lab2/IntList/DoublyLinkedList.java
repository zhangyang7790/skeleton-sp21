public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return; // 链表为空
        }

        // 如果要删除的是头节点
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // 链表只有一个节点的情况
            }
            return;
        }

        // 如果要删除的是尾节点
        if (tail.data == data) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null; // 链表只有一个节点的情况
            }
            return;
        }

        // 删除中间节点
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current != null) {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    public void reverse() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        System.out.println("原始链表:");
        list.printList();

        list.delete(3);
        System.out.println("删除3后的链表:");
        list.printList();

        list.reverse();
        System.out.println("反转后的链表:");
        list.printList();
    }
}
