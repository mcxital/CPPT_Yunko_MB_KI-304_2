package KI304.Yunko.Lab2;

/**
 * Клас-драйвер для демонстрації роботи класу GasMask
 */
public class GasMaskDriver {
    public static void main(String[] args) {
        GasMask gm = new GasMask("Advanced Filter", "Rubber Strap", "Metal Body");
        gm.wear();
        gm.checkFilter();
        gm.replaceFilter("Ultra Filter");
        gm.adjustStrap();
        gm.cleanBody();
        gm.showStatus();
        gm.remove();
        gm.closeLog();
        System.out.println("Testing finished.");
    }
}
