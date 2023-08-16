package com.mdk.threadrace;

import com.mdk.threadrace.Course;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Course course = new Course();

        Thread t1 = new Thread(course);
        Thread t2 = new Thread(course);
        Thread t3 = new Thread(course);
        Thread t4 = new Thread(course);

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        t4.start();
        t4.join();

        System.out.println("Tek Sayılar: " + Course.oddNumbers.size());
        System.out.println("Çift Sayılar: " + Course.evenNumbers.size());

    }
}
