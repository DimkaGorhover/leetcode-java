package org.gd.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * https://www.javatpoint.com/DatagramSocket-and-DatagramPacket
 *
 * @since 2019-09-17
 */
class UdpTest {

    public static void main(String[] args) throws Exception {

        Thread sender = new DatagramSender();
        Thread receiver = new DatagramReceiver();

        sender.start();
        receiver.start();

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

        receiver.interrupt();
        System.out.println("receiver joining ...");
        receiver.join();
        System.out.println("receiver joined");

        sender.interrupt();
        System.out.println("sender joining ...");
        sender.join();
        System.out.println("sender joined");
    }

    private static abstract class TestThread extends Thread implements AutoCloseable {

        @Override
        public String toString() { return getClass().getSimpleName(); }

        TestThread() {
            setName(getClass().getSimpleName());
        }

        @Override
        public abstract void run();

        @Override
        public abstract void close();

        @Override
        public void interrupt() {
            close();
            System.out.println(toString() + " --> interrupting ...");
            super.interrupt();
            System.out.println(toString() + " --> interrupted");
        }
    }

    private static class DatagramSender extends TestThread {

        DatagramSocket socket = null;

        @Override
        public void run() {
            try {
                socket = new DatagramSocket();
                InetAddress ip = InetAddress.getLocalHost();
                int i = 0;
                while (!isInterrupted()) {

                    byte[] str = String.format("send:%s:%s",
                            new DecimalFormat("000").format(i++),
                            UUID.randomUUID()).getBytes(StandardCharsets.UTF_16BE);

                    socket.send(new DatagramPacket(str, 0, str.length, ip, 3000));

                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200));
                    } catch (InterruptedException e) {
                        interrupt();
                        break;
                    }
                }

                System.out.println("stop sending");

            } catch (Exception e) {
                System.err.println(toString() + " --> " + e.toString());
            } finally {
                close();
            }
        }

        @Override
        public synchronized void close() {
            if (socket != null) {
                System.out.println(this + " --> closing socket ...");
                socket.close();
                System.out.println(this + " --> socket is closed");
                socket = null;
            }
        }
    }

    private static class DatagramReceiver extends TestThread {

        DatagramSocket socket = null;

        @Override
        public void run() {
            try {
                socket = new DatagramSocket(3000);
                DatagramPacket dp = new DatagramPacket(new byte[1024], 0, 1024);

                while (!isInterrupted()) {
                    socket.receive(dp);
                    String str = new String(dp.getData(), 0, dp.getLength(), StandardCharsets.UTF_16BE);
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println(this + " --> " + e.toString());
            } finally {
                close();
            }
        }

        @Override
        public synchronized void close() {
            if (socket != null) {
                System.out.println(this + " --> closing socket ...");
                socket.close();
                System.out.println(this + " --> socket is closed");
                socket = null;
            }
        }
    }
}