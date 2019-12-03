import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    static class Producer extends Thread {
        BlockingQueue<Integer> pQueue = null;
        MyBlockingQueue<Integer> pMyQueue = null;
        Integer inpQ = 0;

        public Producer(BlockingQueue<Integer> queue) {
            pQueue = queue;
        }

        public Producer(MyBlockingQueue<Integer> queue) {
            pMyQueue = queue;
        }

        public void run() {

            while(true) {
                try {
                    inpQ += 10;
                    //pQueue.put(inpQ);
                    pMyQueue.put(inpQ);
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        BlockingQueue<Integer> cQueue = null;
        MyBlockingQueue<Integer> cMyQueue = null;

        public Consumer(BlockingQueue<Integer> queue) {
            cQueue = queue;
        }

        public Consumer(MyBlockingQueue<Integer> queue) {
            cMyQueue = queue;
        }

        public void run() {
            while(true) {
                try {
                    //Integer r = cQueue.take();
                    Integer r = cMyQueue.take();
                    System.out.println(r);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyBlockingQueue<K> {
        private Queue<K> queue = new LinkedList<K>();
        //private ReentrantLock lock = new ReentrantLock(true);
        private int qSize = 16;
        //private Condition notFull = lock.newCondition();
        //private Condition notEmpty = lock.newCondition();
        private Object notFull = new Object();
        private Object notEmpty = new Object();

        public MyBlockingQueue(int size) {
            qSize = size;
        }

        public void put(K value) {
            synchronized (queue) {
                while (queue.size() == qSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(value);
                queue.notifyAll();
            }
        }
        public K take() {
            K value = null;
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                value = queue.remove();
                queue.notifyAll();
            }
            return value;
        }
    }

    public static void main(String[] args) {
        //BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<Integer>(10);
        MyBlockingQueue<Integer> myQueue = new ProducerConsumer.MyBlockingQueue<Integer>(10);

        Producer pThread = new ProducerConsumer.Producer(myQueue);
        pThread.start();

        Consumer cThread = new ProducerConsumer.Consumer(myQueue);
        cThread.start();
    }
}
