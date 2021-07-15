package testpack;

public class ThreadTest {
    private static boolean ready;
    private static int i;

    private static class Runner extends Thread {
        public void run(){
            i = 0;
            while(!ready) {
                i++;
            }
            System.out.println("I is " + i);
        }
    }

    public static void main(String[] args) throws Exception{
        new Runner().start();
        Runner.sleep(1000);
        ready = true;

    }
}
