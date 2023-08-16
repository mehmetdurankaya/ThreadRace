package com.mdk.threadrace;

import java.util.List;
import java.util.ArrayList;

public class Course implements Runnable {
    public static List<Integer> thread1 = new ArrayList<>();
    public static List<Integer> thread2 = new ArrayList<>();
    public static List<Integer> thread3 = new ArrayList<>();
    public static List<Integer> thread4 = new ArrayList<>();
    public static List<Integer> evenNumbers = new ArrayList<>();//Çift sayılar
    public static List<Integer> oddNumbers = new ArrayList<>();//Tek sayılar

    List<Integer> numbers = new ArrayList<>();

    {
        for (int i = 0; i < 10000; i++) {//               2500 eleman alacak
            numbers.add(i);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (i < numbers.size() * 1 / 4) {//           2500  elaman alacak
                thread1.add(i);
            } else if (i < numbers.size() * 1 / 2) {//    2500  eleman alacak
                thread2.add(i);
            } else if (i < numbers.size() * 3 / 4) {//    2500  eleman alacak
                thread3.add(i);
            } else {
                thread4.add(i);
            }
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            for (Integer i : thread1) {
                add(i);
            }
        }
        if (Thread.currentThread().getName().equals("Thread-1")) {
            for (Integer i : thread2) {
                add(i);
            }
        }
        if (Thread.currentThread().getName().equals("Thread-2")) {
            for (Integer i : thread3) {
                add(i);
            }
        }
        if (Thread.currentThread().getName().equals("Thread-3")) {
            for (Integer i : thread4) {
                add(i);
            }
        }
    }

    public synchronized void add(int number) {
        if (number % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + " : " + number);
            evenNumbers.add(number);
        } else {
            System.out.println(Thread.currentThread().getName() + " : " + number);
            oddNumbers.add(number);
        }
    }
}
