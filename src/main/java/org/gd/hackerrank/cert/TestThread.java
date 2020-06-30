package org.gd.hackerrank.cert;

class TestThread {

    public static void main(String args[]) {
        SampleDemo A = new SampleDemo("A");
        SampleDemo B = new SampleDemo("B");
        try {
            B.start();
            A.start();
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            B.interrupt();
            A.interrupt();
        }
    }

    static class SampleDemo implements Runnable {

        private Thread t;
        private String threadName;

        SampleDemo(String threadName) {
            this.threadName = threadName;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.print(threadName);
            }
        }

        public void start() {
            if (t == null) {
                t = new Thread(this, threadName);
                t.start();
            }
        }

        public void interrupt() {
            if (t != null) {
                t.interrupt();
            }
        }
    }
}