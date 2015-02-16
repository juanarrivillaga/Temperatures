//Program Author: Juan Arrivillaga
import java.util.Scanner;
public class Temperatures {
	
	public static final String[] MONTH = {"January", "Febuary", "March", "April", "May", "June", 
											"July", "August", "September", "October", "November", "December"};
	public static double[][] yearTemp = new double [12][2];
	public static double [] temp = new double [2];
	
	
	
	
	public static void main(String[] args) {
		
		
		inputTempForYear();
		
		System.out.printf("%n%s%.2f%n%s%.2f","High average: ",calculateAverageHigh(yearTemp),"Low average: ",calculateAverageLow(yearTemp));
		System.out.printf("%n%s%.2f%n%s%.2f","Highest temperature occured in "+MONTH[findHighestTemp(yearTemp)]+" and it was: ", 
										yearTemp[findHighestTemp(yearTemp)][0],
									   "Lowest temperature occured in "+MONTH[findLowestTemp(yearTemp)]+" and it was: ",
									   yearTemp[findLowestTemp(yearTemp)][1]);
		
		
	}
	//this method prompts user for HIGHEST and LOWEST temperature for a month and stores them to temp variable
	public static void inputTempForMonth(int counter, double [][]temp){
		Scanner input = new Scanner(System.in);
		System.out.println("For the month of "+MONTH[counter]+" please enter the HIGHEST temperature: ");
		temp[counter][0] = input.nextDouble();
		//yearTemp[counter][0]= input.nextDouble();
		System.out.println("For the month of "+MONTH[counter]+" please enter the LOWEST temperature");
		//yearTemp[counter][1] = input.nextDouble();
		temp[counter][1] = input.nextDouble();	
		
	}
	
	//this method uses a for-loop to call inputTempForMonth for every month. creates and returns multidimensional array of hi-low temps for each month
	public static double [][] inputTempForYear(){
		double multiArray[][] = new double [12][2]; 
		for (int counter = 1; counter < 13; counter++){
			inputTempForMonth(counter-1,yearTemp);	
			multiArray[counter-1]=temp;
		}
		multiArray=yearTemp;
		return multiArray;
	}
	
	//calculates average high temperatures. uses multidimensional array as argument
	public static double calculateAverageHigh(double[][]temp){
		double highTempSum = 0;
		double average;
		
		for(int r = 0;r < temp.length; r++){// for-loop to sum elements of array
			highTempSum = highTempSum + temp[r][0]; // sum every element in the first position of every row
		}
		average = highTempSum; //store sum in new variable to calculate average
		average = average/temp.length; // average is sum divided by 12 months
		
		return average;
	}
	
	//this method calculates average low temperature. uses multidimensional array as argument
	public static double calculateAverageLow(double[][]temp){
		double highTempSum = 0;
		double average;
		
		for(int r = 0;r < temp.length; r++){// for-loop to sum elements of array
			highTempSum = highTempSum + temp[r][1]; // sum every element in the second position of every row
		}
		average = highTempSum; //store sum in new variable to calculate average
		average = average/temp.length; // average is sum divided by 12 months
		
		return average;
	}
	//this method finds highest temperature of the year and returns index of array element containing that value
	public static int findHighestTemp(double[][]temp){
		double max=temp[0][0];//assume that  the max temperature is in the first position (NOTE: only looking at High temperatures in first "column")
		int indexMax = 0;
		
		for(int counter = 1; counter<(temp.length);counter++ ){//loop skips first index because it is assumed to be the max initially...
			if (temp[counter][0]>max){//checks if current element in loop is greater than max and if so..
				//assigns that value to max and current counter value to indexMax
				max = temp[counter][0];
				indexMax = counter;//note:since the body checks if current element is strictly greater than, if it is equal to, max and indexMax keep current values
			}	
		}
		return indexMax;
	}
	//this method finds lowst temperature of the year and turns index of array element containing that value
	public static int findLowestTemp(double[][]temp){
		double min = temp[0][1]; //assume that the min temperature is in the first element (NOTE: only looking at Low temperatures in second "column")
		int indexMin = 0;
		
		for(int counter = 1; counter<(temp.length); counter++){//loop skips first index because it is assumed to be the min value initually...
			if(temp[counter][1]<min){//check if current element in loop is less than min and if so...
				//assigns that value to min and the current counter to indexMin
				min = temp[counter][1];
				indexMin = counter;
			}
		}
		return indexMin;
	}
	
	//This method just outputs the contents of a 2 dimensional arrays [row][column] format... used for debugging
	public static void outputArray(double [][] array){
		for (int row = 0; row <array.length; row++){
			for (int column = 0; column < array[row].length; column++){
				System.out.printf("%.2f ",array[row][column]);
			}
			System.out.println();
		}
	}
}
