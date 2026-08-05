package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 3 , 5 ,6 ,7,8,9,0,2,34,5,665,56,34,4};
		
		ForkJoinPool pool = new ForkJoinPool();
		
		
		SumTask task = new SumTask(arr , 0 , arr.length - 1);
		
		int result = pool.invoke(task);
		
		System.out.println(result);
		
		pool.shutdown();

	}

}

//fork join pool executor


class SumTask extends RecursiveTask<Integer>{
	
	private int[] arr;
	private int start ;
	private int end;
	
	public SumTask(int[] arr , int start , int end ) {
		this.arr = arr ;
		this.start = start;
		this.end = end ;
		
	}
	@Override
	protected Integer compute() {
		//base condition 
		if(end - start <= 2) {
			int sum = 0 ;
			for(int i = start ; i <= end ; i++) {
				sum = sum + arr[i];
			}
			return sum ; 
		}
		
		//main logic -> divide  fork
		int mid = (start + end) / 2;
		// strat to mid ......mid+1 to end 
		
		SumTask leftTask = new SumTask(arr , start , mid);
		SumTask rightTask = new SumTask(arr , mid+1 , end);
		
		leftTask.fork();
		int sum2 = rightTask.compute();
		
		int sum1 = leftTask.join();
		
		//join 
		
		return sum1 + sum2 ;
		
	}
	
}