package retryLogic;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.Utils.RetryAnalyzer;

public class retryCheck {

	@Test()
	public void test1() {

		Assert.assertEquals(false, true);
	}

	@Test()
	public void test2() {

		Assert.assertEquals(false, true);
	}

	@Test
	public void test3() {

		Assert.assertEquals(true, true);
	}
}
