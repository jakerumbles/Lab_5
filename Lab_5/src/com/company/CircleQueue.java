/*************
 * Author: Jake Edwards
 * Class: CSC 241-001
 * Professor: Dr. Ivancic
 * Date: October 23, 2017
 * Project: Lab 5
 *
 * Class: CircleQueue
 * Purpose: insert purpose
 */

package com.company;

public class CircleQueue<T, S> {

    private Node front;
    private Node back;
    private int size;

    // default constructor
    public CircleQueue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    // add a node to the end of the queue
    public void enqueue(T name, S startingPos) {

        // create new node to enqueue
        Node<T, S> node = new Node<T, S>(name, startingPos);

        // queue is completely empty
        if (front == null && back == null) {

            front = node;
            back = node;
        }

        // queue has only one Node
        else if (front == back) {

            front.setNext(node);
            back = node;
        }

        // queue has more than one node already
        else {

            back.setNext(node);
            back = node;
        }
        size++;
    }

    // overloaded enqueue that accepts a node instead of parameters to create a new node
    public void enqueue(Node newNode) {

        // create new node to enqueue
        Node<T, S> node = newNode;

        // queue is completely empty
        if (front == null && back == null) {

            front = node;
            back = node;
        }

        // queue has only one Node
        else if (front == back) {

            front.setNext(node);
            back = node;
        }

        // queue has more than one node already
        else {

            back.setNext(node);
            back = node;
        }
        size++;
    }

    // remove a node from the front of the queue
    public Node dequeue() {

        // queue is already completely empty
        if (isEmpty()) {
            System.out.println("Cannot dequeue, queue is already empty.");
            front = null;
            back = null;
            return null;
        }

        // only 1 node in queue
        else if (front == back) {
            Node<T, S> temp = front; // to keep track of the front node so it can be returned
            front = null;
            back = null;
            size--;

            return temp;


        }

        // queue is not empty(more than 1 node)
        else {
            Node<T, S> temp = front; // to keep track of the front node so it can be returned
            front = front.getNext(); // move front up one node
            size--;

            return temp; // returns the node at the front of the queue
        }

    }

    public boolean isEmpty() {
        if (front == null && back == null) { // queue is empty so return true
            return true;
        }
        else { // queue is not empty so return false
            return false;
        }
    }

    public int getSize() {
        return this.size;
    }

    // Node class
    public class Node<T, S> {

        private T name;
        private S startingPos; // starting position
        private Node next;

        // default constructor
        public Node(T name, S startingPos) {
            this.name = name;
            this.startingPos = startingPos;
            this.next = null;
        }

        public Node(T name, S startingPos, Node next) {
            this.name = name;
            this.startingPos = startingPos;
            this.next = next;
        }

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }

        public S getStartingPos() {
            return startingPos;
        }

        public void setStartingPos(S startingPos) {
            this.startingPos = startingPos;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
