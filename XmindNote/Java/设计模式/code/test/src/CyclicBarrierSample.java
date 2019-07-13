import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 道CyclicBarrier其实反映的是线程并行运行时的协调，
 * 在下面的示例里，从逻辑上，5个工作线程其实更像是
 * 代表了5个可以就绪的 空车，而不再是5个乘客
 * : 放多少屏障执行几次。线程注册后等待屏障条件触发
 */
public class CyclicBarrierSample {

    public static void main(String[] args){
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action...GO again!");
            }
        });

        for(int i=0; i<5; i++){
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable{
        private CyclicBarrier barrier;
        public CyclicWorker(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run(){
            try {
                for(int i=0; i<3; i++){
                    System.out.println("Executed!");
                    barrier.await();
                }
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
