package KI304.Yunko.Lab4;

import java.util.Scanner;
import java.io.*;

import static java.lang.System.out;

/**
 * Клас EquationsApp є головним класом (драйвером) для лабораторної роботи №4.
 * Програма:
 * <ul>
 * <li>Запускає процес обчислення виразу y = sin(x) / (x + tg(x)).</li>
 * <li>Запитує у користувача вхідне значення X (у градусах).</li>
 * <li>Запитує у користувача ім'я файлу (автоматично додає .txt).</li>
 * <li>Викликає метод calculate() класу Equations для обчислення.</li>
 * <li>Обробляє виняткові ситуації (помилки обчислень, помилки файлу).</li>
 * <li>Записує результат (або помилку) у файл та дублює у консоль.</li>
 * </ul>
 *
 * @author Maksym Yunko
 * @version 1.0
 */
public class EquationsApp {

    /**
     * Головний метод програми.
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        PrintWriter fout = null;
        Scanner in = new Scanner(System.in);
        
        try {
            out.print("Enter file name: ");
            String fName = in.nextLine();
            
            if (!fName.toLowerCase().endsWith(".txt")) {
                fName += ".txt";
            }
            out.println("Saving to file: " + fName);
            
            fout = new PrintWriter(new File(fName));
            
            try {
                Equations eq = new Equations();
                out.print("Enter X (in degrees): ");
                int x = in.nextInt();
                double result = eq.calculate(x);

                String resultString = String.format(
                        "Result for y = sin(x) / (x + tg(x)):\n" +
                        "X = %d°\n" +
                        "Y = %f", x, result);
                
                out.println(resultString);
                fout.print(resultString);

            } catch (CalcException ex) {
                String errorMsg = ex.getMessage();
                out.println(errorMsg);
                fout.print(errorMsg);
                
            } catch (Exception ex) {
                String errorMsg = "An unexpected error occurred during calculation: " + ex.getMessage();
                out.println(errorMsg);
                fout.print(errorMsg);
            }
        } catch (FileNotFoundException ex) {
            out.print("Exception reason: Perhaps wrong file path or access error. File not created.");
            
        } catch (Exception ex) {
            out.print("A critical error occurred: " + ex.getMessage());
        }
        finally {
            if (fout != null) {
                fout.flush();
                fout.close();
            }
            in.close();
        }
    }
}