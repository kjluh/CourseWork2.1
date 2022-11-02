import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class ServicePlanner {

    protected static void getRemoteTask() {
        Collection<Task> baseRemoteTask = DailyPlanner.planer.values();
        System.out.println("Список удаленных задач: ");
        for (Task task : baseRemoteTask) {
            if (task.getRemote()) {
                System.out.println(task);
            }
        }
    }

    protected void getTaskForDate(Scanner scanner) {
        LocalDate taskDate = LocalDate.parse(scanner.next());
        for (Task task : DailyPlanner.planer.values()) {
            if (task.frequency(taskDate).equals(taskDate) && !task.getRemote()){
                System.out.println(task);
            }
        }
    }

    //    protected static void getDate(LocalDate localDate) {
//        Collection<Task> baseTaskForDate = DailyPlanner.planer.values();
//        for (Task task : baseTaskForDate) {
//            if (task.getRepeatability().equals(Repeatability.single) && task.getTimeCreateTask().equals(localDate) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.daily) && getDay(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.weekly) && EveryWeekTask.frequency(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.monthly) && getMonth(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            } else if (task.getRepeatability().equals(Repeatability.annual) && getYear(localDate, task) && !task.getRemote()) {
//                System.out.println("На эту дату есть задачи: " + task);
//            }
//        }
//    }
    protected void addDailyPlanner(Task task) throws TaskExeption {
        if (DailyPlanner.planer.containsKey(task.getId())) {
            throw new TaskExeption("проверьте ключ к задаче " + task.getId() + " задача с данным номером уже присутствует в ежедневнике");
        } else {
            DailyPlanner.planer.put(task.getId(), task);
        }
    }

    private static void removeTask(int count) {
        Task x = DailyPlanner.planer.get(count);
        x.setRemote(true);
        DailyPlanner.planer.put(count, x);
    }

    private static boolean getMonth(LocalDate localDate, Task task) {
        boolean q1 = false;
        LocalDate x = task.getTimeDeadLine();
        int i = 0;
        while (i < (100 * 12)) {
            if (x.equals(localDate)) {
                q1 = true;
                break;
            } else {
                x = x.plusMonths(1);
                i = i + 1;
            }
        }
        return q1;
    }

    private static boolean getYear(LocalDate localDate, Task task) {
        boolean q2 = false;
        LocalDate z = task.getTimeDeadLine();
        int i = 0;
        while (i < 100) {
            if (z.equals(localDate)) {
                q2 = true;
                break;
            } else {
                z = z.plusYears(1);
                i = i + 1;
            }
        }
        return q2;
    }

    protected static void remove(Scanner scanner) {
        System.out.println("Введите номер задачи которую нужно удалить (нумерация с 1) ");
        int taskId = scanner.nextInt();
        removeTask(taskId);
    }

    protected static void editTask(Scanner scanner) {
        int x = scanner.nextInt();
        Task example = DailyPlanner.planer.get(x);
        System.out.println("текущее значение: " + example);
        System.out.println("Введите новое название задачи: ");
        String name = scanner.next();
        example.setName(name);
        System.out.println("Введите новое описание задачи: ");
        String description = scanner.next();
        example.setDescription(description);
        DailyPlanner.planer.put(x, example);

    }

    protected void inputTask(Scanner scanner) {
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
        System.out.println("Введите желаемую дату задачи в формате год-месяц-день ");
        String dateCreate = scanner.next();

        System.out.print("Если задача единоразовая введите - 1\nесли ежедневная введите - 2\n" +
                "если еженедельная введите - 3 \nесли ежемесячная введите - 4 " +
                "\nесли ежегодная введите - 5\n");
        try {
            int repeatability = scanner.nextInt();
            Task example = null;
            if (repeatability == 1) {
                example = new SingleTask(taskName, taskDescription, personalTack);
            } else if (repeatability == 2) {
                example = new EveryDayTask(taskName, taskDescription, personalTack);
            }else if (repeatability == 3) {
                example = new EveryWeekTask(taskName, taskDescription, personalTack);
            }else if (repeatability == 4) {
                example = new EveryMonthTask(taskName, taskDescription, personalTack);
            }else if (repeatability == 5) {
                example = new EveryYaerTask(taskName, taskDescription, personalTack);
            }
            example.setTimeDeadLine(LocalDate.parse(dateCreate));
            addDailyPlanner(example);
        } catch (TaskExeption e) {
            System.out.println("У нас проблемы ");
        }
    }
}
