package com.adara;

public class Part2 extends Thread {

    static int sleepTime;
    public static void main(String[] args) {
//        System.out.println("TODO: implement");
        Part2 test = new Part2();
        sleepTime=sleepTest();
        test.test();
    }

    /**
     * A loop that controls its loop rate at ~ 125 times per seconds
     * @param n number of times that is going to loop.
     * @return
     */
    public double loop(int n) {
        long start = System.currentTimeMillis(), end;
        for (int i = 0; i < n; i++) {
            if (i % 10 == 0) {
                try {
                    //Based on how fast the machine runs the code other than the sleep, the time of the sleep varies.
                    // The sleep time can be get from the initial test.
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        end = System.currentTimeMillis();
        return 1000.0 * n / (end - start);
    }

    //an initial code to determine the sleep time
    static private int sleepTest(){
        long start = System.currentTimeMillis(), end;
        for (int i = 0; i < 10000; i++) {
            if (i % 1 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        end = System.currentTimeMillis();
        return (int) ((9-(end-start)/10000.0)*10);
    }
    public void test() {
        double rate;
        for (int i = 300; i < 400; i++) {
            rate = loop(i);
            System.out.println("count=" + i + " rate=" + rate + " Elapsed Time=" + i / rate + " secs");
        }
    }
}
