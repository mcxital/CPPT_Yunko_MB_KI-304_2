package KI304.Yunko.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
* Абстрактний клас GasMask демонструє предметну область "Протигаз".
* Програма:
* <ul>
* <li>описує базову структуру протигаза (фільтр, ремені, корпус)</li>
* <li>забезпечує механізми логування дій</li>
* <li>використовується як суперклас для розширення у підкласах</li>
* </ul>
*
* @author Maksym Yunko
* @version 2.0
*/
public abstract class GasMask {

    /** Фільтр протигаза */
    protected Filter filter;

    /** Ремені кріплення */
    protected Strap strap;

    /** Корпус протигаза */
    protected Body body;

    /** Лог-файл для запису дій */
    protected FileWriter logWriter;

    /**
    * Конструктор з параметрами
    * @param filterType тип фільтра
    * @param strapType тип ременів
    * @param bodyType тип корпусу
    */
    public GasMask(String filterType, String strapType, String bodyType) {
        this.filter = new Filter(filterType);
        this.strap = new Strap(strapType);
        this.body = new Body(bodyType);
        initLog("GasMaskLog.txt");
        logAction("Gas mask created with parameters.");
    }

    /** Ініціалізація лог-файлу */
    protected void initLog(String filename) {
        try {
            logWriter = new FileWriter(filename, true);
        } catch (IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
        }
    }

    /** Логування дії у файл */
    protected void logAction(String action) {
        String message = LocalDateTime.now() + ": " + action;
        System.out.println(message);
        try {
            logWriter.write(message + "\n");
            logWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing to log: " + e.getMessage());
        }
    }

    /** Абстрактний метод використання протигаза */
    public abstract void use();

    /** Знімаємо протигаз */
    public void remove() {
        logAction("Gas mask removed.");
    }

    /** Перевірка фільтра */
    public void checkFilter() {
        logAction("Checking filter: " + filter.getType());
    }

    /** Заміна фільтра */
    public void replaceFilter(String newFilter) {
        filter.setType(newFilter);
        logAction("Filter replaced with: " + newFilter);
    }

    /** Регулювання ременів */
    public void adjustStrap() {
        logAction("Straps adjusted: " + strap.getType());
    }

    /** Очистка корпусу */
    public void cleanBody() {
        logAction("Body cleaned: " + body.getType());
    }

    /** Закриваємо лог-файл */
    public void closeLog() {
        try {
            if (logWriter != null) logWriter.close();
        } catch (IOException e) {
            System.out.println("Error closing log file: " + e.getMessage());
        }
    }

    /** Додатковий метод для демонстрації */
    public void showStatus() {
        logAction("Gas mask status: Filter=" + filter.getType() + ", Strap=" + strap.getType() + ", Body=" + body.getType());
    }

    /** Внутрішній клас Фільтр */
    protected class Filter {
        private String type;
        public Filter(String type) { this.type = type; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
    }

    /** Внутрішній клас Ремені */
    protected class Strap {
        private String type;
        public Strap(String type) { this.type = type; }
        public String getType() { return type; }
    }

    /** Внутрішній клас Корпус */
    protected class Body {
        private String type;
        public Body(String type) { this.type = type; }
        public String getType() { return type; }
    }
}
