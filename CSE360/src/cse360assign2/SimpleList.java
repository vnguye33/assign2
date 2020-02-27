package cse360assign2;
/* Van Nguyen 
 * 2/10/20
 * Class ID# 430
 * 
 * This program will be testing different functions such as add, remove, search, toString, and count
 * which will be using an array to store the 10 element that will be created in the constructor
 * and implementing each function so in the test case would be able to work in the JUNIT testing.
 */
public class SimpleList {

	private int[] list; 
	private int count;
	
	//This creates a constructor that initializes count to 0
	// and creates an array with 10 elements in it
	public SimpleList() {
		count = 0;
		list = new int[10];
	}
	
	// method where it adds an integer to the array
	public void add(int number) {
		// if the count is equal to the length of the array then it will
		//decrement the count. which is full
		if(count == list.length) {
			count--;
		}
		// the for loop iterates through and check to see if the index
		// is greater than 0 and decrements the index and setting the
		// index + 1 to the list of array to hold the number and set it
		// this is when it is not full
		for(int ind = count-1; ind >=0; ind--) {
			list[ind+1] = list[ind];
		}
		// the first index is being set to the int number and increment the count
		list[0] = number;
		count++;
	}
	
	//method to remove an integer from the array. create a variable to search for the number 
	// that will be remove in the for loop.
	public void remove(int number) {
		int place = search(number);
		if(place != -1) {
			//the for loop to the variable create that equals the number from the 
			// search function and setting it to be it if it equals and decrement
			// the count after the for loop
			for(int ind = place; ind < count; ind++) {
				list[ind] = list[ind++];
			}
			count--;
		}
	}
	
	//returns the count 
	public int count() {
		return count;
	}
	
	// this will return the array of int as a list of strings.
	//created a variable which is a string to be empty and that will 
	// go through the loop to print each element in the array. if the index
	// is less than the count, it will continue to print each element in the
	// array starting at 0 til the end. 
	public String toString() {
		String Str = "";
		int len = count;
		for(int ind = 0; ind < count; ind++) {
			if(ind == count - 1) {
				Str += list[ind] + "";
			}
			else {
				Str += list[ind] + " ";
			}
		}
		return Str;
	}
	
	//searches  for an int in the array and gives the index of the location
	// created a variable to be equal to -1 because it if not in the array
	// it will be -1 and iterates through loop to find if the number equals 
	// any of the element in the array
	public int search(int number) {
		int place = -1;
		for(int ind = 0; ind <= list.length; ind++) {
			if(list[ind] == number) {
				place = ind;	
			}
		}
		return place;
	}
	
}
