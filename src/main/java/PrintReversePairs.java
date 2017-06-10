import supportClasses.compareLength;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by admin on 6/10/2017.
 */
public class PrintReversePairs {

    // use of TreeSet automatically removed duplicate words
    // use of compareLength sorts the words automatically and allows use of an efficiency improving technique later on.
    private Set<String> inputWords = new TreeSet<String>(new compareLength());

    public void printReverseWords() throws FileNotFoundException{

        getWordsFromFile("C:\\work\\text_sorter\\src\\main\\artifacts\\sample.txt");
        generateOutput();

    }

    private void getWordsFromFile(String filePath) {

        InputStream inputFile = null;

        try {
            inputFile = new BufferedInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {

        }

        Scanner sc = new Scanner(inputFile);
        while (sc.hasNext()) {
            inputWords.add(sc.next());
        }
    }

    private void generateOutput() {
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
