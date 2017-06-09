import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by admin on 6/9/2017.
 */
public class main {



    public static void main(String[] args){
        System.out.println("hello world");

        SortedSet<String> inputWords = new TreeSet<String>(new compareLength());
        inputWords.add("BB");
        inputWords.add("CCC");
        inputWords.add("A");
        inputWords.add("A");
        inputWords.add("EEEEE");
        inputWords.add("DDDD");

        Iterator<String> i = inputWords.iterator();
        while (i.hasNext()) {
            String currentWord = i.next(); // must be called before you can call i.remove()
            i.remove(); // called before looping through the whole treeSet
            System.out.println(currentWord);
            System.out.println("----------------");

        }

    }

}
