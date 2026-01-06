package KI304.Yunko.Lab3;

/**
* Клас Main демонструє роботу підкласу {@link CommanderGasMask}.
* Програма:
* <ul>
* <li>створює об’єкт командирського протигаза</li>
* <li>імітує його використання, техобслуговування та передачу команд</li>
* <li>записує всі події у лог-файл</li>
* </ul>
*
* @author Maksym
* @version 1.0
*/
public class Main {

    /**
    * Точка входу в програму
    * @param args аргументи командного рядка
    */
    public static void main(String[] args) {
        CommanderGasMask mask = new CommanderGasMask(
            "Carbon Filter",
            "Reinforced Strap",
            "Titanium Body",
            "RadioLink V2"
        );

        mask.use();
        mask.sendCommand("--.");
        mask.performMaintenance();
        mask.showStatus();
        mask.closeLog();
    }
}
