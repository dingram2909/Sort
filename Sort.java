/************************************************/
/*** Sort class which will contain a range    ***/
/*** of sorting methods.                      ***/
/*** Initially contains methods for reading   ***/
/*** and displaying an array of integers.     ***/
/***                                          ***/
/*** Initial Author: Jason Steggles 20/09/13  ***/
/*** Extended by: Daniel Ingram 27/10/13      ***/
/************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Size of array **/
	private int size;

	/** Number of used elements in array **/
	private int usedSize;

	/** Array of integers **/
	private int[] A;
	
	/** Counter for refinement **/
	private int few = 12;

	/** Global variables for counting sort comparisons **/
	/** Global comparison count for Insertion Sort **/
	public int compIS;
	/** Global comparison count for QuickSort **/
	public int compQS;
	/** Global comparison count for refined QuickSort **/
	public int compRQS;
	
	
	/** Global comparison count for Quicksort **/

	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialiase global count variables **/
		compIS = 0;
		compQS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}
	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	public void insertion() {
		
		int key;
		int j;
		
		for(int i = 0; i < usedSize; i++){
			key = A[i];
			j = i;
			
			while(j > 0 && key < A[j-1]){
				compIS++;
				A[j] = A[j-1];
				
				j = j-1;
				
			}
			
			A[j] = key;
		}
		
	}

	public void quickSort() {

		quickSort(A, 0, usedSize-1);
		
	}
	
	public void quickSort(int[] a, int l, int r){
		
		int p;
		
		if(r > l){
			p = partition(a, l, r);
			quickSort(a, l, p-1);
			quickSort(a, p+1, r);
		}
		else{
			return;
		}
		
	}
	
	public void refinedQS(){
		
		refinedQS(A, 0, usedSize-1);
		insertion();
		
	}
	
	public void refinedQS(int[] a, int l, int r){
		int p;
		
		if((r - l) > few){
			p = partition(a, l, r);
			refinedQS(a, l, p-1);
			refinedQS(a, p+1, r);
		}
	}
	
	public int partition(int[] a, int l, int r){
		int v = a[r];
		int pL = l;
		int pR = r;
		
		while(pL < pR){
			while(a[pL] < v){
				compQS++;
				pL++;
			}
			while((a[pR] >= v) && pR > l){
				compQS++;
				pR--;
			}
			
			if(pL < pR){
				swap(a, pL, pR);
			}
		}
		
		swap(a, pL, r);
		
		return pL;
		
	}
		
	public void swap(int[] a, int pL, int pR){
		int temp = a[pR];
		
		a[pR] = a[pL];
		
		a[pL] = temp;
	}

}
/** End of Sort Class **/
