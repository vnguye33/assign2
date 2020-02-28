package cse360assign2;
/* Van Nguyen 
 * 2/27/20
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
			
			//creating a new list where it takes half the size of the old list and added to 
			//the old list itself
			int biggerSize = list.length + (list.length / 2);
			int[] bigList = new int[biggerSize];
			
			//putting the list from the old list to the bigger updated list and making it
			//so the element will go to the new list when list is set equal to bigList
			for(int ind = 0; ind < list.length; ind++) {
				bigList[ind] = list[ind];
			}
			list = bigList;
		}
		count++;

		// the for loop iterates through and check to see if the index
		// is greater than 0 and decrements the index and setting the
		// index + 1 to the list of array to hold the number and set it
		// this is when it is not full
		for(int ind = count-1; ind > 0; ind--) {
			list[ind + 1] = list[ind];
		}
		// the first index is being set to the int number and increment the count
		list[0] = number;
		
	}
	
	//method to remove an integer from the array. create a variable to search for the number 
	// that will be remove in the for loop.
	public void remove(int number) {
		
		// determining if the size of the list is less than 25% or not
		// if it was, would decrease the size
		if(list.length - count > (list.length * 0.25))
		{
			 int[] remList = new int [((int) (list.length - (list.length * 0.25)))];	
		
		//this will put the elements from the list to the new list which is updated with new size
		for(int ind = 0; ind < list.length; ind++) {
			remList[ind] = list[ind];
		}
		
		//removing the element from the list and shifting the elements over to the left
		for(int ind = search(number); ind < count; ind++) {
			remList[ind] = remList[ind + 1];
		}
		//turns the number being remove to 0 and decrementing the count
		remList[count - 1] = 0;
		count--;

	   }
		//just removing the elementfrom the list and shifting the element over to the left
		else {
		for(int ind = search(number); ind < count; ind++) {
			list[ind] = list[ind + 1];
		}
		list[count - 1] = 0;
		count--;
		}
		
	}
	//returns the count 
	public int count() {
		return count;
	}
	
	public void append(int num) {
		
		//creating a new list where it takes half the size of the old list and added to 
		//the old list itself
			if(count == list.length) {
				int biggerSize = list.length + (list.length / 2);
				int[] bigList = new int[biggerSize];
				
				//putting the list from the old list to the bigger updated list and making it
				//so the element will go to the new list when list is set equal to bigList
				for(int ind = 0; ind < list.length; ind++) {
					bigList[ind] = list[ind];
				}
				
				bigList[count] = num;
				count++;
			}
			//adding element to the end of the list
			else {
				list[count] = num;
				count++;
			}	
	}
	
	public int first() {
		//if the count is 0 menaing no element return -1
		if(count == 0) {
			return -1;
		}
		//return first element in list
		return list[0];
	}
	
	public int last() {
		//if the count is 0 menaing no element return -1
		if(count == 0) {
			return -1;
		}
		//return last element in list
		return list[count];		
	}
	
	
	public int size() {
		//return the lenght of the list
		return list.length;
	}
	// this will return the array of int as a list of strings.
	//created a variable which is a string to be empty and that will 
	// go through the loop to print each element in the array. if the index
	// is less than the count, it will continue to print each element in the
	// array starting at 0 til the end. 
	public String toString() {
		String Str = "";
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
