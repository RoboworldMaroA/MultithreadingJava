package questionTwo;
/*Marek Augustyn
 * Algorithms and Advanced Programming
 * Software Development Year 2 
 * 09/01/2022
 */

/*
 * 
 * There are ten drawers labeled from A-J. A is represented as drawer[0], B as drawer[1]…, J as 
drawer[9] each drawer containing 10,000 records (the Java code that generates the data for each 
drawer will be provided to you separately). You are required to compute the sum, average, 
maximum and minimum of the data contained in each drawer.
A. Write a multithreaded program that takes the data in each drawer (drawer[0] - drawer[9]) 
and compute the sum, average, maximum and minimum of the data using 10 separate 
threads. (20 Marks)
B. Write a program that combines the statistics computed from each thread above (Q2.a) and 
present the grand total, average, maximum and minimum of all the drawers. (10 Marks)
C. Explain the efficiency of your program by comparing it with a single threaded program. 
(5 marks)
 * 
 */

import java.util.ArrayList;
import java.util.Random;

//Class Drawer and Thread class
public class Drawer {

	// declare variable
	static int elementsInDrawer = 10000;// Amount of elements in the drawer
	static int sum = 0;// sum of numbers in drawer
	static int drawerNumber = 0;// what drawer you want to calculate

	@SuppressWarnings("unchecked")
	public static ArrayList<Integer>[] drawers = new ArrayList[10];

