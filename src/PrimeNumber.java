//package com.telstra.cms.interview;

public class PrimeNumber {
			 
			 
	 /**
	 * Please add all the prime number between 0 and the number given.
	 * e.g if input is 5, output = 2+3+5
	 * if input is 10, output = 2+3+5+7
	 * if input is invalid, return 0
	 * 
		* @param num 
		* @return sum up all the prime number between 0 and given number.
	 */
	public int calcSum(Integer num) {
			
		Integer sumPrime = 0;
		if (num > 0) {
			for(int i=2; i<=num; i++) {
				if (isPrime(i)) {
					System.out.println(i + " is prime.");
					sumPrime = sumPrime + i;
				}
			}
		}
		return sumPrime;
	}

	private Boolean isPrime(int num){

		for (int y=2; y<=Math.sqrt(num); y++) {
			if (num % y == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args){
		
		Integer num = 10;

		PrimeNumber sumOfPrime = new PrimeNumber();
		System.out.print(sumOfPrime.calcSum(num));
	}

}
