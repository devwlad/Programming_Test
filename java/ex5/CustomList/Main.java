package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList slList = new SinglyLinkedList();
        String[] list = {"one", "one", "one", "two", "one", "three", "one", "three", "two"};

        slList.insertList(list);
        slList.printList();
        slList.removeDuplicate();
        slList.printList();
        }
    }
}
