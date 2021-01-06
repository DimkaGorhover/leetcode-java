package org.gd.leetcode.p1117;

import java.util.concurrent.Semaphore;

class SemaphoreH2O implements H2O {

    private final Semaphore hydrogen = new Semaphore(0);
    private final Semaphore oxygen = new Semaphore(0);
    private final Semaphore lock = new Semaphore(1);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        releaseHydrogen.run();
        oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.acquire();
        hydrogen.release(MAX_HYDROGEN);
        releaseOxygen.run();
        oxygen.acquire(MAX_HYDROGEN);
        lock.release();
    }
}
