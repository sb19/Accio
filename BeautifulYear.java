/*

Beautiful Year

It seems like the year of 2013 came only yesterday. Do you know a curious fact? 
The year of 2013 is the first year after the old 1987 with only distinct digits.
Now you are suggested to solve the following problem: given a year number,
find the minimum year number which is strictly larger than the given one and has only distinct digits.

*/


import java.util.*;
import java.io.*;
public class Main
{

  public static void main (String args[])
  {
    Scanner sc = new Scanner (System.in);
    int year = sc.nextInt ();
    int[] rem = new int[4];	//to store the digits of the year (here remainder)

    int temp = year;
    int count = 0, r = 0;
    boolean duplicate = false;
    while (true)		// will run till we get the year having unique digits.
      {
	duplicate = false;
	int[] freq = new int[11];	//creating new frequency array for every new year to know the occurence of the digits.
	  count++;
	  temp = year + count;	//checking the next year.
	int i = 0;
	while (temp > 0)	//to store all the digits in a year.
	  {
	    r = temp % 10;
	    temp = temp / 10;
	    rem[i] = r;
	    freq[rem[i]]++;	//incrementing the occureance of a digit in a year
	    i++;
	  }
	for (int j = 0; j < freq.length; j++)	// check if the duplicate digit is there in the year or not.
	  {
	    if (freq[j] > 1)
	      duplicate = true;
	  }
	if (duplicate == false)
	  break;

      }
    System.out.println (year + count);
  }
}


