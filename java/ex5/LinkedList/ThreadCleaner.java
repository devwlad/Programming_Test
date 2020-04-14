package com.company;

import java.util.*;

public class Main {

    public static void RemoveDuplicate(LinkedList<String> iList){
        HashSet tempSet = new HashSet();
        ListIterator<String> listIterator = iList.listIterator();
        while (listIterator.hasNext()){
            Object obj = listIterator.next();
            if (tempSet.contains(obj)){
                listIterator.remove();
            } else {
                tempSet.add(obj);
            }
        }
    }

    public static void main(String[] args) {

        String[] list = {"one", "one", "one", "two", "one", "three", "one", "three", "two"};

        LinkedList<String> iList = new LinkedList(Arrays.asList(list));
        Main.RemoveDuplicate(iList);
        for (String msg : iList){
            System.out.print(msg + " ");
        }
    }
}
