package com.adara;

import java.util.HashMap;
import java.util.Map;

public class Part1 {

    public static void main(String[] args) {
//        System.out.println("TODO: implement");
        test();
    }

    /**
     * Given a list of random integers representing requests, choose 1 request randomly
     * and decide whether or not to bid based on the attribution (the last digit) of the chosen one.
     * @param rand the list of requests
     * @return the pair of the chosen request and the decision if to bid
     */
    public static Map<Integer, Boolean> bid(int[] rand) {
        int size = rand.length, bid = (int) (Math.random() * size), last = rand[bid] % 10;
        boolean hit = Math.random() * 10 < last;
        Map<Integer, Boolean> result = new HashMap<>();
        result.put(rand[bid], hit);
        return result;
    }

    public static void test() {
        //the map to store the last digit of the request, the total times that bid on such a request and the time that decide to get it.
        Map<Integer, int[]> result = new HashMap<>();
        Map<Integer, Boolean> tmp;//the bid result
        int[] rand = new int[100], cal;
        //produce the list of random requests
        for (int i = 0; i < 100; i++) {
            rand[i] = (int) (Math.random() * 100);
        }
        int num;
        //bid and record the bidding result
        for (int i = 0; i < 100000; i++) {
            tmp = bid(rand);
            for (Map.Entry<Integer, Boolean> entry : tmp.entrySet()) {
                num = entry.getKey() % 10;
                if (result.containsKey(num)) {
                    cal = result.get(num);
                    cal[0]++;
                    cal[1] += entry.getValue() ? 1 : 0;
                } else {
                    cal = new int[2];
                    cal[0] = 1;
                    cal[1] += entry.getValue() ? 1 : 0;
                    result.put(num, cal);
                }
            }
        }
        for (Map.Entry<Integer, int[]> e : result.entrySet()) {//print out the test result
            System.out.println(e.getKey() + "\t" + e.getValue()[0] + "\t" + e.getValue()[1]);
        }
    }
}
