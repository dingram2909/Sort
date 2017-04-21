/*************************************************/
/*** Simple test class for Sort class          ***/
/*** You should add your own test code in here ***/
/***                                           ***/
/*** Author: Daniel Ingram					   ***/
/*** Student Number: 083808582				   ***/
/*** Date: 27/10/2013						   ***/
/*************************************************/
import java.io.*;
import java.text.*;

public class TestSort {
	public static void main(String[] args) {
		Sort insertionTest = new Sort(100);

		/** Read in test data into array **/
		insertionTest.readIn("src/test4.txt");

		/** Run insertion sort method on array **/
		insertionTest.insertion();

		/** Display array **/
		insertionTest.display(10, "Array of Integers (Insertion Sort)");

		/** Display insertion sort comparison counter **/
		System.out.println("\nInsertion sort comparison counter: "
				+ insertionTest.compIS);

		Sort qsTest = new Sort(100);

		/** Read in test data into array **/
		qsTest.readIn("src/test4.txt");

		/** Run quicksort method on array **/
		qsTest.quickSort();

		/** Display array **/
		qsTest.display(10, "Array of Integers (QuickSort)");

		/** Display quicksort comparison counter **/
		System.out.println("\nQuicksort comparison counter: " + qsTest.compQS);

		Sort rqsTest = new Sort(100);

		/** Read in test data into array **/
		rqsTest.readIn("src/test3.txt");

		/** Run refined quicksort method on array **/
		rqsTest.refinedQS();

		/** Display array **/
		rqsTest.display(10, "Array of Integers (Refined QuicksSort)");

		/** Display quicksort comparison counter **/
		System.out.println("\nRefined Quicksort comparison counter: "
				+ (rqsTest.compQS + rqsTest.compIS));

	}

}
/** End of Test class **/
