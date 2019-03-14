package day6;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingEx6 {

    @Test
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i%2==0) System.out.println(i);
        }
    }

    @Test
    public void printHelloAtEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i%2==0) System.out.println("hello world");
        }
    }

    @Test
    public void swapTwoNumbersInArray() {
        int[] array = {1,2,3,4};
        swap(array, 1, 2);
        System.out.println(Arrays.toString(array));
    }
    private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
    }

    @Test
    public void testArrays() {
        int[] array = new int[10];
        List<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(10);
        arrayList.add(10);
        arrayList.add(10);
        arrayList.add(10);
        arrayList.add(10);
    }
}
