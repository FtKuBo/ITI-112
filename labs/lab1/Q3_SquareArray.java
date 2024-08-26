public class Q3_SquareArray{

	public static int[] createArray(int size) {
		
        int[] squareArray = new int[size];

		for(int i = 0; i<size; i++){
			squareArray[i] = i*i;
		}

		return squareArray;  
	}

	public static void main(String[] args){
		
		int[] squareArray = createArray(13);

		for(int param=0 ; param< squareArray.length ; param++ ) {
			System.out.println("The square of "+String.valueOf(param)+" is: "+String.valueOf(squareArray[param]));
		}
	}
}
