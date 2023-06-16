package Toys;


import java.io.IOException;
import java.io.FileWriter;
import java.util.PriorityQueue;

public class ToyLottery {
    private PriorityQueue<Toy> toyQueue;
    private static final int TOTAL_GET_CALLS = 10;

    // Конструктор класса ToyLottery. Он инициализирует коллекцию toyQueue типа PriorityQueue,
   // которая будет хранить игрушки
    public ToyLottery() {
        toyQueue = new PriorityQueue<>();
    }
    //метод добавляет игрушку в коллекцию toyQueue.
    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }
    // метод выбирает игрушку в соответствии со случайным числом random и их весами.
    private Toy getToy(int random) {
        int cumulativeWeight = 0;
        int totalWeight = toyQueue.stream().mapToInt(Toy::getFrequency).sum();

        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getFrequency();
            if (random <= (cumulativeWeight * 100 / totalWeight)) {
                return toy;
            }
        }
        return null;
    }
    // Метод запускает процесс розыгрыша. Он открывает файл "results.txt" для записи результатов и выполняет 10 раз
    // вызов метода getToy, чтобы выбрать случайные игрушки в соответствии с их весами. Результаты записываются
    // в файл "results.txt", а затем файл закрывается.
    public void runLottery() {
        try (FileWriter fileWriter = new FileWriter("results.txt")) {
            for (int i = 0; i < TOTAL_GET_CALLS; i++) {
                int random = (int) (Math.random() * 100) + 1;
                Toy toy = getToy(random);
                fileWriter.write(toy.getName() + "\n");
            }
            System.out.println("Лотерея проведена и результаты записаны в файл 'results.txt' ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
