package examples.concurrency;

import java.time.LocalDateTime;


public class Task implements Runnable {
	private static int idCounter=0;
	private int id = ++idCounter;
	
	@Override
	public void run() {
		logStart();
		doTheWork();
		logFinished();
	}


	private void doTheWork() {
		try {

			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void logFinished() {
		if (id==1)
			System.out.println("First task finished : "+LocalDateTime.now());
		if (id==idCounter)
			System.out.println("Last task finished  : "+LocalDateTime.now());
	}

	private void logStart() {
		if (id==1)
			System.out.println("First task started  : "+LocalDateTime.now());
		if (id==idCounter)
			System.out.println("Last task started   : "+LocalDateTime.now());
	}


	@Override
	public String toString() {
		return "Task [id=" + id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
