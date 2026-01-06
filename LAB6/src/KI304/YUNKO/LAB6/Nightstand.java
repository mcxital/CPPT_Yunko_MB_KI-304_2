package KI304.YUNKO.LAB6;

import java.util.ArrayList;

/**
 * Параметризований клас Nightstand (Тумбочка).
 * @author Yunko
 * @version 1.0
 * @param <T> тип даних, що зберігається в тумбочці
 */
public class Nightstand<T extends Item> {
    
    private ArrayList<T> items;

    /**
     * Конструктор за замовчуванням.
     */
    public Nightstand() {
        items = new ArrayList<T>();
    }

    /**
     * Шукає предмет з максимальним розміром.
     * @return предмет з найбільшим розміром у міліметрах
     */
    public Item findMax() {
        if (items.isEmpty()) {
            return null;
        }
        Item max = null;
        for (Item item : items) {
            if (max == null || item.compareTo(max) > 0) {
            max = item;
            }
        }
        return max;
    }

    /**
     * Додає предмет у тумбочку.
     * @param item предмет для додавання
     */
    public void addItem(T item) {
        items.add(item);
        System.out.print("Покладено: ");
        item.print();
    }

    /**
     * Видаляє предмет з тумбочки за індексом.
     * @param index індекс предмета
     */
    public void deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }
}