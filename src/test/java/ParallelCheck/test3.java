package ParallelCheck;


import org.testng.annotations.Test;

public class test3 {
	
	
	@Test
	public void method1() {
		
		System.out.println("-----Test3 ------Method1---- "+Thread.currentThread().getId());
	}
	@Test
	public void method2() {
		
		System.out.println("-----Test3 ------Method2---- "+Thread.currentThread().getId());
	}
	@Test
	public void method3() {
		
		System.out.println("-----Test3 ------Method3---- "+Thread.currentThread().getId());
	}
	@Test
	public void method4() {
		
		System.out.println("-----Test3 ------Method4---- "+Thread.currentThread().getId());
	}

}
