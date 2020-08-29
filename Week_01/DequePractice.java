package org.mickey.homework.week1;

import java.util.Deque;
import java.util.LinkedList;



public class DequePractice {
    
    public static void main(String[] args) {
        demo();
        System.out.println();
        demo1();
        System.out.println();
        demo2();
    }


    public static void demo(){
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);


        String top = deque.peek();
        System.out.println(top);
        System.out.println(deque);


        while(deque.size() >0 ) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }


    public static void demo1(){
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");

        System.out.println(deque);

        String top = deque.getFirst();
        System.out.println(top);
        System.out.println(deque);


        while(deque.size()>0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }


    public static void demo2(){
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String top = deque.getLast();
        System.out.println(top);
        System.out.println(deque);

        while(deque.size()>0){
            System.out.println(deque.removeLast());
        }
        System.out.println(deque);
    }
}