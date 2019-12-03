public class JavaTimeoutThread {

    public static class MyThreadStop extends Thread {
        int value = 0;

        public void run() {
            while(true) {
                value += 5;
                System.out.println("Value is " + value);
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e) {}
            }
        }
    }

    public static void tenMinTimeout() {
        System.out.println("Calling tenMinTimeout");
        try {
            Thread.sleep(10*60*1000);
        }
        catch(Exception e) {}
    }

    public static void stopThread() {
        System.out.println("Calling stopThread");
    }

    public static void main(String[] args) {
        MyThreadStop myThreadStop = new JavaTimeoutThread.MyThreadStop();
        myThreadStop.start();

        tenMinTimeout();

        stopThread();
    }
}
