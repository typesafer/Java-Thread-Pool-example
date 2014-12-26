 
//import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
import java.util.*;

public class Pooler {

		public static int add(int x, int y){
		int c = x + y;
		return c;
		}
		
    public static void main(String args[]) {
       ExecutorService service = Executors.newFixedThreadPool(10);
       for (int i =0; i<100; i++){
	   Random randomno = new Random();
	   int value = randomno.nextInt();
       service.submit(new Task(add(value,value)));
       }
    }
  
}


final class Task implements Runnable{
    private int taskId;
  
    public Task(int id){
        this.taskId = id;
    }
  
    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId +" performed by " 
                           + Thread.currentThread().getName());
    }
  
}


