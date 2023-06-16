package Toys;

// класс Игрушка
class Toy implements Comparable<Toy>{
    private int id;
    private String name;
    private int frequency;

    @Override
    public int compareTo(Toy other) {
        return Integer.compare(this.frequency, other.frequency);
    }

    //    конструктор
    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    //    геттеры для свойств
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }
}