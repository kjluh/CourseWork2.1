import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class ServicePlanner {

    protected static Repeatability repeatability(int repeatability) {
        Repeatability x = null;
        if (repeatability == 1) {
            x = Repeatability.single;
        } else if (repeatability == 2) {
            x = Repeatability.daily;
        } else if (repeatability == 3) {
            x = Repeatability.weekly;
        } else if (repeatability == 4) {
            x = Repeatability.monthly;
        } else if (repeatability == 5) {
            x = Repeatability.annual;
        }
        return x;
    }

    protected static void getRemoteTask(Scanner scanner) {
        Collection<Task> baseRemoteTask = DailyPlanner.planer.values();
        System.out.println("Список удаленных задач: ");
        for (Task task : baseRemoteTask) {
            if (task.getRemote()) {
                System.out.println(task);
            }
        }
    }

    protected static void getTaskForDate(Scanner scanner) {
        LocalDate taskDate = LocalDate.parse(scanner.next());
        getDate(taskDate);
    }

    protected static void getDate(LocalDate localDate) {
        var baseTaskForDate = DailyPlanner.planer.values();
        for (Task task : baseTaskForDate) {
            if (task.getRepeatability().equals(Repeatability.single) && task.getTimeCreateTask().equals(localDate) && !task.getRemote()) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.daily) && !task.getRemote() && task.getDay(localDate)) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.weekly) && task.getWeek(localDate) && !task.getRemote()) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.monthly) && task.getMonth(localDate) && !task.getRemote()) {
                System.out.println("На эту дату есть задачи: " + task);
            } else if (task.getRepeatability().equals(Repeatability.annual) && task.getYear(localDate) && !task.getRemote()) {
                System.out.println("На эту дату есть задачи: " + task);
            }
        }
    }


    protected static void remove(Scanner scanner) {
        System.out.println("Введите номер задачи которую нужно удалить (нумерация с 1) ");
        int taskId = scanner.nextInt();
        Main.PLANNER.removeTask(taskId);
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
}
