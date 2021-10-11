package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Box gameBox = new Box();
        Thread gamer = new Thread(() -> {
            try {
                gameBox.turnOnBox();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Пользователь");
        Thread game = new Thread(() -> {
            try {
                gameBox.turnOffBox();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Игрушка");

        gamer.start();
        game.start();

        gamer.join();
        game.interrupt();
    }
}
