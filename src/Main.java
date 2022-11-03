import java.time.LocalDate;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        final  DailyPlanner PLANNER = new DailyPlanner();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        PLANNER.inputTask(scanner);
                        break;
                    case 2:
                        System.out.println("Введите номер задачи для редакции: ");
                        PLANNER.editTask(scanner);
                        break;
                    case 3:
                        PLANNER.remove(scanner);
                        break;
                    case 4:
                        System.out.println("Введите желаемую дату в формате : год-месяц-день ");
                        PLANNER.getTaskForDate(scanner);
                        break;
                    case 5:
                        PLANNER.getRemoteTask();
                        break;
                    case 0:
                        break label;
                }
            } else {
                scanner.next();
                System.out.println("Выберите пункт меню из списка!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Добавить задачу " + "\n2. Редактировать задачу" +
                "\n3. Удалить задачу \n4. Получить задачу на указанный день " +
                "\n5. Получить список всех удаленных задач \n0. Выход");
    }
}