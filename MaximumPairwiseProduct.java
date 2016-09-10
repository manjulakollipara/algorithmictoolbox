import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MaximumPairwiseProduct {

	Long[] array;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// Read the maximum array length from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Random random = new Random();
		long arrayLength =  Long.parseLong(br.readLine()); //random.nextInt(3) + 2 ; //

		//System.out.println("arrayLength: "+ arrayLength);
	/*	StringBuffer randomNumbers = new StringBuffer();
		for(int length=0 ; length < arrayLength ; length++){
			randomNumbers.append(String.valueOf(random.nextInt(1000))).append(" ");
			
		}*/
		String inputNumbers = br.readLine().trim();
		//System.out.println("inputNumbers: " + inputNumbers);

		String[] numbers = inputNumbers.split("\\s+");
		//System.out.println("numbers.length: "+ ( numbers.length)  + " arrayLength: "+ arrayLength);
		if ((numbers.length) < arrayLength) {
			System.out.println("Error in the input length of the array");
			System.exit(0);
		}

		MaximumPairwiseProduct mpp = new MaximumPairwiseProduct();
		long pairwiseMaxValue = mpp.getMaximumPairwiseProduct(numbers);
		System.out.println(pairwiseMaxValue);
	}

	private Long getMaximumPairwiseProduct(String[] numbers) {

		int arraySize = numbers.length;
		// initialize the array
		array = new Long[arraySize];

		// Convert string to long
		for (int i = 0; i < arraySize; i++) {
			array[i] = Long.parseLong(numbers[i]);
		}

		// Get first max number
		Long pairwiseProduct = 0l;
		long firstNumberValueIndex = 0;
		long firstMaxValue = 0;
		for (int i = 0; i < arraySize; i++) {

			if (array[i] > firstMaxValue) {
				firstMaxValue = array[i];
				firstNumberValueIndex = i;
			}
		}

		// Get second max number other than first max number
		long secondMaxValueIndex = 0;
		long secondMaxValue = 0;
		for (int i = 0; i < arraySize; i++) {

			if ((i != firstNumberValueIndex) && array[i] > secondMaxValue) {
				secondMaxValue = array[i];
				secondMaxValueIndex = i;
			}
		}
		
		//System.out.println("first max value : " + firstMaxValue  + " second max value: "+ secondMaxValue);

		// product of 2 numbers
		pairwiseProduct = firstMaxValue * secondMaxValue;

		return pairwiseProduct;

	}
}
