package day3;

public class Point {

    int x;
    int y;

    public Point() {
        System.out.println("Constructor with no arguments called");
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

        System.out.println("field value X=" + this.x + " and value y=" + this.y);
    }

    public void printX(){
        System.out.println("field value X=" + this.x);
    }

    void printY(String textToPrint){
        System.out.println(textToPrint + this.y);
    }
}
