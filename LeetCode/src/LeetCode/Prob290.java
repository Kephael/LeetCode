/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space
 */

package LeetCode;

import java.util.HashMap;

public class Prob290 {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		String[] words = str.split("\\s+");
		if (words.length == pattern.length()) {
			for (int i = 0; i < words.length; i++) {
				if (map.containsValue(words[i]) && !map.containsKey(pattern.charAt(i))) { // bijection check
					return false;
				}
				map.put(pattern.charAt(i), words[i]);
			}
			String buildStr = "";
			for (int i = 0; i < pattern.length(); i++) {
				buildStr += map.get(pattern.charAt(i));
				if (i != pattern.length() -1) {
					buildStr += " "; // add spaces except on last iteration
				}
			}
			if (buildStr.equals(str)) {
				return true;
			}
			else {
				return false;
			}

		}
		else {
			return false;
		}
	}
}

