package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Prob54 {
	List<Integer> result=new ArrayList<Integer>();
	
	public List<Integer> spiralOrder(int[][] matrix) {
	     if(matrix == null || matrix.length == 0) {
	    	 return result;
	     }
	     int y2 = matrix.length-1; // rows
	     int x2 = matrix[0].length-1; // columns
	     recursion(matrix,0,0,x2,y2);
	     return result;
	}
	public void recursion(int[][] matrix,int x1,int y1,int x2,int y2) {
	    if(x1 > x2 || y1 > y2) {
	    	return ;
	    }
	    else if(x1 == x2 && y1 == y2) {// handle just one element
	        result.add(matrix[y1][x1]);
	    }
	    else if(y1==y2){ // handle just one row
	        for(int i=x1;i<=x2;i++) {
	            result.add(matrix[y1][i]);
	        }
	    }
	    else if(x1==x2){//handle just one col
	        for(int i=y1;i<=y2;i++) {
	            result.add(matrix[i][x1]);
	        }
	    }
	    else{ // handle m*n
	        for(int i=x1; i < x2; i++) result.add(matrix[y1][i]); // go right, across row
	        for(int i=y1; i< y2; i++) result.add(matrix[i][x2]); // go right, go down column
	        for(int i=x2; i>x1; i--) result.add(matrix[y2][i]); // go left, across bottom row
	        for(int i=y2; i>y1; i--) result.add(matrix[i][x1]); // go left, up column
	        recursion(matrix,x1+1,y1+1,x2-1,y2-1);
	    }
	}
}
