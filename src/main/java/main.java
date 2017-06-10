import java.io.*;
import java.util.*;

/**
 * Created by admin on 6/9/2017.
 */
public class main {



    public static void main(String[] args) throws Exception{

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
                        System.out.println(w + " : " + reverseWord);
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
