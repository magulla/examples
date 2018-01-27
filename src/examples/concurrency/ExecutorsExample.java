package examples.concurrency;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		int time = 0;        //now
		int interval = 1 * 2; // 2 seconds 
		Collection<Task> tasks = tasks(5);
		for (Task task : tasks) {
			time +=interval;    // first starts now, second in now+2 seconds, thrid in now+2+2 seconds .... and so on
			executor.schedule(task,time, TimeUnit.SECONDS);
		}
		executor.shutdown();
		loginfo(executor);
	}
	
	
	private static void loginfo(ScheduledThreadPoolExecutor executor) {
		System.out.println("Active :"+executor.getActiveCount());
		System.out.println("Completed :"+executor.getCompletedTaskCount());
	}


	static Collection<Task> tasks(int numberOfTasks){
		LinkedList<Task> list = new LinkedList<Task>();
		for (int i = 0; i < numberOfTasks; i++) {
			list.add(new Task());
		}
		System.out.println("Created tasks ...");
		return list;
	}
	
}
