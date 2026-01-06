package KI304.Yunko.Lab5;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Клас Lab5App є головним класом (драйвером) для лабораторної роботи №5.
 * Програма:
 * <ul>
 * <li>Запитує у користувача вхідне значення X (у градусах).</li>
 * <li>Успішний результат або помилку записує у текстовий та двійковий файли.</li>
 * <li>Якщо запис успішний, зчитує та показує результат.</li>
 * <li>Обробляє виняткові ситуації (помилки обчислень, помилки файлу).</li>
 * </ul>
 *
 * @author Maksym Yunko
 * @version 1.1
 */
public class Lab5App {

    /**
     * Головний метод програми.
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        String textFile = "text_result.txt";
        String binaryFile = "binary_result.dat";
        
        try {
            Equations eq = new Equations();
            ResultIO io = new ResultIO();

            out.print("Enter X (in degrees): ");
            int x = in.nextInt();

            double y = eq.calculate(x);

            out.println("Original data: X = " + x + ", Y = " + y);
            out.println("----------------------------------------");

            out.println("Writing to " + textFile + "...");
            io.writeText(textFile, x, y);

            out.println("Reading from " + textFile + ":");
            out.println(io.readText(textFile));
            out.println("Text I/O test finished.");
            out.println("----------------------------------------");

            out.println("Writing to " + binaryFile + "...");
            io.writeBinary(binaryFile, x, y);

            out.println("Reading from " + binaryFile + ":");
            out.println(io.readBinary(binaryFile));
            out.println("Binary I/O test finished.");
            out.println("----------------------------------------");

        } catch (CalcException e) {
            String errorMsg = "ERROR during calculation: " + e.getMessage();
            out.println(errorMsg);
            
            try (PrintWriter fout = new PrintWriter(new File(textFile))) {
                fout.print(errorMsg);
            } catch (IOException ioEx) {
                out.println("Additionally, failed to write error to text file: " + ioEx.getMessage());
            }
            
            try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(binaryFile))) {
                dout.writeUTF(errorMsg);
            } catch (IOException ioEx) {
                out.println("Additionally, failed to write error to binary file: " + ioEx.getMessage());
            }

        } catch (IOException e) {
            String errorMsg = "ERROR during file I/O: " + e.getMessage();
            out.println(errorMsg);
            
            try (PrintWriter fout = new PrintWriter(new File(textFile))) {
                fout.print(errorMsg);
            } catch (IOException ioEx) {
                 out.println("Additionally, failed to write error to text file: " + ioEx.getMessage());
            }

        } catch (Exception e) {
            String errorMsg = "An unexpected error: " + e.getMessage();
            out.println(errorMsg);
            
            try (PrintWriter fout = new PrintWriter(new File(textFile))) {
                fout.print(errorMsg);
            } catch (IOException ioEx) {
                 out.println("Additionally, failed to write error to text file: " + ioEx.getMessage());
            }
        } finally {
            in.close();
        }
    }
}