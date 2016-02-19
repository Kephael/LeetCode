package leetcode;

import java.util.ArrayList;

/*
 * Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1. e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20 all stepping numbers are 10 , 12 Return the numbers in sorted order.
 */
public class SteppingNumbers {

	public ArrayList<Integer> SteppingNumbers(int m, int n) {
		ArrayList<Integer> steppingNumbers = new ArrayList<Integer>();
		for (int i = m; i <= n; i++) {
			String val = Integer.toString(i);
			int first = val.charAt(0) - '0'; // values are always either ascending or descending from first value
			String increase = Integer.toString(first);
			String decrease = Integer.toString(first);
			for (int j = 1; j < val.length(); j++) {
				increase += Integer.toString(val.charAt(0) + j - '0');
				decrease += Integer.toString(val.charAt(0) - j - '0');
			}
			if (val.equals(increase) && val.length() > 1 || val.equals(decrease) && val.length() > 1) {
				steppingNumbers.add(i);
			}
		}
		return steppingNumbers;
	}
	
	public static void main(String[] args) {
		SteppingNumbers numbers = new SteppingNumbers();
		ArrayList<Integer> answer = numbers.SteppingNumbers(1, 8343545);
		System.out.println(answer);
	}

}
