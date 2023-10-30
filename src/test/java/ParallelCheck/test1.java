package ParallelCheck;

import org.testng.annotations.Test;

public class test1 {
	
	Thread th = new Thread();
	@Test
	public void method1() {
		
		System.out.println("-----Test1 ------Method1---- "+th.currentThread().getId());
	}
	@Test
	public void method2() {
		
		System.out.println("-----Test1 ------Method2---- "+Thread.currentThread().getId());
	}
	@Test
	public void method3() {
		
		System.out.println("-----Test1 ------Method3---- "+Thread.currentThread().getId());
	}
	@Test
	public void method4() {
		
		System.out.println("-----Test1 ------Method4---- "+Thread.currentThread().getId());
	}

}
