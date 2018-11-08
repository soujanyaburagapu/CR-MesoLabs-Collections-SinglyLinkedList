package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */

public class SinglyLinkedList<T extends Comparable<T>> {

    private Node head;
    private Node tail;
    private int nodeCount;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        nodeCount = 0;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node newTailNode = new Node(data);
            tail.setNext(newTailNode);
            tail = newTailNode;
        }
        nodeCount++;
    }

    public void insert(T data, int position) {
        if (position > size()) {
            throw new IllegalStateException("");
        }

        Node node = head;
        for (int i = 1; i < position && node != null; i++) {
            node = node.getNext();
        }

        Node newNode = new Node(data);
        Node nextNode = node.getNext();
        node.setNext(newNode);
        newNode.setNext(nextNode);

        nodeCount++;
    }

    public T removeAt(int position) {
        if (position > size()) {
            throw new IllegalStateException();
        }

        Node node = head;
        Node prevNode = head;

        for (int i = 1; i < position && node != null; i++) {
            prevNode = node;
            node = node.getNext();
        }

        T nodeData = node.getData();
        prevNode.setNext(node.getNext());

        nodeCount--;

        return nodeData;
    }

    public T remove() {
        if (head == null) {
            throw new IllegalStateException();
        }
        T data = head.getData();
        head = head.getNext();
        nodeCount--;
        return data;
    }

    public T get(int position) {
        if (position > size()) {
            throw new IllegalStateException();
        }
        Node node = head;
        for (int i = 1; i < position && node != null; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    public int find(T data) {
        if (head == null) {
            throw new IllegalStateException();
        }
        Node node = head;
        for (int i = 1; i < size() && node != null; i++) {
            T checkData = node.getData();
            if (checkData.equals(data)) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    public boolean contains(T data) {
        if (head == null) {
            throw new IllegalStateException("");
        }
        Node node = head;
        for (int i = 1; i < size() && node != null; i++) {
            T checkData = node.getData();
            if (checkData.equals(data)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<T>();

        Node node = head;

        for (int i = 1; i <= size() && node.getNext() != null; i++) {
            copy.add(node.getData());
            node = node.getNext();
        }

        copy.add(tail.getData());

        return copy;
    }

    public void sort() {
        if (head == null || head.getNext() == null) {
            throw new IllegalStateException();
        }

        boolean wasChanged;

        do {
            Node node = head;
            Node prevNode = null;
            Node nextNode = head.next;
            wasChanged = false;

            while (nextNode != null) {
                if (node.getData().compareTo(nextNode.getData()) > 0) {
                    wasChanged = true;
                    if (prevNode != null) {
                        Node temp = nextNode.next;

                        prevNode.next = nextNode;
                        nextNode.next = node;
                        node.next = temp;
                    } else {
                        Node temp = nextNode.next;

                        head = nextNode;
                        nextNode.next = node;
                        node.next = temp;
                    }
                    prevNode = nextNode;
                    nextNode = node.next;
                } else {
                    prevNode = node;
                    node = nextNode;
                    nextNode = nextNode.next;
                }
            }
        } while (wasChanged);

    }

    public int size() {
        return nodeCount;
    }

    public class Node {
        private Node next;
        private T data;

        public Node(T data) {
            this.next = null;
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

}
