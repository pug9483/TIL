package singleton;

public class StatefulService {
//    private int price;

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; -> 문제 지점
        return price;
    }
}
