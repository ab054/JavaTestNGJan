package day3;

import org.testng.annotations.Test;

public class TestsForClasses {

    @Test
    public void test001() {

        Point objectOfPoint = new Point();

        Point objectOfPoint2 = new Point(3, 4);

        objectOfPoint2.printX();

        objectOfPoint2.printY("this text came from TEST : ");

    }
}
