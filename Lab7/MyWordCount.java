package Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount implements Comparator<WordCount> {
//	public static final String fileName = "Lab7\\data\\fit.txt";
	public static final String fileName = "D:\\CTDL\\Lab 7_Set\\data\\fit.txt";
	private static List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		// TODO
		List <WordCount> re = new ArrayList<>();
		for (String w: words) {
			WordCount wc = new WordCount(w, count(w));
			if (!re.contains(wc)) 
				re.add(wc);
		}
		return re;
	}
	//trả về số lần xuất hiện của một từ
	private int count(String w) {
		// TODO Auto-generated method stub
		int result =0;
		for (String i: words) {
			if (i.equals(w))
				result++;
		}
		return result;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words (List các phần tử không trùng nhau)
	public Set<String> getUniqueWords() {
		HashSet re = new HashSet<>();
		for (WordCount wc: getWordCounts())
			if (wc.getCount()==1)
				re.add(wc.getWord());
		return re;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result (List có các phần tử có số lần đếm lớn hơn 1
	public Set<String> getDistinctWords() {
		// TODO
		Set<String> re = new HashSet<>();
		
		for(WordCount w: getWordCounts()) {
			if (w.getCount() > 1) {
				re.add(w.getWord());
			}
		}
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		// TODO
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		
		re.addAll(getWordCounts());
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		// TODO
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount o1, WordCount o2) {
				return -(o1.getWord().compareTo(o2.getWord()));
			}
		});
				
		re.addAll(getWordCounts());
		return re;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> result = new TreeSet<>(this);
        if (pattern == null) {
            result.addAll(getWordCounts());
            return result;
        } else {
            for (WordCount i : getWordCounts()) {
                String temp = i.getWord();
                if (!(temp.equals(pattern))) {
                    result.add(i);
                }
            }
        }
        return result;
	}
	
	

	@Override
	public int compare(WordCount o1, WordCount o2) {
		return o1.getWord().toUpperCase().compareTo(o2.getWord().toUpperCase());
	}
	
	public static void main(String[] args) {
		MyWordCount myWC = new MyWordCount();
        
        System.out.println(myWC.getWordCounts());
        
        System.out.println(myWC.getUniqueWords());
        
        System.out.println(myWC.getDistinctWords());
        
        System.out.println(myWC.printWordCounts());
        
        System.out.println(myWC.exportWordCountsByOccurence());
        
        System.out.println(myWC.filterWords("Dai"));
	}
}
