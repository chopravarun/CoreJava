package com.algo.string;

/**
 * This API is algorithm of Rabin and Karp. this method calculate hash of all
 * combinations of String and match it with search String hash if it matches 
 * it compare charater by charater to make sure everthing is same and return
 * starting index of string. 
 * Time Complexity : O(nm)
 * n : total length of text
 * m : length of pattern to search
 *    
 * @author vachopra
 */
public class RabinKarp {
	private final int basePrime = 101;
	char[] baseString;
	char[] searchPatten;
	long searchHash;
	long baseHash;

	public RabinKarp(String baseString) {
		super();
		this.baseString = baseString.toCharArray();
	}

	public int search(String pattern) {
		this.searchPatten = pattern.toCharArray();
		int index = 0;
		while (index < baseString.length) {
			// check if both hash same
			if (checkHash(index)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public boolean checkHash(int index) {
		if (searchHash == 0) {
			searchHash = this.calculateHash(searchPatten);
		}
		if (baseHash == 0) {
			baseHash = calculateHash(baseString);
		} else {
			baseHash = rehash(baseHash, index);
		}
		if (searchHash == baseHash) {
			return this.matchPattern(index);
		}
		return false;
	}

	public boolean matchPattern(int index) {
		boolean isMatch = true;
		for (int i = 0; i < searchPatten.length; i++) {
			if (baseString[index + i] != searchPatten[i]) {
				isMatch = false;
				break;
			}
		}
		return isMatch;
	}

	public long calculateHash(char[] arr) {
		long hash = 0;
		for (int i = 0; i < searchPatten.length; i++) {
			hash += arr[i] * (long) Math.pow(basePrime, i);
		}
		return hash;
	}

	public long rehash(long hash, int index) {
		hash = hash - baseString[index - 1];
		hash = hash / basePrime;
		hash += baseString[index + searchPatten.length - 1]
				* (long) Math.pow(basePrime, searchPatten.length - 1);
		return hash;
	}

	public static void main(String[] args) {
		RabinKarp obj = new RabinKarp("abcdef");
		int index = obj.search("de");
		System.out.println(index);
	}

}
