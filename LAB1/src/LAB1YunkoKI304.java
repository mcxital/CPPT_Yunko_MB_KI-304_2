import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**

* Клас LAB1YunkoKI304 демонструє роботу з рваними масивами у Java.
* Програма:
* <ul>
* ```
  <li>зчитує кількість рядків масиву від користувача</li>
* ```
  <li>зчитує символ для побудови</li>
* ```
  <li>створює рваний масив і заповнює його з умовою (i + j) / 2 > rows / 2</li>
* ```
  <li>виводить масив у консоль</li>
* ```
  <li>записує його вміст у текстовий файл.</li>
* </ul>
*
* @author Maksym Yunko
* @version 1.02
  */
  public class LAB1YunkoKI304 {

  /**

  * Створюємо рваний масив і заповнюємо його згідно з умовою:
  * (i + j) / 2 < rows / 2.
  *
  * @param rows   кількість рядків масиву
  * @param symbol символ для заповнення
  * @return рваний масив символів
    */
    public static char[][] buildArray(int rows, char symbol, char symbol2) {
    char[][] arr = new char[rows][]; // створюємо масив рядків
    for (int i = 0; i < rows; i++) {
        // довжина кожного рядка зменшується з кожною ітерацією
        int length = rows - i;
        arr[i] = new char[length];

        // заповнюємо рядок вибраним символом
        for (int j = 0; j < length; j++) {
            arr[i][0] = symbol2;
            arr[i][j] = symbol;
        }
    }
    return arr;
}

  /**

  * Виводимо масив у консоль.
  *
  * @param arr масив для виводу
    */
    public static void printArray(char[][] arr) {
    for (char[] row : arr) {
    for (char elem : row) {
    System.out.print(elem + " ");
    }
    System.out.println();
    }
    }

  /**

  * Записуємо масив у текстовий файл.
  *
  * @param arr  масив для запису
  * @param path шлях до файлу
  * @throws IOException якщо виникає помилка доступу до файлу
    */
    public static void writeArrayToFile(char[][] arr, String path) throws IOException {
    try (FileWriter writer = new FileWriter(path)) {
    for (char[] row : arr) {
    for (char elem : row) {
    writer.write(elem + " ");
    }
    writer.write("\n");
    }
    }
    }

  /**

  * Головна функція програми.
  *
  * @param args аргументи командного рядка (не використовуються)
    */
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // введення розміру матриці
    System.out.println("Enter matrix size:");
    int rows = in.nextInt();

    // введення символу заповнювача
    System.out.println("Enter a symbol:");
    char symbol = in.next().charAt(0);

    char symbol2 = in.next().charAt(0);

    char[][] arr = buildArray(rows, symbol, symbol2);

    printArray(arr);

    try {
    writeArrayToFile(arr, "LAB1YunkoKI304.txt");
    System.out.println("Done!");
    } catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
    }
    }
    }
