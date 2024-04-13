package com.example.model;

import lombok.Data;

@Data
public class Node {
    int data;
    Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}
