package lesson5HomeWork5;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road (60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        CyclicBarrier cb = new CyclicBarrier(cars.length);

        CountDownLatch countStart = new CountDownLatch(cars.length);

        CountDownLatch countFinish = new CountDownLatch(cars.length);

        Lock lock = new ReentrantLock();


        for (int i = 0; i < cars.length; i++) {
            final int carNum = i;
            final int carWin = i+1;
            new Thread(() -> {
                try {
                    cars[carNum].run();
                    cb.await();
                    countStart.countDown();

                    cb.await();

                    cars[carNum].runGo();


                       cars[carNum].runFirstFinish();

                        if (lock.tryLock(2, TimeUnit.SECONDS))
                        System.out.println("Car # " + carWin +" WIN");




                 cb.await();

                 countFinish.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        try {
            countStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            countFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

}
