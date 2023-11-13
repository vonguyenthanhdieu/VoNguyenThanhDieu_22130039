package Lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = ".\\src\\Lab8\\fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public MyWordCountApp() throws FileNotFoundException {
		loadData();
	}
	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		System.out.println(map);
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() {
		return this.map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		 Set<String> words = map.keySet();
		 for (String w: words) {
			 System.out.println(w + "\t"+ map.get(w) );
		 }
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		Set<String> words = map.keySet();
		for (String w: words) 
			 treeMap.put(w, map.get(w));
		System.out.print(treeMap);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp myWC = new MyWordCountApp();
		System.out.println(myWC.countDistinct());
		
		myWC.printWordCounts();
		System.out.println();
		myWC.printWordCountsAlphabet();
	}
}
