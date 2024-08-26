public class Q3_ArrayInsertionDemo {

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {

		int[] newArray = new int[beforeArray.length + 1];

		newArray[indexToInsert] = valueToInsert;

		int indexprime = 0;

		for (int index = 0; index < newArray.length; index++) {

			if (newArray[index] == 0) {
				indexprime = index;

				if (index > indexToInsert) {
					indexprime--;
				}

				newArray[index] = beforeArray[indexprime];
			}

		}

		return newArray;

	}

	public static void main(String[] args) {

		int[] beforeArray = new int[] { 1, 5, 4, 7, 9, 6 };

		int indextoInsert = 3;
		int valueToInsert = 15;

		System.out.println("Array before insertion:");
		for (int value : beforeArray) {
			System.out.println(value);
		}

		int[] newArray = insertIntoArray(beforeArray, indextoInsert, valueToInsert);

		System.out.println("Array after insertion of " + 15 + " at position " + 3 + ": ");

		for (int vls : newArray) {
			System.out.println(vls);
		}

	}
}
