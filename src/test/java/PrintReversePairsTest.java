import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by admin on 6/11/2017.
 */
public class PrintReversePairsTest {

    PrintReversePairs printReversePairs = new PrintReversePairs();

    @Test (expected = FileNotFoundException.class)
    public void testFileDoesNotExist() throws FileNotFoundException{

        //Given
        printReversePairs.printReverseWords("this is not a valid file path");
    }

    @Test (expected = FileNotFoundException.class)
    public void testNoFileGiven() throws FileNotFoundException{
        //Given
        printReversePairs.printReverseWords("");
    }

    @Test
    public void testFileNotAccessable(){

    }

    @Test
    public void testFileNotATextFile(){
        // currently works for image file types
    }

    @Test
    public void testBlankTextFile(){

    }

    @Test
    public void testFileWithDuplicateWords(){

    }

    @Test
    public void testWordsAreSortedByLength(){

    }
}
