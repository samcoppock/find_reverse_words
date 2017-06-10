package supportClasses;

import java.util.Comparator;

/**
 * Created by admin on 6/9/2017.
 */
public class compareLength implements Comparator<String> {

    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return o1.compareTo(o2);
        }
    }

}
