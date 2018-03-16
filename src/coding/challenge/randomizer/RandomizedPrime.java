package coding.challenge.randomizer;


import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomizedPrime {
	public static void main(String args[]){
		ConcurrentLinkedQueue<Integer> inputQueue = new ConcurrentLinkedQueue<Integer>();
		ConcurrentLinkedQueue<NumberNode> outputQueue = new ConcurrentLinkedQueue<NumberNode>();		
		Thread randomizer= new Thread( new Randomizer(inputQueue, outputQueue));
		Thread primeChecker= new Thread(new RandomPrimeChecker(inputQueue,outputQueue));
		randomizer.start();
		primeChecker.start();
	}

}
