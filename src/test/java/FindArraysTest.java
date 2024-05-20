import junit.framework.TestCase;
import org.example.FindArrays;

public class FindArraysTest extends TestCase {

    private FindArrays findArrays = new FindArrays();

    public void testSubArrayDoesNotExist() {

        int[] array = {1,2,3,4,5,6,7};
        int[] subArray = {8,9,10};

        int expected = -1;
        int actual = findArrays.findSubArrayIndex(array, subArray);

        assertEquals(expected, actual);
    }

    public void testSubArrayDoesExist() {

        int[] array = {1,2,3,4,5,6,7};
        int[] subArray = {3,4,5};

        int expected = 2;
        int actual = findArrays.findSubArrayIndex(array, subArray);

        assertEquals(expected, actual);
    }


    public void testFindIndexWhenSubArrayEmpty() {

        int[] array = {1,2,3,4,5,6,7};
        int[] subArray = {};

        int expected = -1;
        int actual = findArrays.findSubArrayIndex(array, subArray);

        assertEquals(expected, actual);
    }

    public void testFindIndexWhenSubArrayGreaterThanArray() {

        int[] largeArray = {1,2,3,4,5,6,7};
        int[] subArray = {4,5,6,7,8,9,10,11};

        int expected = -1;
        int actual = findArrays.findSubArrayIndex(largeArray, subArray);

        assertEquals(expected, actual);
    }



}
