package KI304.Yunko.Lab4;

/**
 * Клас Equations реалізує предметну область "Обчислення виразу".
 * Клас:
 * <ul>
 * <li>Надає метод calculate() для обчислення виразу y = sin(x) / (x + tg(x)).</li>
 * <li>Виконує перетворення градусів у радіани.</li>
 * <li>Контролює коректність вхідних даних (ділення на нуль, недійсні аргументи).</li>
 * <li>Генерує виняток {@link CalcException} у випадку помилок обчислень.</li>
 * </ul>
 * (Спрощена версія для усунення помилок компіляції)
 *
 * @author Maksym Yunko
 * @version 1.1
 */
class Equations {

    /**
     * Метод обчислює вираз (sin(x) / (x + tg(x))).
     *
     * @param x Кут в градусах.
     * @return Результат обчислення виразу.
     * @throws CalcException Виняток, що виникає при неможливості обчислення.
     */
    public double calculate(int x) throws CalcException {
        
        if (Math.abs(x % 180) == 90) {
            throw new CalcException("Exception reason: Illegal value of X for tangent calculation (x = " + x + "°)");
        } 
        
        if (x == 0) {
             throw new CalcException("Exception reason: Division by zero at X = 0 (0/0 case)");
        }

        double rad = x * Math.PI / 180.0;
        double denominator = x + Math.tan(rad);
        
        if (denominator == 0.0) {
             throw new CalcException("Unknown reason of the exception during calculation");
        }

        double y = Math.sin(rad) / denominator;

        return y;
    }
}