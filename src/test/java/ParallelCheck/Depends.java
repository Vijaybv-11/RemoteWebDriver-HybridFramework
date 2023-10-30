package ParallelCheck;

import org.testng.annotations.Test;

public class Depends {
	
	public String orderid=null;
	
	  
	  @Test public void createOrder() {
	  
	  System.out.println(5/0); System.out.println("Order Created");
	  orderid="ABC123"; }
	 
	 
	
	@Test(dependsOnMethods = { "createOrder" }/* ,ignoreMissingDependencies = true */)
	public void trackOrder() throws Exception {
		
		if(orderid!=null)
		System.out.println("tracking Order");
		else
			throw new Exception("Order ID missing");
	}
	
	@Test(dependsOnMethods = { "createOrder" }/* ,ignoreMissingDependencies = true */)
	public void deleteorder() throws Exception {
		
		if(orderid!=null)
		System.out.println("DeletingOrder");
	}

}
