package coding.challenge.randomizer;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomPrimeChecker implements Runnable {

	ConcurrentLinkedQueue<Integer> inputqueue;
	ConcurrentLinkedQueue<NumberNode> outputqueue;

	public RandomPrimeChecker(ConcurrentLinkedQueue<Integer> inputqueue, ConcurrentLinkedQueue<NumberNode> outputqueue) {
		this.inputqueue = inputqueue;
		this.outputqueue = outputqueue;
	}

	@Override
	public void run() {
		int num;
		System.out.println("Prime checker started");
		for (int i = 0; i < 15; i++) {
			while (!inputqueue.isEmpty()) {
				num = inputqueue.poll();
				NumberNode output = new NumberNode(num, isPrime(num));
				outputqueue.add(output);
			}
			try {
				Thread.currentThread().sleep(300);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	private boolean isPrime(int number) {
		if (number % 2 == 0 && number != 2 || number <= 0) {
			return false;
		}
		for (int k = 2; k < number / 2; k++) {
			if (number % k == 0)
				return false;
		}
		return true;
	}
}
