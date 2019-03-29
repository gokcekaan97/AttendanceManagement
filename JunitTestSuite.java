import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTestSuite {

	@Test
	public void test() {
		assertEquals(25,Junit.sumOdds(10));
		assertNotSame(36,Junit.sumOdds(10));
		assertEquals(6,Junit.Factorial(3));
		assertNotSame(6,Junit.Factorial(6));
		assertEquals("a b",Junit.concateText("a","b"));
		assertNotSame("ab",Junit.concateText("a", "b"));
	}

}
