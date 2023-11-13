package Lab8;

import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	
	public void load(String fileName) {
		try {
			TextFileUtils.readText(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if(!map.containsKey(word)) {
			map.put(word, new ArrayList<Integer>());
		}
		map.get(word).add(position);
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		ArrayList<String> sortedWords = new ArrayList<>(map.keySet());
        Collections.sort(sortedWords);

        System.out.println("Word\tWord Position(s)");
        System.out.println("===========================");

        for (String word : sortedWords) {
            ArrayList<Integer> positions = map.get(word);
            System.out.print(word + "\t");
            for (int i = 0; i < positions.size(); i++) {
                int position = positions.get(i);
                System.out.print(position);
                if (position < 0) {
                    System.out.print(" (end of line)");
                }
                if (i < positions.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		StringBuilder text = new StringBuilder();

        List<String> sortedWords = new ArrayList<>(map.keySet());
        sortedWords.sort(String:: compareToIgnoreCase);

        for (String word : sortedWords) {
            List<Integer> positions = map.get(word);
            for (int position : positions) {
                text.append(word);

                if (position < 0) {
                    text.append(System.lineSeparator());
                } else {
                    text.append(" ");
                }
            }
        }

        System.out.println(text.toString());
    }
	

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String mostFrequentWord = "";
        int maxFrequency = 0;
        for (String word : map.keySet()) {
            int frequency = map.get(word).size();
            if (frequency > maxFrequency) {
                mostFrequentWord = word;
                maxFrequency = frequency;
            }
        }
        return mostFrequentWord;
	}
	public static void main(String[] args) {
		TextAnalyzer ta = new TextAnalyzer();
		ta.load(".\\src\\Lab8\\short.txt");
		
		System.out.println("===============");
		ta.add("Lam", 2);
		ta.add("Nong", 0);
		ta.add("Nong", 4);
		
		ta.displayWords();
		ta.displayText();
		System.out.println(ta.mostFrequentWord());
	}

}
