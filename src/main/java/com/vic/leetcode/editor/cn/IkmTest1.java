package com.vic.leetcode.editor.cn;

public class IkmTest1 {
    public IkmTest1() {
        this(10);
    }

    public IkmTest1(int data) {
        this.data = data;
    }

    public void display() {
        class Decrementer {
            public void decrement() {
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data=" + data);
    }

    private int data;

    public void a(){
        int data = 0;
        System.out.println(data);
    }

    public static void main(String[] args) {

        int data = 0;
        IkmTest1 t = new IkmTest1();
        t.display();
        System.out.println("data=" + data);
    }
}