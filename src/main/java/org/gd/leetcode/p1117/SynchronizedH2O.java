package org.gd.leetcode.p1117;

class SynchronizedH2O implements H2O {

    private int hydrogen = 0;
    private int oxygen = 0;

    private synchronized void reset() {
        if (hydrogen == MAX_HYDROGEN && oxygen == MAX_OXYGEN) {
            hydrogen = 0;
            oxygen = 0;
            notifyAll();
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (hydrogen < MAX_HYDROGEN) {
                    releaseHydrogen.run();
                    hydrogen++;
                    reset();
                    break;
                } else {
                    wait();
                }
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (oxygen < MAX_OXYGEN) {
                    releaseOxygen.run();
                    oxygen++;
                    reset();
                    break;
                } else {
                    wait();
                }
            }
        }
    }
}
