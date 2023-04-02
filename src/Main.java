import java.util.*;

public class Main extends Indent {
    static String[] commands;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<MetroStation> metroStations = new ArrayList<>();
    static String name;
    static String lineMetro;
    static int numberOfExists;
    static MetroStation metroStation;
    static String continueEntering;
    static TreeMap tm = new TreeMap();

    public static void main(String[] args) {
        System.out.println("��������� ������� �����");
        commands = new String[]{
                "�������� ���������",                   // 1
                "�������� �� �������",                  // 2
                "��������",                             // 3
                "�������",                              // 4
                "��������",                             // 5
                "������� ��",                          // 6
                "�������� ��������� � ���������",       // 7
                "�������� � ���������",                 // 8
                "������� ���������",                    // 9
                "������� �� ���������",                 // 10
                "������� �� ���������",                 // 11
                "�������� ���������",                   // 12
                "�����"                                 // 13
        };
        int command;
        do {
            showCommands();
            System.out.print("������� �������: ");
            command = sc.nextInt();
            runCommand(command);
        } while (true);
    }

    public static void showCommands() {
        System.out.println("�������\n");
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
        else if (command == 2)
            addByPosition();
        else if (command == 3)
            update();
        else if (command == 4)
            delete();
        else if (command == 5)
            deleteAll();
        else if (command == 6)
            showMetroStations();
        else if (command == 7)
            addSomeToCollection();
        else if (command == 8)
            addToCollection();
        else if (command == 9)
            showCollection();
        else if (command == 10)
            showFromCollection();
        else if (command == 11)
            removeFromCollection();
        else if (command == 12)
            deleteCollection();
        else if (command == 13)
            System.exit(0);
    }

    public static void addSomeToCollection() {
        System.out.println("������� ������ �����, ������� ��������� � ���������:");
        do {
            requestMetroStation();
            tm.put(name, new MetroStation(name, lineMetro, numberOfExists));
            System.out.print("���������� ���� ������� �����? (y/n): ");
            continueEntering = sc.next();
            showEmptyParagraph();
        } while (continueEntering.equals("y"));
    }


    public static void requestMetroStations() {
        System.out.println("������� ������� �����:");
        do {
            requestMetroStation();
            metroStation = new MetroStation(name, lineMetro, numberOfExists);
            metroStations.add(metroStation);
            System.out.print("���������� ���� ������� �����? (y/n): ");
            continueEntering = sc.next();
            showEmptyParagraph();
        } while (continueEntering.equals("y"));
    }

    public static void requestMetroStation() {
        System.out.print("������������: ");
        name = sc.next();
        System.out.print("����� �����: ");
        lineMetro = sc.next();
        System.out.print("����� �������: ");
        numberOfExists = sc.nextInt();
    }

    public static void addByPosition() {
        System.out.println("���������� �� �������");
        requestMetroStation();
        System.out.print("��������� � �������: ");
        int position = sc.nextInt() - 1;
        metroStation = new MetroStation(name, lineMetro, numberOfExists);
        metroStations.add(position, metroStation);
    }

    public static void update() {
        System.out.println("����������");
        requestMetroStation();
        System.out.print("�������� �������: ");
        int position = sc.nextInt() - 1;
        metroStation = new MetroStation(name, lineMetro, numberOfExists);
        metroStations.set(position, metroStation);
    }

    public static void delete() {
        System.out.println("��������");
        System.out.print("������� �������: ");
        int position = sc.nextInt() - 1;
        metroStations.remove(position);
    }

    public static void deleteAll() {
        System.out.println("������� ��");
        metroStations.clear();
    }

    public static void showMetroStations() {
        System.out.println("������� �����");
        boolean isExist = false;
        int position = 1;
        for (MetroStation metroStation : metroStations) {
            showEmptyParagraph();
            System.out.println(position + "\n" + metroStation);
            isExist = true;
            position++;
        }
        if (!isExist)
            System.out.println("�����");
        showEmptyParagraph();
    }

    public static void addToCollection() {
        System.out.println("�������� � ��������� �����:");
        requestMetroStation();
        tm.put(name, new MetroStation(name, lineMetro, numberOfExists));
    }

    public static void showCollection() {
        System.out.println("���������");
        Set set = tm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            showEmptyParagraph();
            Map.Entry me = (Map.Entry) i.next();
            System.out.println(me.getKey() + ":");
            System.out.println(me.getValue());
        }
        showEmptyParagraph();
    }

    public static void showFromCollection() {
        System.out.print("������������ ����� � ���������: ");
        name = sc.next();
        System.out.println("��������\n" + tm.get(name));
    }

    public static void removeFromCollection() {
        System.out.print("������� ����� �� ���������: ");
        name = sc.next();
        tm.remove(name);
    }

    public static void deleteCollection() {
        System.out.println("��������� �������");
        tm.clear();
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
        return "������������: " + name +
                "\n����� �����: " + lineMetro +
                "\n����� �������  " + numberOfExits;
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
