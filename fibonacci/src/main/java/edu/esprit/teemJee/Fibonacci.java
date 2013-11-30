package edu.esprit.teemJee;

public class Fibonacci {
	public long fibo(long l) {
		if (l <= 1)

			return l;
		return fibo(l - 1) + fibo(l - 2);
	}
}
