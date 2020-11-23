package practice23;

public class Main {
    public static void main(String[] args) {
        Worker work = new Worker();
        while(true) {
            work.getTasks();
            work.doTasks();
            try {
                Thread.sleep((int)(Math.random()*1000)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
