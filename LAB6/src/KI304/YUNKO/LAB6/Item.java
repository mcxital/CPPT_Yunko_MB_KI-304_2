package KI304.YUNKO.LAB6;

/**
 * Інтерфейс Item, що представляє річ у тумбочці.
 * @author Yunko
 * @version 1.0
 */
public interface Item extends Comparable<Item> {
    
    /**
     * Повертає розмір предмета.
     * @return розмір у міліметрах
     */
    int getSize();
    
    /**
     * Виводить інформацію про предмет у консоль.
     */
    void print();
}