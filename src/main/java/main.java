import java.util.*;

/**
 * Created by admin on 6/9/2017.
 */
public class main {



    public static void main(String[] args){

        Scanner sc = new Scanner("chive is cute");
        while (sc.hasNext()) {
            String i = sc.next();
            System.out.println(i);
            System.out.println("---");
        }

        StringBuilder reverse = new StringBuilder("hello world").reverse();
        System.out.println(reverse);

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
