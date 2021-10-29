package com.company;

public class Box {

    private volatile boolean box = false;
    private static final int triesNumber = 10;

    public void turnOnBox() throws InterruptedException {
        for (int i = 0; i < triesNumber; i++) {
            if (box == false) {
                box = true;
                System.out.println(Thread.currentThread().getName() + " включил тумблер \n");
            }
        }
    }

    public void turnOffBox() throws InterruptedException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Игра завершена, спасибо за то, что были с нами !");
                return;
            }
            if (box == true) {
                box = false;
                System.out.println(Thread.currentThread().getName() + " выключила тумблер  \n");
            }
        }
    }
}

