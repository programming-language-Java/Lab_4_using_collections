import java.util.*;

public class Main extends Indent {
    static String[] commands;
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<MetroStation> metroStations = new ArrayList<>();
    static String name;
    static String lineMetro;
    static int numberOfExists;
    public static MetroStation metroStation;
    static String continueEntering;

    public static void main(String[] args) {
        System.out.println("Настройка станций метро");
        commands = new String[]{
                "Добавить несколько",   // 1
                "Добавить по индексу",  // 2
                "Обновить",             // 3
                "Удалить",              // 4
                "Удалить всё",          // 5
                "Вывести всё",          // 6
                "Выйти"                 // 7
        };
        int command;
        do {
            showCommands();
            System.out.print("Введите команду: ");
            command = sc.nextInt();
            runCommand(command);
        } while (true);
    }

    public static void showCommands() {
        System.out.println("Команды\n");
        int numberCommand;
        for (int i = 0; i < commands.length; i++) {
            numberCommand = i + 1;
            System.out.println(numberCommand + " - " + commands[i]);
        }
    }

    public static void runCommand(int command) {
        showEmptyParagraph();
        if (command == 1)
            requestMetroStations();
        if (command == 2)
            addByPosition();
        if (command == 3)
            update();
        if (command == 4)
            delete();
        if (command == 5)
            deleteAll();
        if (command == 6)
            showMetroStations();
        if (command == 7)
            System.exit(0);
    }


    public static void requestMetroStations() {
        System.out.println("Введите станции метро:");
        do {
            requestMetroStation();
            metroStation = new MetroStation(name, lineMetro, numberOfExists);
            metroStations.add(metroStation);
            System.out.print("Продолжить ввод станции метро? (y/n): ");
            continueEntering = sc.next();
            showEmptyParagraph();
        } while (continueEntering.equals("y"));
    }

    public static void requestMetroStation() {
        System.out.print("Наименование: ");
        name = sc.next();
        System.out.print("Линия метро: ");
        lineMetro = sc.next();
        System.out.print("Число выходов: ");
        numberOfExists = sc.nextInt();
    }

    public static void addByPosition() {
        System.out.println("Добавление по позиции");
        requestMetroStation();
        System.out.print("Поставить в позицию: ");
        int position = sc.nextInt() - 1;
        metroStation = new MetroStation(name, lineMetro, numberOfExists);
        metroStations.add(position, metroStation);
    }

    public static void update() {
        System.out.println("Обновление");
        requestMetroStation();
        System.out.print("Заменить позицию: ");
        int position = sc.nextInt() - 1;
        metroStation = new MetroStation(name, lineMetro, numberOfExists);
        metroStations.set(position, metroStation);
    }

    public static void delete() {
        System.out.println("Удаление");
        System.out.print("Удалить позицию: ");
        int position = sc.nextInt() - 1;
        metroStations.remove(position);
    }

    public static void deleteAll() {
        System.out.println("Удалено всё");
        metroStations.clear();
    }

    public static void showMetroStations() {
        System.out.println("Станции метро");
        boolean isExist = false;
        int position = 1;
        for (MetroStation metroStation : metroStations) {
            showEmptyParagraph();
            System.out.println(Integer.toString(position) + metroStation);
            isExist = true;
            position++;
        }
        if (!isExist)
            System.out.println("Пусто");
        showEmptyParagraph();
    }
}

class MetroStation {
    private final String name;
    private final String lineMetro;
    private final int numberOfExits;

    MetroStation(String name, String lineMetro, int numberOfExits) {
        this.name = name;
        this.lineMetro = lineMetro;
        this.numberOfExits = numberOfExits;
    }

    @Override
    public String toString() {
        return "Наименование: " + name +
                "\nЛиния метро: " + lineMetro +
                "\nЧисло выходов  " + numberOfExits;
    }

    public String getName() {
        return name;
    }

    public String getLineMetro() {
        return lineMetro;
    }

    public int getNumberOfExits() {
        return numberOfExits;
    }
}

class Indent {
    public static void showEmptyParagraph() {
        System.out.println();
    }
}
