package volante.eval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
//changes directly from remote...
//changes directly from remote second change...

public class Anagram {


	public static void main(String[] args) {
		
		List<String> list = readFile();
		printAnagramWords(list);

	}

	private static void printAnagramWords(List<String> list) {
		
		HashMap<String, List<String> > map = new HashMap<>();  
		  
        for (int i = 0; i < list.size(); i++) {  
 
            String word = list.get(i);
            char[] letters = word.toCharArray();  
            Arrays.sort(letters);  
            String newWord = new String(letters);  
  
            if (map.containsKey(newWord)) {  
  
                map.get(newWord).add(word);  
            }  
            else {  
                List<String> words = new ArrayList<>();  
                words.add(word);  
                map.put(newWord, words);  
            }  
        }  
  
        for (String s : map.keySet()) {  
            List<String> values = map.get(s);  
            if (values.size() > 1) {  
                System.out.println(values);  
            }  
        }  
    }  

	/*
	 * Read the input file
	 */
	private static List<String> readFile() {
		
		String filePath = "C:\\problem\\dictionary.txt";
		List<String> wordlist = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filePath));
			while (scanner.hasNext()) { 
				String word = scanner.nextLine(); 
				wordlist.add(word);
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not avlible");
		}
		
		finally {
			scanner.close();
		}

		return wordlist;
	}

}