	// method to generate random numbers provided by teacher
	public static void generateDrawersData() {

		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			// Generates 10000 random numbers between 0 and 1000
			// I change to 6000 because my Eclipse did not display output from this array
			int[] numbers = random.ints(elementsInDrawer, 0, 1000).toArray();
			drawers[i] = new ArrayList<Integer>();
			for (int j = 0; j < numbers.length; j++) {
				drawers[i].add(numbers[j]);
			}
		}
	}// end of generateDrawersData

	// method to calculate a sum using single thread
	public static int calculateSumInDrawer(int drawerNumber) {
		// loop for each element in the drawer
		for (int j = 0; j < elementsInDrawer; j++) {

			int temp = drawers[drawerNumber].get(j);
			sum = sum + temp;
			// System.out.println(sum); //for testing app only
		}
		System.out.println("Sum for " + elementsInDrawer + " elements is: " + sum + "  using single thread");
		return sum;
	}

	// Method Calculate average in the drawers not using multiple threads
	public static int calculateAverageInDrawer(int drawerNumber) {
		int average = 0;// variable to store calculated average in drawer
		// loop for each element in the drawer
		for (int j = 0; j < elementsInDrawer; j++) {
			int temp = drawers[drawerNumber].get(j);
			sum = sum + temp;
			// System.out.println(sum); //for testing app only
		}
		average = sum / elementsInDrawer;// calculate average
		System.out.println("Average number for " + elementsInDrawer + " elements is: " + average);
		return average;
	}// end method average one thread

	// Method max value in the array single thread
	public static int findMaximumElementInDrawer2(int drawerNumber) {
		// int elementsInDrawer=elementsInDrawer2;
		int max;
		// max = data.get(0);
		max = drawers[drawerNumber].get(0);
		for (int j = 1; j < elementsInDrawer; j++) {
			if (drawers[drawerNumber].get(j) > max) {
				max = drawers[drawerNumber].get(j);
			}
			// System.out.println(max); //for testing app only
		}

		System.out.println("Max for " + elementsInDrawer + " elements is: " + max + " using single thread");
		return sum;
	}


	// Method min value in the array single therad
	public static int findMinimumElementInDrawer2(int drawerNumber) {
		// int elementsInDrawer=elementsInDrawer2;
		int min;
		min = drawers[drawerNumber].get(0);
		for (int j = 1; j < elementsInDrawer; j++) {
			if (drawers[drawerNumber].get(j) < min) {
				min = drawers[drawerNumber].get(j);
			}
			// System.out.println(min); //for testing app only
		}

		System.out.println("Min value for " + elementsInDrawer + " elements is: " + min + " using single thread.");
		return sum;
	}


    //MAIN CLASS
	public static void main(String[] args) {

		// create an 10 array list used to sorting , provided by Teacher
		generateDrawersData();
		System.out.println(" ");
		// printing all records in drawer A for testing application only
		// System.out.println("All elements in Drawer A " + drawers[0]);
		// System.out.println(" ");
		// System.out.println(drawers[9]); // printing all records in drawer J
		// System.out.println(drawers[0].contains(2)); // printing true if find 2 in
		// calculateSumInDrawer(0);
		// calculateAverageInDrawer(0);

		// create unique name for drawers
		ArrayList<Integer> drawerA = drawers[0];
		ArrayList<Integer> drawerB = drawers[1];
		ArrayList<Integer> drawerC = drawers[2];
		ArrayList<Integer> drawerD = drawers[3];
		ArrayList<Integer> drawerE = drawers[4];
		ArrayList<Integer> drawerF = drawers[5];
		ArrayList<Integer> drawerG = drawers[6];
		ArrayList<Integer> drawerH = drawers[7];
		ArrayList<Integer> drawerI = drawers[8];
		ArrayList<Integer> drawerJ = drawers[9];
		// System.out.println(drawerA.toString());//for test only

		// ############################### SUM THREADING
		// ############################################
		System.out.println("Printing Sum values integers in the arrays using therads:");
		long startTime = System.currentTimeMillis();// start counting

		// run calculation in 10 threads
		Thread t1 = new calculateSumInDrawerThread(drawerA, elementsInDrawer);
		Thread t2 = new calculateSumInDrawerThread(drawerB, elementsInDrawer);
		Thread t3 = new calculateSumInDrawerThread(drawerC, elementsInDrawer);
		Thread t4 = new calculateSumInDrawerThread(drawerD, elementsInDrawer);
		Thread t5 = new calculateSumInDrawerThread(drawerE, elementsInDrawer);
		Thread t6 = new calculateSumInDrawerThread(drawerF, elementsInDrawer);
		Thread t7 = new calculateSumInDrawerThread(drawerG, elementsInDrawer);
		Thread t8 = new calculateSumInDrawerThread(drawerH, elementsInDrawer);
		Thread t9 = new calculateSumInDrawerThread(drawerI, elementsInDrawer);
		Thread t10 = new calculateSumInDrawerThread(drawerJ, elementsInDrawer);
		// start computing
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		// stop calculations
		long endTime = System.currentTimeMillis();
		long runningTime = endTime - startTime;
		try {
			Thread.sleep(1000);// wait until finish before print rest of the calculations
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Sum all elements");
		System.out.println(runningTime + " millisecs (" + (runningTime / 1000.0) + " second.)");
		System.out.println();
		// #################################### END SUM  ################################################

		// ################################ Average  ####################################################
		// ################### Average elements using threads thread   ##################################

		System.out.println("Printing Average value integers in the arrays using therads:");

		long startTimeAverage = System.currentTimeMillis();

		Thread t1Average = new calculateAverageInDrawerThread(drawerA, elementsInDrawer);
		Thread t2Average = new calculateAverageInDrawerThread(drawerB, elementsInDrawer);
		Thread t3Average = new calculateAverageInDrawerThread(drawerC, elementsInDrawer);
		Thread t4Average = new calculateAverageInDrawerThread(drawerD, elementsInDrawer);
		Thread t5Average = new calculateAverageInDrawerThread(drawerE, elementsInDrawer);
		Thread t6Average = new calculateAverageInDrawerThread(drawerF, elementsInDrawer);
		Thread t7Average = new calculateAverageInDrawerThread(drawerG, elementsInDrawer);
		Thread t8Average = new calculateAverageInDrawerThread(drawerH, elementsInDrawer);
		Thread t9Average = new calculateAverageInDrawerThread(drawerI, elementsInDrawer);
		Thread t10Average = new calculateAverageInDrawerThread(drawerJ, elementsInDrawer);

		t1Average.start();
		t2Average.start();
		t3Average.start();
		t4Average.start();
		t5Average.start();
		t6Average.start();
		t7Average.start();
		t8Average.start();
		t9Average.start();
		t10Average.start();
		// stop counting
		long endTimeAverage = System.currentTimeMillis();
		try {
			Thread.sleep(1000);// wait until finish before print rest of the calculations
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		long runningTimeAverage = endTimeAverage - startTimeAverage;
		System.out.println(runningTimeAverage + " millisecs (" + (runningTimeAverage / 1000.0) + " second.)");
		System.out.println();
		// ################################# End Average    ###############################################

		
		
		// ################################ Maximum  ####################################################
		// ################### Maximum value of the element in the array using thread     ##################################
		// To find Maximum I will sort array using insertion Sort and then find Maximum value
		System.out.println("Printing Maximum value from the integers arrays using therads:");

		long startTimeMax = System.currentTimeMillis();

		// Finf maximum value in the arrays using threads
		Thread t1Max = new findMaxInDrawerThread(drawerA, elementsInDrawer);
		Thread t2Max = new findMaxInDrawerThread(drawerB, elementsInDrawer);
		Thread t3Max = new findMaxInDrawerThread(drawerC, elementsInDrawer);
		Thread t4Max = new findMaxInDrawerThread(drawerD, elementsInDrawer);
		Thread t5Max = new findMaxInDrawerThread(drawerE, elementsInDrawer);
		Thread t6Max = new findMaxInDrawerThread(drawerF, elementsInDrawer);
		Thread t7Max = new findMaxInDrawerThread(drawerG, elementsInDrawer);
		Thread t8Max = new findMaxInDrawerThread(drawerH, elementsInDrawer);
		Thread t9Max = new findMaxInDrawerThread(drawerI, elementsInDrawer);
		Thread t10Max = new findMaxInDrawerThread(drawerJ, elementsInDrawer);
		t1Max.start();
		t2Max.start();
		t3Max.start();
		t4Max.start();
		t5Max.start();
		t6Max.start();
		t7Max.start();
		t8Max.start();
		t9Max.start();
		t10Max.start();

		long endTimeMax = System.currentTimeMillis();
		try {
			Thread.sleep(1000);// wait until finish before print rest of the calculations
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		long runningTimeMax = endTimeMax - startTimeMax;
		System.out.println(runningTimeMax + " millisecs (" + (runningTimeMax / 1000.0) + " second.)");
		System.out.println();
		// ################################ END MAXIMUM  ######################################

		// ################################ Minimum      ####################################################
		// ################### Maximum value of the element in the array using thread   ##################################
		// To find Minimum I will sort array using insertion Sort and then find Maximum
		// value
		System.out.println("Printing Maximum value from the integers arrays using therads:");

		long startTimeMin = System.currentTimeMillis();

		// calculate minimum using 10 threads
		Thread t1Min = new findMinInDrawerThread(drawerA, elementsInDrawer);
		Thread t2Min = new findMinInDrawerThread(drawerB, elementsInDrawer);
		Thread t3Min = new findMinInDrawerThread(drawerC, elementsInDrawer);
		Thread t4Min = new findMinInDrawerThread(drawerD, elementsInDrawer);
		Thread t5Min = new findMinInDrawerThread(drawerE, elementsInDrawer);
		Thread t6Min = new findMinInDrawerThread(drawerF, elementsInDrawer);
		Thread t7Min = new findMinInDrawerThread(drawerG, elementsInDrawer);
		Thread t8Min = new findMinInDrawerThread(drawerH, elementsInDrawer);
		Thread t9Min = new findMinInDrawerThread(drawerI, elementsInDrawer);
		Thread t10Min = new findMinInDrawerThread(drawerJ, elementsInDrawer);
		t1Min.start();
		t2Min.start();
		t3Min.start();
		t4Min.start();
		t5Min.start();
		t6Min.start();
		t7Min.start();
		t8Min.start();
		t9Min.start();
		t10Min.start();

		long endTimeMin = System.currentTimeMillis();
		try {
			Thread.sleep(1000);// wait until finish before print rest of the calculations
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		long runningTimeMin = endTimeMin - startTimeMin;
		System.out.println(runningTimeMin + " millisecs (" + (runningTimeMin / 1000.0) + " second.)");
		System.out.println();

		// ################################## End Minimum    #######################################################

		/*
		 * Question 2 point B Write a program that combines the statistics computed from
		 * each thread above (Q2.a) and present the grand total, average, maximum and
		 * minimum of all the drawers. (10 Marks)
		 * 
		 */
		// #################################### GRAND TOTAL  ###############################################
		// System.out.println("Drawer A: "+((calculateSumInDrawerThread)
		// t1).getSum());//for test only
		// System.out.println("Drawer B: "+((calculateSumInDrawerThread)
		// t2).getSum());//for test only
		// calculate grand total - sum all threads

		int sumDrawer1 = ((calculateSumInDrawerThread) t1).getSum();
		int sumDrawer2 = ((calculateSumInDrawerThread) t2).getSum();
		int sumDrawer3 = ((calculateSumInDrawerThread) t3).getSum();
		int sumDrawer4 = ((calculateSumInDrawerThread) t4).getSum();
		int sumDrawer5 = ((calculateSumInDrawerThread) t5).getSum();
		int sumDrawer6 = ((calculateSumInDrawerThread) t6).getSum();
		int sumDrawer7 = ((calculateSumInDrawerThread) t7).getSum();
		int sumDrawer8 = ((calculateSumInDrawerThread) t8).getSum();
		int sumDrawer9 = ((calculateSumInDrawerThread) t9).getSum();
		int sumDrawer10 = ((calculateSumInDrawerThread) t10).getSum();

		int grandTotal = sumDrawer1 + sumDrawer2 + sumDrawer3 + sumDrawer4 + sumDrawer5 + sumDrawer6 + sumDrawer7
				+ sumDrawer8 + sumDrawer9 + sumDrawer10;

		System.out.println("Grant Total value is : " + grandTotal);

		// ########################################## End Grand Total  #################################################

		// ############################################## AVERAGE Total  ###############################################
		// System.out.println("Drawer A: "+((calculateAverageInDrawerThread)
		// t1Average).getAverage()); //for testing app only
		// System.out.println("Drawer B: "+((calculateAverageInDrawerThread)
		// t2Average).getAverage()); //for testing app only
		// calculate grand total - sum all threads

		int averageDrawer1 = ((calculateAverageInDrawerThread) t1Average).getAverage();
		int averageDrawer2 = ((calculateAverageInDrawerThread) t2Average).getAverage();
		int averageDrawer3 = ((calculateAverageInDrawerThread) t3Average).getAverage();
		int averageDrawer4 = ((calculateAverageInDrawerThread) t4Average).getAverage();
		int averageDrawer5 = ((calculateAverageInDrawerThread) t5Average).getAverage();
		int averageDrawer6 = ((calculateAverageInDrawerThread) t6Average).getAverage();
		int averageDrawer7 = ((calculateAverageInDrawerThread) t7Average).getAverage();
		int averageDrawer8 = ((calculateAverageInDrawerThread) t8Average).getAverage();
		int averageDrawer9 = ((calculateAverageInDrawerThread) t9Average).getAverage();
		int averageDrawer10 = ((calculateAverageInDrawerThread) t10Average).getAverage();

		int averageTotal = averageDrawer1 + averageDrawer2 + averageDrawer3 + averageDrawer4 + averageDrawer5
				+ averageDrawer6 + averageDrawer7 + averageDrawer8 + averageDrawer9 + averageDrawer10;
		System.out.println("Average Total from all drawers is : " + averageTotal);

		// ########################################## End average total    #################################################

		// ############################################## Maximum Total    ###############################################
		// System.out.println("Drawer A: "+((findMaxInDrawerThread) t1Max).getMax());
		// System.out.println("Drawer B: "+((findMaxInDrawerThread) t2Max).getMax());
		// calculate grand total - sum all threads

		int maxDrawer1 = ((findMaxInDrawerThread) t1Max).getMax();
		int maxDrawer2 = ((findMaxInDrawerThread) t2Max).getMax();
		int maxDrawer3 = ((findMaxInDrawerThread) t3Max).getMax();
		int maxDrawer4 = ((findMaxInDrawerThread) t4Max).getMax();
		int maxDrawer5 = ((findMaxInDrawerThread) t5Max).getMax();
		int maxDrawer6 = ((findMaxInDrawerThread) t6Max).getMax();
		int maxDrawer7 = ((findMaxInDrawerThread) t7Max).getMax();
		int maxDrawer8 = ((findMaxInDrawerThread) t8Max).getMax();
		int maxDrawer9 = ((findMaxInDrawerThread) t9Max).getMax();
		int maxDrawer10 = ((findMaxInDrawerThread) t10Max).getMax();

		int maximumTotal = maxDrawer1 + maxDrawer2 + maxDrawer3 + maxDrawer4 + maxDrawer5 + maxDrawer6 + maxDrawer7
				+ maxDrawer8 + maxDrawer9 + maxDrawer10;
		System.out.println("Max Total from all drawers is : " + maximumTotal);

		// ########################################## End maximum total  #################################################

		// ############################################## Minimum Total  ###############################################
		// System.out.println("Drawer A: "+((findMinInDrawerThread)
		// t1Min).getMin());//for test app
		// System.out.println("Drawer B: "+((findMinInDrawerThread)
		// t2Min).getMin());//for test app

		// calculate grand total - sum all threads
		int minDrawer1 = ((findMinInDrawerThread) t1Min).getMin();
		int minDrawer2 = ((findMinInDrawerThread) t2Min).getMin();
		int minDrawer3 = ((findMinInDrawerThread) t3Min).getMin();
		int minDrawer4 = ((findMinInDrawerThread) t4Min).getMin();
		int minDrawer5 = ((findMinInDrawerThread) t5Min).getMin();
		int minDrawer6 = ((findMinInDrawerThread) t6Min).getMin();
		int minDrawer7 = ((findMinInDrawerThread) t7Min).getMin();
		int minDrawer8 = ((findMinInDrawerThread) t8Min).getMin();
		int minDrawer9 = ((findMinInDrawerThread) t9Min).getMin();
		int minDrawer10 = ((findMinInDrawerThread) t10Min).getMin();

		// calculate total Minimum
		int minimumTotal = minDrawer1 + minDrawer2 + minDrawer3 + minDrawer4 + minDrawer5 + minDrawer6 + minDrawer7
				+ minDrawer8 + minDrawer9 + minDrawer10;
		System.out.println("Minimum Total from all drawers is : " + minimumTotal);

		// ########################################## End minimum total    #################################################

		
		// Question 2 point C:
		// ###############################      SUM Single THREADING      ############################################
		System.out.println("Question 2 point C:");
		// calculate all of the arrays don not use thread
		long startTimeSingleThread = System.currentTimeMillis();

		// loop for all drawers to get sum all drawers
		for (int s = 0; s < drawers.length; s++) {
			calculateSumInDrawer(s);
		}
		long endTimeSingleThread = System.currentTimeMillis();
		long runningTimeSingleThread = endTimeSingleThread - startTimeSingleThread;
		System.out.println("Time complexity for sum all elements in the arrays A-J using single thread");
		System.out.println(runningTimeSingleThread + " millisecs (" + (runningTimeSingleThread / 1000.0) + " second.)");
		System.out.println();
		// ####################################       END SUM          ################################################

		
		// ###############################       Average Single THREAD        ############################################
		// calculate all of the arrays don not use thread
		long startTimeAverageSingleThread = System.currentTimeMillis();

		for (int a = 0; a < drawers.length; a++) {
			calculateAverageInDrawer(a);// collect data from all drawers
		}

		long endTimeAverageSingleThread = System.currentTimeMillis();
		long runningTimeAverageSingleThread = endTimeAverageSingleThread - startTimeAverageSingleThread;
		System.out.println("Time complexity for Average all elements in the arrays A-J using single thread");
		System.out.println(runningTimeAverageSingleThread + " millisecs (" + (runningTimeAverageSingleThread / 1000.0)
				+ " second.)");
		System.out.println();
		// ####################################         END Average Single Thread    ################################################

		
		// ###############################       Max Single THREAD    ############################################
		// calculate all of the arrays don not use thread
		long startTimeMaxSingleThread2 = System.currentTimeMillis();

		// calculate all drawers
		for (int drawer = 0; drawer < drawers.length; drawer++) {

			findMaximumElementInDrawer2(drawer);
		}

		// stop counting
		long endTimeMaxSingleThread2 = System.currentTimeMillis();
		long runningTimeMaxSingleThread2 = endTimeMaxSingleThread2 - startTimeMaxSingleThread2;
		System.out.println(
				"Time Complexity for Maximum value all elements in the arrays A-J using single thread");
		System.out.println(
				runningTimeMaxSingleThread2 + " millisecs (" + (runningTimeMaxSingleThread2 / 1000.0) + " second.)");
		System.out.println();
		// ####################################      END Max method 2      ################################################

		
		// ###############################       Min Single THREAD Method     ############################################
		// calculate all of the arrays don not use thread
		long startTimeMinSingleThread = System.currentTimeMillis();

		// calculate all drawers
		for (int drawer = 0; drawer < drawers.length; drawer++) {

			findMinimumElementInDrawer2(drawer);
		}

		// stop counting
		long endTimeMinSingleThread = System.currentTimeMillis();
		long runningTimeMinSingleThread = endTimeMinSingleThread - startTimeMinSingleThread;
		System.out.println(
				"Time complexity for Minimum value all elements in the arrays A-J using single thread");
		System.out.println(
				runningTimeMinSingleThread + " millisecs (" + (runningTimeMinSingleThread / 1000.0) + " second.)");
		System.out.println();
		// ####################################         END Min method              ################################################

	}// end main class

}// end class Drawer

//####################################################################################################
//Additional classes used in application

//sum integers in the array - this class is using thread
class calculateSumInDrawerThread extends Thread {
//	int drawerNumber;
	int elementsInDrawer;
	ArrayList<Integer> data;
	private int sum;

	public calculateSumInDrawerThread(ArrayList<Integer> drawerA, int elementsInDrawer) {
		this.data = drawerA;
//		this.drawerNumber = drawerNumber;
		this.elementsInDrawer = elementsInDrawer;
	}

	public void run() {
		// loop all elements in array
		for (int j = 0; j < elementsInDrawer; j++) {
			int temp = data.get(j);// get an value element in the array
			sum = sum + temp;
			// System.out.println(sum); //for testing app only
		}
		System.out.println("Sum for " + elementsInDrawer + " elements is: " + sum + "  printed from thread"
				+ Thread.activeCount());
		return;

	}// end run method

	// get sum result
	public int getSum() {
		return sum;
	}

}

//average number from integers in the array - this class is using thread
class calculateAverageInDrawerThread extends Thread {
	// int drawerNumber;
	int elementsInDrawer;
	ArrayList<Integer> data;
	private int average;
	int sum;

	public calculateAverageInDrawerThread(ArrayList<Integer> drawerA, int elementsInDrawer) {
		this.data = drawerA;
		// this.drawerNumber = drawerNumber;
		this.elementsInDrawer = elementsInDrawer;
	}

	public void run() {
		// loop all elements in array

		for (int j = 0; j < elementsInDrawer; j++) {
			int temp = data.get(j);// get an value element in the array
			sum = sum + temp;
			// System.out.println(sum); //for testing app only
		}

		average = sum / elementsInDrawer;
		System.out.println("Results for drawer: " + Thread.currentThread().getName() + " .Average number for "
				+ elementsInDrawer + " elements is: " + average + ".");
		return;

	}// end run method

	// get sum result
	public int getAverage() {
		return average;
	}
}//end class calculateAverageDrawerThread



//Find MAX number from integers in the array - this class is using thread
class findMaxInDrawerThread extends Thread {
	// int drawerNumber;
	int elementsInDrawer;
	ArrayList<Integer> data;
	// int average;
	private int max;

	public findMaxInDrawerThread(ArrayList<Integer> drawerA, int elementsInDrawer) {
		this.data = drawerA;
		// this.drawerNumber = drawerNumber;
		this.elementsInDrawer = elementsInDrawer;
	}

	public void run() {
		// loop all elements in array to find max element
		// int max = data.get(0);
		for (int j = 1; j < elementsInDrawer; j++) {
			if (data.get(j) > max) {
				max = data.get(j);
			}
			// System.out.println(max); //for testing app only
		}

		System.out.println("Results for drawer: " + Thread.currentThread().getName() + " .Maximum number for "
				+ elementsInDrawer + " elements is: " + max + ".");
		return;

	}// end run method

	// get maximum result
	public int getMax() {
		return max;
	}

}//end Max thread class



//Find MIN number from integers in the array - this class is using thread
class findMinInDrawerThread extends Thread {
	// int drawerNumber;
	int elementsInDrawer;
	ArrayList<Integer> data;
	int min;

	public findMinInDrawerThread(ArrayList<Integer> drawerA, int elementsInDrawer) {
		this.data = drawerA;
		// this.drawerNumber = drawerNumber;
		this.elementsInDrawer = elementsInDrawer;
	}

	public void run() {
		// loop all elements in array to find min element
		// int min = data.get(0);
		for (int j = 1; j < elementsInDrawer; j++) {
			if (data.get(j) < min) {
				min = data.get(j);
			}
			// System.out.println(max); //for testing app only
		}

		System.out.println("Results for drawer: " + Thread.currentThread().getName() + " .Minimum number for "
				+ elementsInDrawer + " elements is: " + min + ".");
		return;

	}// end run method
		// getters minimum

	public int getMin() {
		return min;
	}
}//end class findMinInDrawerThread
