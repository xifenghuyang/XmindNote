import java.util.concurrent.Semaphore;

/**
 * 本例中Semaphore的用法实际是保证，
 * 一直有5个人可以试图乘车，如果有1个人出发了，
 * 立即就有排队的人获得 许可
 * 可以看出Semaphore就是个计数器，其基本逻辑基于acquire/release，并没有太复杂的同步逻辑
 */
public class AbnormalSemaphoreSample {

    public static void main(String[] args)throws InterruptedException{
        Semaphore semaphore = new Semaphore(0);
        for (int i=0; i<10; i++){
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("Action...GO!");
        semaphore.release(5);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits()!=0){
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(5);
    }
}

class MyWorker implements Runnable{
    private String name;
    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        try{
            semaphore.acquire();
            log("Executed!");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void log(String msg){
        if(name == null){
            name = Thread.currentThread().getName();
        }
        System.out.println(name+" "+msg);
    }

}
