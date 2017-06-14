//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import supportClasses.compareLength;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by admin on 6/10/2017.
 */
public class PrintReversePairs {

//    private final Logger slf4jLogger = LoggerFactory.getLogger(PrintReversePairs.class);

    // TreeSet is used because it automatically removes duplicate words and is compatible with comparator and iterator.
    // Use of compareLength sorts the words automatically and allows use of an efficiency improving technique later on.
    private Set<String> inputWords = new TreeSet<String>(new compareLength());

    public void printReverseWords(String filePath) throws FileNotFoundException{

        getWordsFromFile(filePath);
        generateOutput();

    }

    protected void getWordsFromFile(String filePath) throws FileNotFoundException {

        InputStream inputFile = null;

        try {
            inputFile = new BufferedInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("An unusable file path was provided" + e.getMessage() + " : " + e.getCause() );
//            slf4jLogger.error("An unusable file path was provided" + e.getMessage() + " : " + e.getCause() + " : " + e.getStackTrace() );
            throw e;
        }

        Scanner sc = new Scanner(inputFile);
        while (sc.hasNext()) {
            inputWords.add(sc.next());
        }
        sc.close();

        try {
            inputFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage() + " : " + e.getCause());
//            slf4jLogger.error(e.getMessage() + " : " + e.getCause() + " : " + e.getStackTrace());
        }
    }

    protected void generateOutput() {
        String currentWord;
        String reverseWord;
        int reverseWordLen;
        Iterator<String> i = inputWords.iterator();

        while (i.hasNext()) {
            currentWord = i.next();
            StringBuilder reverseWordBuilder = new StringBuilder(currentWord).reverse();
            reverseWord = reverseWordBuilder.toString();
            reverseWordLen = reverseWord.length();

            //This prevents the upcoming internal loop from making comparisons with words which have already gone
            //through the outer loop since these pairs have already been compared anyway. It also means each pair is
            //only reported once.
            i.remove();

            for (String w: inputWords) {

                if (w.length() == reverseWordLen){
                    if (w.equals(reverseWord)){
                        System.out.println(w + " : " + currentWord);
                        break;
                    }
                } else {
                    //Since the words are already in length order once a word is found which has a different length from
                    //the current word no more matches are possible so the loop is stopped at this point.
                    break;
                }
            }

        }
    }
}
