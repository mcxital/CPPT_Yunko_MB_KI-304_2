package KI304.Yunko.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**

* Клас GasMask демонструє предметну область "Протигаз".
* Програма:
* <ul>
* <li>створює об'єкт протигаза з трьома складовими частинами</li>
* <li>має кілька конструкторів</li>
* <li>містить методи для тестування роботи протигаза</li>
* <li>всі дії записуються у лог-файл</li>
* </ul>
*
* @author Maksym Yunko
* @version 1.0
  */
  public class GasMask {

  /** Фільтр протигаза */
  private Filter filter;

  /** Ремені кріплення */
  private Strap strap;

  /** Корпус протигаза */
  private Body body;

  /** Лог-файл для запису дій */
  private FileWriter logWriter;

  /**

  * Конструктор за замовчуванням
    */
    public GasMask() {
    this.filter = new Filter("Standard Filter");
    this.strap = new Strap("Elastic Strap");
    this.body = new Body("Plastic Body");
    initLog("GasMaskLog.txt");
    logAction("Gas mask created using default constructor.");
    }

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
  private void initLog(String filename) {
  try {
  logWriter = new FileWriter(filename, true);
  } catch (IOException e) {
  System.out.println("Error creating log file: " + e.getMessage());
  }
  }

  /** Логування дії у файл */
  private void logAction(String action) {
  String message = LocalDateTime.now() + ": " + action;
  System.out.println(message);
  try {
  logWriter.write(message + "\n");
  logWriter.flush();
  } catch (IOException e) {
  System.out.println("Error writing to log: " + e.getMessage());
  }
  }

  /** Одягаємо протигаз */
  public void wear() {
  logAction("Gas mask worn.");
  }

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

  /** Додаткові методи для демонстрації */
  public void showStatus() {
  logAction("Gas mask status: Filter=" + filter.getType() + ", Strap=" + strap.getType() + ", Body=" + body.getType());
  }

  /** Внутрішній клас Фільтр */
  private class Filter {
  private String type;
  public Filter(String type) { this.type = type; }
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
  }

  /** Внутрішній клас Ремені */
  private class Strap {
  private String type;
  public Strap(String type) { this.type = type; }
  public String getType() { return type; }
  }

  /** Внутрішній клас Корпус */
  private class Body {
  private String type;
  public Body(String type) { this.type = type; }
  public String getType() { return type; }
  }
  }
