// Lab3
// IO-23
// Гуща Максим

//ВАРІАНТ\\
// C11 = 2309 / 11 = (10) | Визначити клас будівельного блоку (по типу блоків в minecraft), який складається мінімум з 5-и полів

import java.util.Arrays;
import java.util.Comparator;

public class Lab3 {

    // Клас будівельного блоку
    static class BuildingBlock {
        private String type; // Тип блоку (наприклад, "Дерево", "Камінь")
        private int durability; // Міцність блоку
        private double weight; // Вага блоку
        private String color; // Колір блоку
        private double cost; // Вартість блоку

        // Конструктор класу
        public BuildingBlock(String type, int durability, double weight, String color, double cost) {
            this.type = type;
            this.durability = durability;
            this.weight = weight;
            this.color = color;
            this.cost = cost;
        }

        // Геттери для доступу до полів
        public String getType() {
            return type;
        }

        public int getDurability() {
            return durability;
        }

        public double getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }

        public double getCost() {
            return cost;
        }

        // Метод для перевірки еквівалентності об'єктів
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BuildingBlock that = (BuildingBlock) obj;
            return durability == that.durability &&
                    Double.compare(that.weight, weight) == 0 &&
                    Double.compare(that.cost, cost) == 0 &&
                    type.equals(that.type) &&
                    color.equals(that.color);
        }

        // Метод для виводу інформації про об'єкт
        @Override
        public String toString() {
            return "BuildingBlock{" +
                    "type='" + type + '\'' +
                    ", durability=" + durability +
                    ", weight=" + weight +
                    ", color='" + color + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Створення масиву об'єктів BuildingBlock
        BuildingBlock[] blocks = {
                new BuildingBlock("Дерево", 100, 15.5, "Коричневий", 20.0),
                new BuildingBlock("Камінь", 300, 50.0, "Сірий", 35.5),
                new BuildingBlock("Золото", 200, 30.0, "Жовтий", 75.0),
                new BuildingBlock("Земля", 50, 10.0, "Коричневий", 5.0),
                new BuildingBlock("Залізо", 250, 40.0, "Сірий", 50.0)
        };

        // Сортування масиву за вагою за зростанням і за міцністю за спаданням
        Arrays.sort(blocks, Comparator.comparingDouble(BuildingBlock::getWeight)
                .thenComparing(Comparator.comparingInt(BuildingBlock::getDurability).reversed()));

        // Вивід відсортованого масиву
        System.out.println("Відсортований масив:");
        for (BuildingBlock block : blocks) {
            System.out.println(block);
        }

        // Пошук заданого об'єкта в масиві
        BuildingBlock searchBlock = new BuildingBlock("Залізо", 250, 40.0, "Сірий", 50.0);
        boolean found = false;
        for (BuildingBlock block : blocks) {
            if (block.equals(searchBlock)) {
                found = true;
                System.out.println("Знайдений об'єкт: " + block);
                break;
            }
        }

        if (!found) {
            System.out.println("Об'єкт не знайдений у масиві.");
        }
    }
}

// Програма створює об'єкт searchBlock, характеристики якого відповідають одному з об'єктів у масиві. Пошук виконується шляхом порівняння кожного об'єкта з цим заданим за допомогою методу equals. Якщо об'єкт знайдено, він виводиться на екран. У разі, якщо об'єкт відсутній, виводиться повідомлення про це.

// Вона демонструє можливості роботи з масивами об'єктів у Java, включаючи сортування за кількома критеріями та пошук. Вона також показує важливість перевизначення методів equals і toString для правильного порівняння та відображення об'єктів.