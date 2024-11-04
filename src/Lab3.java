// Lab3
// IO-23
// Гуща Максим

//ВАРІАНТ\\
// C11 = 2309 / 11 = (10) | Визначити клас будівельного блоку (по типу блоків в minecraft), який складається мінімум з 5-и полів

import java.util.Arrays;
import java.util.Comparator;

/**
 * Основний клас Lab3 для демонстрації роботи з об'єктами класу BuildingBlock.
 * Програма створює масив об'єктів, сортує його за кількома критеріями та виконує пошук заданого об'єкта.
 */
public class Lab3 {

    /**
     * Клас BuildingBlock представляє будівельний блок, що містить характеристики блоку, такі як тип, міцність, вага, колір та вартість.
     */
    static class BuildingBlock {
        private String type; // Тип блоку (наприклад, "Дерево", "Камінь")
        private int durability; // Міцність блоку
        private double weight; // Вага блоку
        private String color; // Колір блоку
        private double cost; // Вартість блоку

        /**
         * Конструктор для створення об'єкта BuildingBlock.
         * @param type Тип блоку.
         * @param durability Міцність блоку.
         * @param weight Вага блоку.
         * @param color Колір блоку.
         * @param cost Вартість блоку.
         */
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

        /**
         * Перевизначення методу equals для порівняння об'єктів BuildingBlock.
         * @param obj Об'єкт для порівняння.
         * @return true, якщо об'єкти рівні, інакше false.
         */
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

        /**
         * Перевизначення методу toString для відображення інформації про об'єкт у вигляді рядка.
         * @return Рядок, що містить інформацію про об'єкт.
         */
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

    /**
     * Головний метод програми, що виконує сортування масиву об'єктів BuildingBlock та пошук заданого об'єкта.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        // Створення масиву об'єктів BuildingBlock з різними характеристиками
        BuildingBlock[] blocks = {
                new BuildingBlock("Дерево", 100, 15.5, "Коричневий", 20.0),
                new BuildingBlock("Камінь", 300, 50.0, "Сірий", 35.5),
                new BuildingBlock("Золото", 200, 30.0, "Жовтий", 75.0),
                new BuildingBlock("Земля", 50, 10.0, "Коричневий", 5.0),
                new BuildingBlock("Залізо", 250, 40.0, "Сірий", 50.0)
        };

        // Сортування масиву за вагою (за зростанням) та за міцністю (за спаданням)
        Arrays.sort(blocks, Comparator.comparingDouble(BuildingBlock::getWeight)
                .thenComparing(Comparator.comparingInt(BuildingBlock::getDurability).reversed()));

        // Вивід відсортованого масиву на екран
        System.out.println("Відсортований масив:");
        for (BuildingBlock block : blocks) {
            System.out.println(block);
        }

        // Пошук заданого об'єкта в масиві
        BuildingBlock searchBlock = new BuildingBlock("Залізо", 250, 40.0, "Сірий", 50.0);
        boolean found = false;

        // Пошук об'єкта у відсортованому масиві за допомогою методу equals
        for (BuildingBlock block : blocks) {
            if (block.equals(searchBlock)) {
                found = true;
                System.out.println("Знайдений об'єкт: " + block);
                break;
            }
        }

        // Вивід результату пошуку
        if (!found) {
            System.out.println("Об'єкт не знайдений у масиві.");
        }
    }
}


// Програма створює об'єкт searchBlock, характеристики якого відповідають одному з об'єктів у масиві. Пошук виконується шляхом порівняння кожного об'єкта з цим заданим за допомогою методу equals. Якщо об'єкт знайдено, він виводиться на екран. У разі, якщо об'єкт відсутній, виводиться повідомлення про це.

// Вона демонструє можливості роботи з масивами об'єктів у Java, включаючи сортування за кількома критеріями та пошук. Вона також показує важливість перевизначення методів equals і toString для правильного порівняння та відображення об'єктів.