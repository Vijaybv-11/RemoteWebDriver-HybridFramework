package Groups;

import org.testng.annotations.Test;

public class GroupTest {
	
	@Test(groups = {"Smoke"})
	public void test1() {
		
		System.out.println("Test 1 is test1");
	}
	@Test(groups= {"Sanity"})
	public void test2() {
		
		System.out.println("Test 2 is test2");
	}
	@Test(groups= {"Regression"})

	public void test3() {
		
		System.out.println("Test 3 is test3");
	}
	@Test(groups= {"Regression","Smoke"})
	public void test4() {
		
		System.out.println("Test 4 is test4");
	}

}
