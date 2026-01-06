package KI304.Yunko.Lab5;

/**
 * Клас Equations реалізує предметну область "Обчислення виразу".
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

        double y = Math.sin(rad) / denominator;

        return y;
    }
}