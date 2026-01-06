package KI304.YUNKO.LAB6;

/**
 * Головний клас для запуску програми.
 * @author Yunko
 * @version 1.0
 */
public class Lab6Driver {
    
    /**
     * Точка входу в програму.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Nightstand<? super Item> nightstand = new Nightstand<Item>();
        
        System.out.println("--- Наповнюємо тумбочку ---");
        nightstand.addItem(new Book("Кобзар", 45));
        nightstand.addItem(new Tablet("iPad Air", 6));
        nightstand.addItem(new Book("Енциклопедiя", 120));
        nightstand.addItem(new Tablet("Старий Samsung", 12));

        System.out.println();
        
        Item maxItem = (Item) nightstand.findMax();
        System.out.print("Найбiльший предмет у тумбочцi: ");
        if (maxItem != null) {
            maxItem.print();
        }

        System.out.println();
        
        System.out.println("--- Видаляємо другий елемент ---");
        nightstand.deleteItem(1); 
        
        System.out.println();

        Item newMax = (Item) nightstand.findMax();
        System.out.print("Найбiльший предмет пiсля видалення: ");
        if (newMax != null) {
            newMax.print();
        }
    }
}