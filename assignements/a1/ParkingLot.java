import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the
		// private calculateLotDimensions(...) that I have provided
		// function implementd :)
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!

		lotDesign = new CarType[numRows][numSpotsPerRow];
		occupancy = new Car[numRows][numSpotsPerRow];

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the
		// private populateFromFile(...) that I have provided

		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		if (canParkAt(i, j, c)) {
			occupancy[i][j] = c;
		} else {
			System.out.println("You can't park your car here !");
		}

	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		if (i >= numRows || j >= numSpotsPerRow || occupancy[i][j] == null) {
			return null;
		}
		Car removed = occupancy[i][j];
		occupancy[i][j] = null;
		return removed;

	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {

		if (c.getType() == CarType.ELECTRIC) {
			return lotDesign[i][j] != CarType.NA && occupancy[i][j] == null;
		}
		if (c.getType() == CarType.SMALL) {
			return lotDesign[i][j] != CarType.NA && lotDesign[i][j] != CarType.ELECTRIC
					&& occupancy[i][j] == null;
		}
		if (c.getType() == CarType.REGULAR) {
			return lotDesign[i][j] != CarType.NA && lotDesign[i][j] != CarType.ELECTRIC
					&& lotDesign[i][j] != CarType.SMALL
					&& occupancy[i][j] == null;
		}
		if (c.getType() == CarType.LARGE) {
			return lotDesign[i][j] != CarType.NA && lotDesign[i][j] != CarType.ELECTRIC
					&& lotDesign[i][j] != CarType.SMALL
					&& lotDesign[i][j] != CarType.REGULAR
					&& occupancy[i][j] == null;
		}

		return false;

	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		int counter = 0;

		for (int i = 0; i < numRows; i++) {
			for (int y = 0; y < numSpotsPerRow; y++) {
				if (lotDesign[i][y] != CarType.NA && occupancy[i][y] == null) {
					counter++;
				}
			}
		}

		return counter;

	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		int counter = 0;
		for (int i = 0; i < numRows; i++) {
			for (int y = 0; y < numSpotsPerRow; y++) {
				if (occupancy[i][y] != null) {
					counter++;
				}
			}
		}

		return counter;
	}

	private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		numRows = 0;
		numSpotsPerRow = 0;

		while (scanner.hasNext()) {
			String str = scanner.nextLine();

			if (str.equals(SECTIONER)) {
				break;
			}

			if (!(str == "")) {
				numRows++;
				if (numSpotsPerRow == 0) {
					for (int i = 0; i < str.length(); i++) {
						if (str.substring(i, i + 1).equals(SEPARATOR)) {
							numSpotsPerRow++;
						}
					}
					numSpotsPerRow++;
				}
			}
		}
		scanner.close();
	}

	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		int row = 0;
		// while loop for reading the lot design
		while (scanner.hasNext()) {
			String str = scanner.nextLine();

			if (str == "") {
				continue;
			}

			if (str.equals(SECTIONER)) {
				break;
			}

			str = str.replaceAll("\\s+", "");

			int col = 0;

			for (int y = 0; y < str.length(); y++) {
				// switch to decide wich cartype to put in the lotDesign
				switch (str.substring(y, y + 1)) {
					case "E":
						lotDesign[row][col] = CarType.ELECTRIC;
						col++;
						break;
					case "S":
						lotDesign[row][col] = CarType.SMALL;
						col++;
						break;
					case "R":
						lotDesign[row][col] = CarType.REGULAR;
						col++;
						break;
					case "L":
						lotDesign[row][col] = CarType.LARGE;
						col++;
						break;
					case "N":
						lotDesign[row][col] = CarType.NA;
						col++;
						break;
				}
			}

			row++;
		}

		// while loop for reading occupancy data

		while (scanner.hasNext()) {
			String str = scanner.nextLine();

			if (str == "") {
				continue;
			}

			str = str.replaceAll("\\s+", "");
			String[] infos = str.split(",");

			int indxRow = Integer.valueOf(infos[0]);
			int indxCol = Integer.valueOf(infos[1]);
			String matricule = infos[3];
			Car car;
			switch (infos[2]) {
				case "E":
					car = new Car(CarType.ELECTRIC, matricule);
					if ((indxRow < numRows && indxCol < numSpotsPerRow) && occupancy[indxRow][indxCol] == null) {
						if (lotDesign[indxRow][indxCol] != CarType.NA) {

							occupancy[indxRow][indxCol] = car;
						} else {
							System.out
									.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
						}
					} else {
						System.out.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
					}
					break;
				case "S":
					car = new Car(CarType.SMALL, matricule);
					if ((indxRow < numRows && indxCol < numSpotsPerRow) && occupancy[indxRow][indxCol] == null) {
						if (lotDesign[indxRow][indxCol] != CarType.NA
								&& lotDesign[indxRow][indxCol] != CarType.ELECTRIC) {

							occupancy[indxRow][indxCol] = car;
						} else {
							System.out
									.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
						}
					} else {
						System.out.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
					}
					break;
				case "R":
					car = new Car(CarType.REGULAR, matricule);
					if ((indxRow < numRows && indxCol < numSpotsPerRow) && occupancy[indxRow][indxCol] == null) {
						if (lotDesign[indxRow][indxCol] != CarType.NA
								&& lotDesign[indxRow][indxCol] != CarType.ELECTRIC
								&& lotDesign[indxRow][indxCol] != CarType.SMALL) {

							occupancy[indxRow][indxCol] = car;
						} else {
							System.out
									.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
						}
					} else {
						System.out.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
					}
					break;
				case "L":
					car = new Car(CarType.LARGE, matricule);
					if ((indxRow < numRows && indxCol < numSpotsPerRow) && occupancy[indxRow][indxCol] == null) {
						if (lotDesign[indxRow][indxCol] != CarType.NA
								&& lotDesign[indxRow][indxCol] != CarType.ELECTRIC
								&& lotDesign[indxRow][indxCol] != CarType.SMALL
								&& lotDesign[indxRow][indxCol] != CarType.REGULAR) {

							occupancy[indxRow][indxCol] = car;
						} else {
							System.out
									.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
						}
					} else {
						System.out.println("Car " + car + " cannot be parked at (" + indxRow + ", " + indxCol + ")");
					}
					break;
			}

		}

		scanner.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " +
				lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " +
				lot.getTotalOccupancy());

		System.out.print(lot);

	}
}