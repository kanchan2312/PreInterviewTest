package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

/*
Task 1, Part 1: To measure how long each invocation of the method takes
 */
public class InvocationTime extends MyIncDec {
    private static int x = 150000;
    private static Logger logger = Logger.getLogger(InvocationTime.class.getName());

    public InvocationTime(int x) {
        super(x);
    }

    public static void main(String[] args) {
        calculateInvocationTiming(x);
    }

    public static void calculateInvocationTiming(int x) {
        MyIncDec myIncDec = new MyIncDec(x);

        //Calculate timings in Nano seconds
        long startTimeNano = System.nanoTime();
        myIncDec.increment();
        long endTimeNano = System.nanoTime();
        logger.info("Calling increment method, Invocation time in Nano seconds: " + (endTimeNano - startTimeNano));

        //Single method call taking less than 1 millisecond to run. So instead of single call using loop to make multiple calls
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 15000; i++) {
            myIncDec.increment();
        }
        for (int i = 0; i < 5; i++) {
            myIncDec.decrement();
        }
        long endTime = System.currentTimeMillis();
        logger.info("Calling increment and decrement methods multiple times, Invocation time in Milli seconds: " + (endTime - startTime));

        //Calculate timings using JAVA 8
        try {
            Instant start = Instant.now();
            Thread.sleep(1);
            myIncDec.increment();
            myIncDec.decrement();
            Instant end = Instant.now();
            logger.info("Calling increment and decrement methods one time, Invocation time in Milli seconds: " + Duration.between(start, end));
        } catch (InterruptedException e) {

        }

    }
}

/*
Task 1, Part 2

To measure the performance/timings of entire application or part of application, we can use Profilers eg NetBeans profiler
There are several other ways also for calculating elapsed time in Java:
-> System.currentTimeMillis()
-> System.nanoTime();
-> StopWatch class provided by the Apache Commons Lang API

 */
