package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SinglyLinkedList {

    static Node head = null;
    static Node last = null;
    static int size = 0;

    static class Node {
        String data;
        Node next;

        Node(String d){
            data = d;
            next = null;
        }
    }

    void removeDuplicate(){
        Node wlk1 = head;
        Node wlk2 = null;
        Node duplicate = null;

        while (wlk1 != null && wlk1.next != null){
            wlk2 = wlk1;

            while (wlk2.next != null){
                if (wlk1.data == wlk2.next.data){
                    duplicate = wlk2.next;
                    wlk2.next = wlk2.next.next;
                    System.gc(); // Can't forget the garbage collector
                } else {
                    wlk2 = wlk2.next;
                }
            }
            wlk1 = wlk1.next;
        }
    }

    void insertNode(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    void insertList(String @NotNull [] list){
        for (String msg : list){
            this.insertNode(msg);
        }
    }

    void printList(){
        Node wlk = head;
        while (wlk != null){
            System.out.print(wlk.data + " ");
            wlk = wlk.next;
        }
        System.out.println("");
    }

}