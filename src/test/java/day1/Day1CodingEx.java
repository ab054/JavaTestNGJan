package day1;

import org.testng.annotations.Test;

public class Day1CodingEx {

    @Test
    public void test001(){
        System.out.println("Hello, World!");
    }

    @Test
    public void test002() {
        String helloText = "Hello, World!";

        System.out.println(helloText);
    }

    @Test
    public void test003() {
        String s1 = new String("Who let the dogs out?");
        String s2 = "Who who who who!";

        System.out.println(s1 + "   plus  " + s2);
    }

    @Test
    public void test004() {
        int num = 10;
        String s = "I have " + num + " cookies";

        System.out.println(s);
    }

    @Test
    public void test005() {
        boolean b;
        boolean toBe = false;

        b = toBe || !toBe;

        if (b) {
            System.out.println(toBe);
        }
    }

    @Test
    public void test006() {
        boolean isElementVisible = false;

        if(isElementVisible == true){
            System.out.println("click on the element");
        } else {
            System.out.println("element is NOT visible");
        }
    }

    @Test
    public void test007() {
        int a = 5;
        boolean b = a == 4;

        if (b) {
            System.out.println("It's true!");
        }
    }

    @Test
    public void test008() {
        boolean elementAisVisible = true;
        boolean elementBisVisible = false;

        if(elementAisVisible && elementBisVisible){
            System.out.println("click somewhere");
        } else  {
            System.out.println("elementAisVisible:" + elementAisVisible + " " +"elementBisVisible:" + elementBisVisible);
        }
    }

    // don't run these, it's broken
    @Test
    public void test009() {
        int a = 4;
        int result = a == 4 ? 1 : 8;


        // This is equivalent to
        // int result;

        if (a == 4) {
            result = 1;
        } else {
            result = 8;
        }
    }

    @Test
    public void test010() {
        int[] arr;
        arr = new int[10];

        arr[0] = 4;
        arr[1] = arr[0] + 5;

        if(arr[1] == 1){
            System.out.println("equal to 1");
        } else {
            System.out.println("not equal to 1");
        }
    }

    @Test
    public void test011() {
        int[] arr = {1, 2, 3, 4, 5};

        if(arr[3] == 3){
            System.out.println("equal to 3");
        } else {
            System.out.println("not equal to 3");
        }

        System.out.println(arr);
    }

    @Test
    public void test012() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int i = 0;

        for (;i < arr.length;) {
            System.out.println(arr[i]);
            i++;
        }
    }

    @Test
    public void test013() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        for(int eachElement : arr){
            System.out.println(eachElement);
        }
    }
}
