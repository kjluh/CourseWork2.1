import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    protected final static DailyPlanner PLANNER = new DailyPlanner();
    private static final ServicePlanner SERVICE_PLANNER = new ServicePlanner();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        inputTask(scanner);
                        break;
                    case 2:
                        System.out.println("Введите номер задачи для редакции: ");
                        ServicePlanner.editTask(scanner);
                        break;
                    case 3:
                        ServicePlanner.remove(scanner);
                        break;
                    case 4:
                        System.out.println(PLANNER);
                        System.out.println("Введите желаемую дату в формате : год-месяц-день ");
                        ServicePlanner.getTaskForDate(scanner);
                        break;
                    case 5:
                        ServicePlanner.getRemoteTask(scanner);
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

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи задачи: ");
        String taskDescription = scanner.next();
        TypeTask personalTack;
        System.out.print("Если задача личная ведите - 1 \nесли по работе введите - 2\n");
        int scannerPersonalTack = scanner.nextInt();
        if (scannerPersonalTack <= 1) {
            personalTack = TypeTask.personal;
        } else {
            personalTack = TypeTask.working;
        }
        System.out.print("Если задача единоразовая введите - 1\nесли ежедневная введите - 2\n" +
                "если еженедельная введите - 3 \nесли ежемесячная введите - 4 " +
                "\nесли ежегодная введите - 5\n");
        int repeatability = scanner.nextInt();
        System.out.println("Если хотите, введите желаемую дату задачи в формате год-месяц-день ");
        String dateCreate = scanner.next();
        Task example = new Task(taskName, taskDescription, personalTack, SERVICE_PLANNER.repeatability(repeatability));
        PLANNER.addDailyPlanner(example.getId(), example);
        example.setTimeCreateTask(LocalDate.parse(dateCreate));

    }
}