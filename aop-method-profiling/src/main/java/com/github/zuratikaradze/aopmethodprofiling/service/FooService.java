package com.github.zuratikaradze.aopmethodprofiling.service;

import org.springframework.stereotype.Component;


@Component
public class FooService {

    public void doShortJob() {
        sleep(1000);
    }

    public void doLongJob() {
        sleep(3000);
    }

    public void doSomethingThatThrowsException() {
        throw new RuntimeException("Simulated Exception.");
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}