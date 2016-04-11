import java.io.*;
import java.util.HashSet;
import java.util.Set;

/*Conor Sweeney
 * cjs2201
 * SpellChecker.java
*/
public class SpellChecker {

	//declare variables
	//files in this program are kept in the src folder
    private static final File dictionaryWords = new File("src/words.txt");
    private static final File testDocument = new File("src/filetospellcheck.txt");
    private BufferedReader reader;
	private BufferedReader testReader;

	//void method to check the spelling of words
	//it prints out all misspelling, line numbers, and suggestions,
	
    void checkSpelling() throws IOException {
        Set<String> words = readDictionary();
        InputStream testStream = new FileInputStream(testDocument);
        try {
        	testReader = new BufferedReader(new InputStreamReader(testStream, "UTF-8"));
            String tempString;
            Integer lineNumber = 0;
            while ((tempString = testReader.readLine()) != null) {
            	lineNumber++;
            	String lowerCaseString = tempString.toLowerCase();
            	for (String word : lowerCaseString.split(" ")) {
            		if(!words.contains(word)){
            			System.out.println(lineNumber+": " + word + " is not in the dictionary\nSuggestions:");
                        
                        //check if a character needs to be added for it to be a word
                        for(int i = 0; i <= word.length(); i++){
                        	
                        	//declare a local array with all the letters of the alphabet so they can be added to create a new word to check
                        	String[] letterArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z"};
                        	
                        	for(String letter: letterArray){
                        		String newWord = word.substring(0,i) + letter + word.substring(i);
                        		if(words.contains(newWord)){
                        			System.out.println(newWord);
                        		}
                        	}
                        }
                        
                        //check if a character needs to be removed for it to be a word
                        for(int i = 0; i< word.length();i++){
                        	String newWord = word.substring(0,i) + word.substring(i+1);
                        	if(words.contains(newWord)){
                    			System.out.println(newWord);
                    		}
                        }
                        
                        //check if characters need to be swapped to be a word
                        for(int i=0; i<word.length()-1; i++){
                        	String newWord = word.substring(0,i) +word.substring(i+1,i+2) + word.substring(i,i+1) + word.substring(i+2);
                        	if(words.contains(newWord)){
                    			System.out.println(newWord);
                    		}
                        }
            		}
            	}
            }
        }
        finally {
        	testStream.close();
        }
    }

    //creates a dictionary using a HashSet
    private Set<String> readDictionary() throws IOException {      
    	Set<String> words = new HashSet<String>();
        InputStream stream = new FileInputStream(dictionaryWords);
        try {
            reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String word;
            while ((word = reader.readLine()) != null) {
            	
            	//convert string to lowercase
            	String lowerCaseWord = word.toLowerCase();
            	
            	//checks for duplicates since words.txt often contains words with version both with capitalization and lowercase
            	//and it only adds to the HashSet if it does not exist already
            	if(!words.contains(lowerCaseWord)){
                    words.add(lowerCaseWord);
            	}
            }
        }
        finally{
            stream.close();
        }
        return words;
    }

    public static void main(String[] args) throws IOException {
//        SpellChecker spellCheck = new SpellChecker();
//        spellCheck.checkSpelling();
    	boolean flag = false;
    	String upperCaseStr = "HELLOABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(char alphabet = 'A'; alphabet <='Z'; alphabet++) {
            if(upperCaseStr.indexOf(alphabet)==-1){
                flag=true;
                break;
            }  
        }
        if (flag){
            System.out.print("not ");
        }
        System.out.println("pangram");
    
    }
}
