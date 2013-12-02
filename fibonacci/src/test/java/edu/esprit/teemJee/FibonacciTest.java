package edu.esprit.teemJee;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FibonacciTest {
	private Fibonacci fibonacci;

	@BeforeMethod
	public void setUp() {
		fibonacci = new Fibonacci();
	}

	@Test
	public void shouldReturnOneWhenOneIn() {
		Assert.assertEquals(1, fibonacci.fibo(1));

	}
	
}
