package KI304.Yunko.Lab3;

/**
* Клас CommanderGasMask розширює абстрактний клас {@link GasMask}
* та реалізує інтерфейс {@link Maintainable}.
* Програма:
* <ul>
* <li>створює об'єкт командирського протигаза з додатковими функціями зв'язку</li>
* <li>успадковує базові властивості звичайного протигаза</li>
* <li>реалізує методи для використання, обслуговування та передачі команд</li>
* <li>всі дії записуються у лог-файл</li>
* </ul>
*
* @author Maksym
* @version 1.0
*/
public class CommanderGasMask extends GasMask implements Maintainable {

    /** Система зв’язку протигаза командира */
    private String communicationSystem;

    /**
    * Конструктор з параметрами
    * @param filterType тип фільтра
    * @param strapType тип ременів
    * @param bodyType тип корпусу
    * @param communicationSystem тип системи зв’язку
    */
    public CommanderGasMask(String filterType, String strapType, String bodyType, String communicationSystem) {
        super(filterType, strapType, bodyType);
        this.communicationSystem = communicationSystem;
        logAction("Commander gas mask created with communication system: " + communicationSystem);
    }

    /**
    * Використання командирського протигаза
    * <p>Метод активує протигаз та вмикає систему зв’язку</p>
    */
    @Override
    public void use() {
        logAction("Commander gas mask activated. Communication system online: " + communicationSystem);
    }

    /**
    * Виконання технічного обслуговування
    * <p>Перевіряються система зв’язку, ремені та фільтр</p>
    */
    @Override
    public void performMaintenance() {
        logAction("Performing maintenance on commander gas mask — checking communication and filters.");
    }

    /**
    * Надсилання команди через систему зв’язку
    * @param message текст команди
    */
    public void sendCommand(String message) {
        logAction("Command sent via communication system: \"" + message + "\"");
    }
}
