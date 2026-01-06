package KI304.Yunko.Lab5;

/**
 * Клас CalcException реалізує власний тип винятку для обробки помилок обчислень.
 * Клас:
 * <ul>
 * <li>Успадковується від {@link ArithmeticException} для типізації помилок.</li>
 * <li>Використовується класом {@link Equations} для інформування про
 * неможливість обчислення виразу.</li>
 * <li>Надає конструктор для передачі повідомлення про причину помилки.</li>
 * </ul>
 *
 * @author Maksym Yunko
 * @version 1.0
 */
class CalcException extends ArithmeticException {

    /**
     * Конструктор без параметрів.
     */
    public CalcException() {
    }

    /**
     * Конструктор, що приймає повідомлення про причину винятку.
     *
     * @param cause Причина винятку (повідомлення про помилку).
     */
    public CalcException(String cause) {
        super(cause);
    }
}