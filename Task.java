// Написать метод, который будет запрашивать у пользователя критерий фильтрации 
// и выведет ноутбуки, отвечающие фильтру.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook
// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры 
// фильтрации можно также в Map. Отфильтровать ноутбуки их первоначального множества и вывести 
// проходящие по условиям. Класс сделать в отдельном файле 
// Приветствие
// Выбор параметра
// Выбор конкретнее
// Вывод подходящих

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Task {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Asus", "15 D543MA-DM1368", 4, 1000, "Windows 10", "черный");
        Notebook nb2 = new Notebook("Acer", "Aspire 3 A315-23-R0HR", 4, 256, "Windows 10", "черный");
        Notebook nb3 = new Notebook("Lenovo", "IdeaPad 3 15IML05", 8, 1000, "Windows 11", "серый");
        Notebook nb4 = new Notebook("MSI", "Modern 15 B11-002RU", 8, 512, "Windows 11", "черный");
        Notebook nb5 = new Notebook("Apple", "MacBook Air", 8, 256, "macOS", "серый");

        HashSet<Notebook> notebooks = new HashSet<Notebook>(
                Arrays.asList(nb1, nb2, nb3, nb4, nb5));
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.println();
        System.out.println("Здравствуйте! \n" + "Введите цифру, соответствующую критерию отбора: \n");
        boolean filter = true;
        while (filter) {
            System.out.println("1 - Выбрать по ОЗУ.\n" +
                    "2 - Выбрать по объему жесткого диска.\n" +
                    "3 - Выбрать по операционной системе.\n" +
                    "4 - Выбрать по цвету.\n" +
                    "5 - Посмотреть все модели.\n" +
                    "0 - Для выхода из каталога.");    
            String operation = sc.nextLine();
            switch (operation) {
                case "1":
                    filterRAM(notebooks, sc);
                    break;
                case "2":
                    filterHardDisk(notebooks, sc);
                    break;
                case "3":
                    filterOS(notebooks, sc);
                    break;
                case "4":
                    filterColor(notebooks, sc);
                    break;
                case "5":
                    showCatalog(notebooks);
                    break;
                case "0":
                    System.out.println("До свидания!");
                    filter = false;
                    break;
                default:
                    System.out.println("Введена неправильная операция");
                    System.out.println();
                    break;
            }
        }
    }

    public static void filterRAM(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Notebook note : notebooks) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("В наличии ноутбуки с оперативной памятью "
                + ram.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");
        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterRAM(notebooks, scanner);
        }
    }

    public static void filterHardDisk(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Notebook note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("В наличии ноутбуки с объемом жесткого диска "
                + hardDisk.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите интересующее значение: ");
        String oper = scanner.nextLine();
        int filter = Integer.parseInt(oper);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Неправильное значение. Попробуйте снова");
            filterHardDisk(notebooks, scanner);
        }
    }

    public static void filterOS(HashSet<Notebook> notebooks, Scanner scanner) {
        TreeSet<String> operSystems = new TreeSet<>();
        for (Notebook note : notebooks) {
            operSystems.add(note.getOperSystem());
        }
        System.out.println();
        System.out.println("В наличии ноутбуки с операционной системой: "
                + operSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую ОС: ");
        String oper = scanner.nextLine().toUpperCase();
        if (operSystems.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getOperSystem().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой ОС. Попробуйте снова");
            filterOS(notebooks, scanner);
        }
    }

    public static void filterColor(HashSet<Notebook> notebooks, Scanner scanner){
        TreeSet<String> colors = new TreeSet<>();
        for (Notebook note: notebooks){
            colors.add(note.getColor());
        }
        System.out.println();
        System.out.println("В наличии ноутбуки следующих цветов: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий цвет: ");
        String oper = scanner.nextLine().toLowerCase();
        if (colors.contains(oper)) {
            System.out.println();
            System.out.println("Подходящие модели по вашему запросу: ");
            System.out.println();
            for (Notebook note : notebooks) {
                if (note.getColor().equals(oper)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого цвета. Попробуйте снова");
            filterColor(notebooks, scanner);
        }
    }

    public static void showCatalog(HashSet<Notebook> notebooks){
        System.out.println();
        System.out.println("Полный каталог ноутбуков: ");
        System.out.println();
        for (Notebook note : notebooks) {
                note.showInfo();
        }
    }
}
