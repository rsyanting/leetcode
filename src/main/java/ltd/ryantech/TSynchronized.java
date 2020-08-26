package ltd.ryantech;

/**
 * @author jerry
 * @program demo
 * @package_name ltd.ryantech.readinglist.demo
 * @description
 * @create 2020/08/16 16:27
 **/

public class TSynchronized implements Runnable {

    static int i = 0;

    public void increase() {
        i++;
        System.out.println(Thread.currentThread().getName() + " : " + i);
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        TSynchronized tSynchronized = new TSynchronized();
        Thread aThread = new Thread(tSynchronized);
        Thread bThread = new Thread(tSynchronized);

//        System.out.println("i = " + i);
        aThread.start();
        bThread.start();
        System.out.println("i = " + i);
    }
}
