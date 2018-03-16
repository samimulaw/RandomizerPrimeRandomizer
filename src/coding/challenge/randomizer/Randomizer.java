package coding.challenge.randomizer;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Randomizer implements Runnable {
	ConcurrentLinkedQueue<Integer> inputQueue;
	ConcurrentLinkedQueue<NumberNode> outputQueue;

	public Randomizer(ConcurrentLinkedQueue<Integer> inputQueue, ConcurrentLinkedQueue<NumberNode> outputQueue) {
		super();
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
	}

	@Override
	public void run() {
		Random random = new Random();

		
			for (int i = 1; i < 15; i++) {
				int num = random.nextInt(500);
				inputQueue.add(num);
				System.out.println("Added to input queue from randomizer:" + num);
				try {
					Thread.currentThread().sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (!outputQueue.isEmpty()) {
					NumberNode result = outputQueue.poll();
					System.out.println(" Integer: " + result.number + " isPrime: " + result.isprime);

				}

			}
		
	}

}
