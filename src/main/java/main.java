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
        int wordLen;

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
            StringBuilder reverse = new StringBuilder(currentWord).reverse();
            wordLen = currentWord.length();

            i.remove(); // called before looping through the whole treeSet

            for (String w: inputWords) {
                if (wordLen == reverse.length()){
                    if (w.equals(reverse)){
                        System.out.println(w + " : " + reverse);
                        break;
                    }
                } else {
                    break;
                }
            }

            System.out.println(currentWord);
            System.out.println("----------------");

        }

    }

}
