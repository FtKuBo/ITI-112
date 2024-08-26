public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static final int SIMULATION_DURATION = 24 * 3600;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
		int OptimalNumberOfSpots = 1; // we initialize the numbers of spots to 1

		while (true) {
			System.out.println("==== Setting lot capacity to: " + OptimalNumberOfSpots + "====");
			try {
				int average = 0;
				for (int i = 0; i < NUM_RUNS; i++) {

					ParkingLot parkingLot = new ParkingLot(OptimalNumberOfSpots);
					Simulator simulator = new Simulator(parkingLot, hourlyRate, SIMULATION_DURATION);

					long start = System.currentTimeMillis();
					simulator.simulate();
					long end = System.currentTimeMillis();
					average += simulator.getIncomingQueueSize();

					System.out.println("Simulation run " + i + " (" + (end - start)
							+ "ms); Queue length at the end of simulation run: " + simulator.getIncomingQueueSize());
				}

				if ((average / NUM_RUNS) <= THRESHOLD) {
					break;

				} else {
					OptimalNumberOfSpots++;
					// still not enough spots to meet demand
				}
			} catch (Exception e) {
				System.out.println("The algorithm ran into an exception: " + e);
			}
		}
		return OptimalNumberOfSpots;

	}

	public static void main(String args[]) {

		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}