package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class Box {

    AtomicBoolean box = new AtomicBoolean(false);
    boolean boxOn = true;
    boolean boxOff = false;
    int triesNumber = 10;
    long turnOnWaitTime = 1000;
    long turnOffWaitTime = 1000;

    public void turnOnBox() throws InterruptedException {
        for (int i = 0; i < triesNumber; i++) {
            if (box.compareAndSet(boxOff, boxOn)) {
                System.out.println(Thread.currentThread().getName() + " включил тумблер \n");
                Thread.sleep(turnOnWaitTime);
            }
        }
    }

    public void turnOffBox() throws InterruptedException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) return;
            try {
                Thread.sleep(turnOffWaitTime);
            } catch (InterruptedException e) {
                System.out.println("Игра завершена, спасибо за то, что были с нами !");
                return;
            }
            if (box.compareAndSet(boxOn, boxOff)) {
                System.out.println(Thread.currentThread().getName() + " выключила тумблер  \n");
            }
        }
    }
}

