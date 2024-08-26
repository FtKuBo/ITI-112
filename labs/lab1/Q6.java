import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double[] grades = new double[10];

		for (int i = 0; i < 10; i++) {

			System.out.println("give me a valid grade for student " + i + 1 + ": ");
			grades[i] = scanner.nextDouble();
			while (!(grades[i] >= 0.00 && grades[i] <= 100.00)) {
				System.out.println("give me a valid grade for student " + i + 1 + ": ");
				grades[i] = scanner.nextDouble();
			}
		}

		System.out.println("the average is: " + calculateAverage(grades));
		System.out.println("the median is: " + calculateMedian(grades));
		System.out.println("the number of failures is: " + calculateNumberFailed(grades));
		System.out.println("the number of wins is: " + calculateNumberPassed(grades));

	}

	public static double[] sortArray(double[] notes) {

		for (int i = 0; i < notes.length - 1; i++) {
			for (int j = i; j < notes.length; j++) {
				if (notes[i] > notes[j]) {
					double temp = notes[i];
					notes[i] = notes[j];
					notes[j] = temp;
				}
			}
		}

		return notes;
	}

	public static double calculateAverage(double[] notes) {

		double avg = 0;
		for (double grade : notes) {
			avg += grade;
		}

		return avg / (notes.length);
	}

	public static double calculateMedian(double[] notes) {

		double[] sortedNotes = sortArray(notes);

		if (sortedNotes.length % 2 == 0) {
			double grade1 = sortedNotes[sortedNotes.length / 2 - 1];
			double grade2 = sortedNotes[sortedNotes.length / 2];

			return (grade1 + grade2) / 2;
		}

		else {
			return sortedNotes[sortedNotes.length / 2];
		}
	}

	public static int calculateNumberFailed(double[] notes) {

		int numberFailed = 0;
		for (double grade : notes) {
			if (grade < 50.0) {
				numberFailed++;
			}
		}

		return numberFailed;

	}

	public static int calculateNumberPassed(double[] notes) {

		int nubmerPassed = 0;
		for (double grade : notes) {
			if (grade >= 50.0) {
				nubmerPassed++;
			}
		}

		return nubmerPassed;
	}

}