package leetcode;

public class Prob191 {
    // you need to treat n as an unsigned value
   	public int hammingWeight(int n) {
		int weight = 0;
		for (int i = 0; i < 32; i++) {
			int y = n & 0x0001;
			if (y == 0x0001) {
				weight++;
			}
			n = n >> 1; 
		} 
		return weight;
	}
}

