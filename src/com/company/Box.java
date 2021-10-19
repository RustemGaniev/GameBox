package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class Box {

    volatile boolean box = false;
    int triesNumber = 10;
    long turnOnWaitTime = 1100;
    long turnOffWaitTime = 1100;

    public void turnOnBox() throws InterruptedException {
        for (int i = 0; i < triesNumber; i++) {
            if (box == false) {
                box = true;
                System.out.println(Thread.currentThread().getName() + " включил тумблер \n");
                Thread.sleep(turnOnWaitTime);
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
                try {
                    Thread.sleep(turnOffWaitTime);
                } catch (InterruptedException e) {
                    System.out.println("Игра завершена, спасибо за то, что были с нами !");
                    return;
                }

            }
        }
    }
}

