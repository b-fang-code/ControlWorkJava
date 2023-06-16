package Toys;

public class Main {
    public static void main(String[] args) {
        ToyLottery toyLottery = new ToyLottery();
        toyLottery.addToy(new Toy(1, "Конструктор", 20));
        toyLottery.addToy(new Toy(2, "Робот", 20));
        toyLottery.addToy(new Toy(3, "Кукла", 60));

        toyLottery.runLottery();
    }
}
