package leetcode;

public class Prob326 {
	    public boolean isPowerOfThree(double n) {
	        if (n == 3 || n == 1) {
	            return true;
	        } 
	        else if (n < 3) {
	            return false;
	        }
	        return isPowerOfThree(n/3);
	    }
	}

