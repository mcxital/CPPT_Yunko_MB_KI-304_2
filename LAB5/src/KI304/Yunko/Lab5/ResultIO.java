package KI304.Yunko.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас ResultIO надає методи для запису та читання
 * результатів обчислень (вхідного X та вихідного Y)
 * у текстовому та двійковому форматах.
 *
 * @author Maksym Yunko
 * @version 1.0
 */
public class ResultIO {

    /**
     * Записує результат (x та y) у текстовий файл.
     *
     * @param fName Ім'я файлу.
     * @param x     Вхідне значення (int).
     * @param y     Результат обчислення (double).
     * @throws IOException Виняток під час помилки запису файлу.
     */
    public void writeText(String fName, int x, double y) throws IOException {
        PrintWriter fout = new PrintWriter(new File(fName));
        fout.printf("X: %d\n", x);
        fout.printf("Y: %f", y);
        fout.close();
    }

    /**
     * Читає результат (x та y) з текстового файлу.
     * Повертає відформатований рядок для тестування.
     *
     * @param fName Ім'я файлу.
     * @return Рядок з прочитаними даними.
     * @throws IOException Виняток під час помилки читання файлу.
     */
    public String readText(String fName) throws IOException {
        Scanner in = new Scanner(new File(fName));
        in.next();
        int x = in.nextInt();
        in.next();
        double y = in.nextDouble();
        in.close();

        return String.format("X: %d\nY: %f", x, y);
    }

    /**
     * Записує результат (x та y) у двійковий файл.
     *
     * @param fName Ім'я файлу.
     * @param x     Вхідне значення (int).
     * @param y     Результат обчислення (double).
     * @throws IOException Виняток під час помилки запису файлу.
     */
    public void writeBinary(String fName, int x, double y) throws IOException {
        DataOutputStream dout = new DataOutputStream(new FileOutputStream(fName));
        dout.writeInt(x);
        dout.writeDouble(y);
        dout.close();
    }

    /**
     * Читає результат (x та y) з двійкового файлу.
     * Повертає відформатований рядок для тестування.
     *
     * @param fName Ім'я файлу.
     * @return Рядок з прочитаними даними.
     * @throws IOException Виняток під час помилки читання файлу.
     */
    public String readBinary(String fName) throws IOException {
        DataInputStream din = new DataInputStream(new FileInputStream(fName));
        int x = din.readInt();
        double y = din.readDouble();
        din.close();

        return String.format("X: %d\nY: %f", x, y);
    }
}