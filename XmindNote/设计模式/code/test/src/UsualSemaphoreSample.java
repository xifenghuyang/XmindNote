import java.util.concurrent.Semaphore;

/**
 * 本例中Semaphore的用法实际是保证，
 * 一直有5个人可以试图乘车，如果有1个人出发了，
 * 立即就有排队的人获得 许可
 */
public class UsualSemaphoreSample {

    public static void main(String[] args){
        System.out.println("Action...GO!");
        Semaphore semaphore = new Semaphore(5);
        for (int i=0; i<10; i++){
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
    }
}

class SemaphoreWorker implements Runnable{
    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        try{
            log("is waiting for a permit!");
            semaphore.acquire();
            log("acquired a permit!");
            log("executed!");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            log("release a permit!");
            semaphore.release();
        }
    }

    private void log(String msg){
        if(name == null){
            name = Thread.currentThread().getName();
        }
        System.out.println(name+" "+msg);
    }

}
