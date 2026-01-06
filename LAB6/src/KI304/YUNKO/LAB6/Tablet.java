package KI304.YUNKO.LAB6;

/**
 * Клас Tablet, що представляє планшет.
 * @author Yunko
 * @version 1.0
 */
public class Tablet implements Item {
    
    private String model;
    private int sizeInMm;

    /**
     * Конструктор планшета.
     * @param model модель планшета
     * @param sizeInMm товщина планшета в міліметрах
     */
    public Tablet(String model, int sizeInMm) {
        this.model = model;
        this.sizeInMm = sizeInMm;
    }

    /**
     * Отримує розмір планшета.
     * @return товщина в міліметрах
     */
    public int getSize() {
        return sizeInMm;
    }

    /**
     * Порівнює цей планшет з іншим предметом за розміром.
     * @param other інший предмет
     * @return результат порівняння
     */
    public int compareTo(Item other) {
        Integer s = sizeInMm;
        return s.compareTo(other.getSize());
    }

    /**
     * Виводить дані про планшет.
     */
    public void print() {
        System.out.println("Планшет '" + model + "' (Товщина: " + sizeInMm + " мм)");
    }
}