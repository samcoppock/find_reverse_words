import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by admin on 6/10/2017.
 */
public class PrintReversePairs {

    public void printReverseWords() throws FileNotFoundException{
        PrintReversePairs printReversePairs = new PrintReversePairs();


        SortedSet<String> inputWords = new TreeSet<String>(new compareLength());
        String filePath = "C:\\work\\text_sorter\\src\\main\\artifacts\\sample.txt";
        InputStream inputFile = null;
        String currentWord;
        String reverseWord;
        int reverseWordLen;

        try {
            inputFile = new BufferedInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {

        }

        Scanner sc = new Scanner(new FileInputStream(filePath));
        while (sc.hasNext()) {
            inputWords.add(sc.next());
        }



        Iterator<String> i = inputWords.iterator();
        while (i.hasNext()) {
            currentWord = i.next();
            StringBuilder reverseWordBuilder = new StringBuilder(currentWord).reverse();
            reverseWord = reverseWordBuilder.toString();
            reverseWordLen = reverseWord.length();

            i.remove(); // called before looping through the whole treeSet

            for (String w: inputWords) {
                if (w.length() == reverseWordLen){
                    if (w.equals(reverseWord)){
                        System.out.println(w + " : " + currentWord);
                        System.out.println("");
                        break;
                    }
                } else {
                    break;
                }
            }

        }
    }
}
