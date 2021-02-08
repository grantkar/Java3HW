package lesson4HomeWork4;

public class Main {
    static Object mon = new Object();
    static volatile int num = 1;
    static final int count = 5;


    public static void main(String[] args) {

        new Thread(() -> {
            try {
            for (int i = 0; i < count; i++) {
                synchronized (mon) {
                    while (num != 1) {

                          mon.wait();
                        }
                    System.out.print("A ");
                    num = 2;
                    mon.notifyAll();

                }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (mon) {
                        while (num != 2) {

                            mon.wait();
                        }
                        System.out.print("B ");
                        num = 3;
                        mon.notifyAll();

                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (mon) {
                        while (num != 3) {

                            mon.wait();
                        }
                        System.out.print("C ");
                        num = 1;
                        mon.notifyAll();

                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


    }
}
