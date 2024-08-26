public class Q3_ReverseSortDemo {
	public static void main(String[] args) {
		char[] unorderedLetters;
		unorderedLetters = new char[] { 'b', 'm', 'z', 'a', 'u' };
		reverseSort(unorderedLetters);
		System.out.println("reversed text: ");
		for (int i = 0; i < unorderedLetters.length; i++)
			System.out.print(unorderedLetters[i]);
	}

	// method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values) {

		for (int i = 0; i < values.length - 1; i++) {
			for (int y = i; y < values.length; y++) {
				if (values[i] < values[y]) {
					char temp = values[i];
					values[i] = values[y];
					values[y] = temp;
				}
			}
		}
	}

}
