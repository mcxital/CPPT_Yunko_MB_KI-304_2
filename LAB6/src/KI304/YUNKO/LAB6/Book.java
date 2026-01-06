package KI304.YUNKO.LAB6;

/**
 * Клас Book, що представляє книгу.
 * @author Yunko
 * @version 1.0
 */
public class Book implements Item {
    
    private String name;
    private int sizeInMm;

    /**
     * Конструктор книги.
     * @param name назва книги
     * @param sizeInMm товщина книги в міліметрах
     */
    public Book(String name, int sizeInMm) {
        this.name = name;
        this.sizeInMm = sizeInMm;
    }

    /**
     * Отримує розмір книги.
     * @return товщина в міліметрах
     */
    public int getSize() {
        return sizeInMm;
    }

    /**
     * Порівнює цю книгу з іншим предметом за розміром.
     * @param other інший предмет
     * @return результат порівняння
     */
    public int compareTo(Item other) {
        Integer s = sizeInMm;
        return s.compareTo(other.getSize());
    }

    /**
     * Виводить дані про книгу.
     */
    public void print() {
        System.out.println("Книга '" + name + "' (Товщина: " + sizeInMm + " мм)");
    }
}